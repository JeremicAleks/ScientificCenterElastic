package com.elastic.scientificenterelastic.service.elastic;


import com.elastic.scientificenterelastic.dto.ArticleDTO;
import com.elastic.scientificenterelastic.dto.GeoSearchResponseDTO;
import com.elastic.scientificenterelastic.dto.MoreLikeThisResponeDTO;
import com.elastic.scientificenterelastic.lucene.model.BoolQuery;
import com.elastic.scientificenterelastic.lucene.model.GeoQuery;
import com.elastic.scientificenterelastic.lucene.model.ResultData;
import com.elastic.scientificenterelastic.lucene.model.SimpleQuery;

import java.util.List;

public interface SearchService {
    List<ResultData> searchTermQuery(SimpleQuery simpleQuery) throws Exception;

    List<ResultData> searchBoolean(BoolQuery boolQuery) throws Exception;

    MoreLikeThisResponeDTO searchMoreLikeThis(ArticleDTO articleDTO) throws Exception;

    GeoSearchResponseDTO geoSearch(GeoQuery geoQuery) throws Exception;
}
