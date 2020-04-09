package com.elastic.scientificenterelastic.controller.elastic;

import com.elastic.scientificenterelastic.dto.ArticleDTO;
import com.elastic.scientificenterelastic.lucene.model.BoolQuery;
import com.elastic.scientificenterelastic.lucene.model.GeoQuery;
import com.elastic.scientificenterelastic.lucene.model.ResultData;
import com.elastic.scientificenterelastic.lucene.model.SimpleQuery;
import com.elastic.scientificenterelastic.service.elastic.SearchService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SearchController {
		private final SearchService searchService;

	public SearchController(SearchService searchService) {
		this.searchService = searchService;
	}

		@PostMapping(value="/search/term", consumes="application/json")
		public ResponseEntity<List<ResultData>> searchTermQuery(@RequestBody SimpleQuery simpleQuery) throws Exception {
			return ResponseEntity.ok(searchService.searchTermQuery(simpleQuery));
		}

		@PostMapping(value="/search/boolean", consumes="application/json")
		public ResponseEntity<List<ResultData>> searchBoolean(@RequestBody BoolQuery boolQuery) throws Exception {
			return ResponseEntity.ok(searchService.searchBoolean(boolQuery));
		}

		@PostMapping(value = "/search/moreLikeThis",consumes = "application/json")
		public ResponseEntity<?> searchMlt(@RequestBody ArticleDTO articleDTO) throws Exception {
			return ResponseEntity.ok(searchService.searchMoreLikeThis(articleDTO));
		}

		@PostMapping(value = "/search/geoSearch",consumes = "application/json")
		public ResponseEntity<?> searchGeo(@RequestBody GeoQuery geoQuery) throws Exception{
			return ResponseEntity.ok(searchService.geoSearch(geoQuery));
		}




//
//		@PostMapping(value="/search/fuzzy", consumes="application/json")
//		public ResponseEntity<List<ResultData>> searchFuzzy(@RequestBody SimpleQuery simpleQuery) throws Exception {
//			org.elasticsearch.index.query.QueryBuilder query= QueryBuilder.buildQuery(SearchType.fuzzy, simpleQuery.getField(), simpleQuery.getValue());
//			List<RequiredHighlight> rh = new ArrayList<RequiredHighlight>();
//			rh.add(new RequiredHighlight(simpleQuery.getField(), simpleQuery.getValue()));
//			List<ResultData> results = resultRetriever.getResults(query, rh);
//			return new ResponseEntity<List<ResultData>>(results, HttpStatus.OK);
//		}
//
//		@PostMapping(value="/search/prefix", consumes="application/json")
//		public ResponseEntity<List<ResultData>> searchPrefix(@RequestBody SimpleQuery simpleQuery) throws Exception {
//			org.elasticsearch.index.query.QueryBuilder query= QueryBuilder.buildQuery(SearchType.prefix, simpleQuery.getField(), simpleQuery.getValue());
//			List<RequiredHighlight> rh = new ArrayList<RequiredHighlight>();
//			rh.add(new RequiredHighlight(simpleQuery.getField(), simpleQuery.getValue()));
//			List<ResultData> results = resultRetriever.getResults(query, rh);
//			return new ResponseEntity<List<ResultData>>(results, HttpStatus.OK);
//		}
//
//		@PostMapping(value="/search/range", consumes="application/json")
//		public ResponseEntity<List<ResultData>> searchRange(@RequestBody SimpleQuery simpleQuery) throws Exception {
//			org.elasticsearch.index.query.QueryBuilder query= QueryBuilder.buildQuery(SearchType.range, simpleQuery.getField(), simpleQuery.getValue());
//			List<RequiredHighlight> rh = new ArrayList<RequiredHighlight>();
//			rh.add(new RequiredHighlight(simpleQuery.getField(), simpleQuery.getValue()));
//			List<ResultData> results = resultRetriever.getResults(query, rh);
//			return new ResponseEntity<List<ResultData>>(results, HttpStatus.OK);
//		}
//
//		@PostMapping(value="/search/phrase", consumes="application/json")
//		public ResponseEntity<List<ResultData>> searchPhrase(@RequestBody SimpleQuery simpleQuery) throws Exception {
//			org.elasticsearch.index.query.QueryBuilder query= QueryBuilder.buildQuery(SearchType.phrase, simpleQuery.getField(), simpleQuery.getValue());
//			List<RequiredHighlight> rh = new ArrayList<RequiredHighlight>();
//			rh.add(new RequiredHighlight(simpleQuery.getField(), simpleQuery.getValue()));
//			List<ResultData> results = resultRetriever.getResults(query, rh);
//			return new ResponseEntity<List<ResultData>>(results, HttpStatus.OK);
//		}
//
//
//		@PostMapping(value="/search/queryParser", consumes="application/json")
//		public ResponseEntity<List<ResultData>> search(@RequestBody SimpleQuery simpleQuery) throws Exception {
//			org.elasticsearch.index.query.QueryBuilder query= QueryBuilders.queryStringQuery(simpleQuery.getValue());
//			List<RequiredHighlight> rh = new ArrayList<RequiredHighlight>();
//			List<ResultData> results = resultRetriever.getResults(query, rh);
//			return new ResponseEntity<List<ResultData>>(results, HttpStatus.OK);
//		}
//
//
	
}
