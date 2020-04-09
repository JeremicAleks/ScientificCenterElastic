package com.elastic.scientificenterelastic.service.serviceImpl.elastic;

import com.elastic.scientificenterelastic.domain.User;
import com.elastic.scientificenterelastic.dto.ArticleDTO;
import com.elastic.scientificenterelastic.dto.GeoSearchResponseDTO;
import com.elastic.scientificenterelastic.dto.MoreLikeThisResponeDTO;
import com.elastic.scientificenterelastic.helper.ResultDataHelper;
import com.elastic.scientificenterelastic.helper.SearchAndHiglihtHelper;
import com.elastic.scientificenterelastic.lucene.model.*;
import com.elastic.scientificenterelastic.lucene.search.QueryBuilder;
import com.elastic.scientificenterelastic.lucene.search.ResultRetriever;
import com.elastic.scientificenterelastic.repository.UserRepository;
import com.elastic.scientificenterelastic.service.elastic.SearchService;
import org.elasticsearch.common.geo.GeoPoint;
import org.elasticsearch.common.unit.DistanceUnit;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.MoreLikeThisQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SearchServiceImpl implements SearchService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ResultRetriever resultRetriever;

    @Override
    public List<ResultData> searchTermQuery(SimpleQuery simpleQuery) throws Exception {
        org.elasticsearch.index.query.QueryBuilder query= QueryBuilder.buildQuery(SearchType.phrase, simpleQuery.getField(), simpleQuery.getValue());
        List<RequiredHighlight> rh = new ArrayList<>();
        rh.add(new RequiredHighlight(simpleQuery.getField(), simpleQuery.getValue()));
        return resultRetriever.getResults(query, rh);
    }

    @Override
    public List<ResultData> searchBoolean(BoolQuery boolQuery) throws Exception {
        List<org.elasticsearch.index.query.QueryBuilder> queries = new ArrayList<>();
        for(BoolQueryField boolQueryField: boolQuery.getFieldsAndValue()){
            org.elasticsearch.index.query.QueryBuilder query = QueryBuilder.buildQuery(SearchType.phrase, boolQueryField.getField(), boolQueryField.getValue());
            queries.add(query);
        }
        BoolQueryBuilder builder = QueryBuilders.boolQuery();
        if(boolQuery.getOperation().equalsIgnoreCase("AND")){
            for(org.elasticsearch.index.query.QueryBuilder queryBuilder : queries ) {
                builder.must(queryBuilder);
            }
        }else if(boolQuery.getOperation().equalsIgnoreCase("OR")){
            for(org.elasticsearch.index.query.QueryBuilder queryBuilder : queries ) {
                builder.should(queryBuilder);
            }
        }else if(boolQuery.getOperation().equalsIgnoreCase("NOT")){
            for(org.elasticsearch.index.query.QueryBuilder queryBuilder : queries ) {
                builder.mustNot(queryBuilder);
            }
        }

        List<RequiredHighlight> rh = new ArrayList<>();
        for(BoolQueryField boolQueryField: boolQuery.getFieldsAndValue())
            rh.add(new RequiredHighlight(boolQueryField.getField(), boolQueryField.getValue()));
        return resultRetriever.getResults(builder, rh);
    }

    @Override
    public MoreLikeThisResponeDTO searchMoreLikeThis(ArticleDTO articleDTO) throws Exception {
        String[] searchArray = {};
        String[] fields = {"text"};

        MoreLikeThisQueryBuilder.Item[] items = {new MoreLikeThisQueryBuilder.Item("digitallibrary","article", SearchAndHiglihtHelper.getFileName(articleDTO.getFileLocation()))};

        org.elasticsearch.index.query.QueryBuilder queryBuilder = QueryBuilders.moreLikeThisQuery(fields,searchArray,items).minDocFreq(1).minTermFreq(2).analyzer("serbian-analyzer").maxQueryTerms(100);

        List<ResultData> results = resultRetriever.getResultsMoreLikeThis(queryBuilder);

        return ResultDataHelper.getMoreLikeThisResponse(results);
    }

    @Override
    public GeoSearchResponseDTO geoSearch(GeoQuery geoQuery) throws Exception {
        User author = userRepository.getOne(geoQuery.getUserId());

        org.elasticsearch.index.query.QueryBuilder queryBuilder = QueryBuilders.geoDistanceQuery("geo_point").distance(100, DistanceUnit.KILOMETERS).point(new GeoPoint(author.getLocation().getLat(),author.getLocation().getLng()));
        org.elasticsearch.index.query.QueryBuilder queryBuilderMustNot = QueryBuilders.boolQuery().mustNot(queryBuilder);

        List<ResultDataUser> resultDataList = resultRetriever.getResultsUser(queryBuilderMustNot);

        return ResultDataHelper.getGeoSearchResponse(resultDataList);
    }
}
