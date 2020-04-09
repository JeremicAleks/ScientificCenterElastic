package com.elastic.scientificenterelastic.lucene.search;

import com.elastic.scientificenterelastic.helper.SearchAndHiglihtHelper;
import com.elastic.scientificenterelastic.lucene.model.*;
import com.elastic.scientificenterelastic.repository.elastic.ArticleElasticRepository;
import com.elastic.scientificenterelastic.repository.elastic.UserElasticRepository;
import io.searchbox.client.JestClient;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ResultRetriever {

	@Autowired
	private ArticleElasticRepository repository;
	@Autowired
	private UserElasticRepository userElasticRepository;

	@Autowired
	private JestClient client;

	public ResultRetriever(){
	}

	public List<ResultData> getResults(org.elasticsearch.index.query.QueryBuilder query,
									   List<RequiredHighlight> requiredHighlights)  throws IOException {
		if (query == null) {
			return null;
		}

		List<ResultData> results = new ArrayList<>();
		Search search = new Search.Builder(SearchAndHiglihtHelper.createHighlihtSearchQuery(query).toString()).addIndex("digitallibrary").addType("article").build();

		SearchResult result = client.execute(search);
		List<SearchResult.Hit<IndexUnit, Void>> hits = result.getHits(IndexUnit.class);

			for (SearchResult.Hit<IndexUnit, Void> indexUnit : hits)
        	results.add(new
					ResultData(indexUnit.source.getText(),indexUnit.source.getTitle(),indexUnit.source.getKeywords(),indexUnit.source.getFilename(),indexUnit.source.getArticleAbstract()
			,indexUnit.source.getAuthor(),indexUnit.source.getScientificArea(),indexUnit.source.getIdArticle(),indexUnit.source.getMagazineType(),indexUnit.source.getMagazineTitle(), indexUnit.source.getStatus(), SearchAndHiglihtHelper.findHiglight(indexUnit,requiredHighlights).toString()));


		return results;
	}

	public List<ResultData> getResultsMoreLikeThis(org.elasticsearch.index.query.QueryBuilder query) throws IOException {
		if (query == null) {
			return null;
		}

		List<ResultData> results = new ArrayList<>();

		for (IndexUnit indexUnit : repository.search(query)) {
			ResultData resultData = new ResultData(indexUnit.getText(), indexUnit.getTitle(), indexUnit.getKeywords(), indexUnit.getFilename(), indexUnit.getArticleAbstract()
					, indexUnit.getAuthor(), indexUnit.getScientificArea(), indexUnit.getIdArticle(), indexUnit.getMagazineType(), indexUnit.getMagazineTitle(), indexUnit.getStatus(), "");
			resultData.setReviewers(indexUnit.getReviewers());
			results.add(resultData);
		}


		return results;
	}

	public List<ResultDataUser> getResultsUser(org.elasticsearch.index.query.QueryBuilder query)  throws IOException {
		if (query == null) {
			return null;
		}

		List<ResultDataUser> results = new ArrayList<>();

		for (IndexUnitUser indexUnitUser : userElasticRepository.search(query)) {
			results.add(new ResultDataUser(indexUnitUser.getUsername(),indexUnitUser.getFirstname(),indexUnitUser.getSurname(),indexUnitUser.getLocationName(),indexUnitUser.getLokacija(),indexUnitUser.getUserId(),indexUnitUser.getUserRole(),indexUnitUser.getGeo_point()));
		}

		return results;
	}

//	protected DocumentHandler getHandler(String fileName){
//		if(fileName.endsWith(".txt")){
//			return new TextDocHandler();
//		}else if(fileName.endsWith(".pdf")){
//			return new PDFHandler();
//		}else if(fileName.endsWith(".doc")){
//			return new WordHandler();
//		}else if(fileName.endsWith(".docx")){
//			return new Word2007Handler();
//		}else{
//			return null;
//		}
//	}
}
