package com.elastic.scientificenterelastic.helper;

import com.elastic.scientificenterelastic.lucene.model.IndexUnit;
import com.elastic.scientificenterelastic.lucene.model.RequiredHighlight;
import io.searchbox.core.SearchResult;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.regex.Pattern;

@Component
public final class SearchAndHiglihtHelper {

    public static SearchSourceBuilder createHighlihtSearchQuery(org.elasticsearch.index.query.QueryBuilder query){
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.query(query);
        searchSourceBuilder.size(10);
        HighlightBuilder highlightBuilder = new HighlightBuilder();
        highlightBuilder.field("text");
        highlightBuilder.field("title");
        highlightBuilder.field("magazineTitle");
        highlightBuilder.field("keywords");
        highlightBuilder.field("naucnaOblast");
        highlightBuilder.field("autor");
        highlightBuilder.fragmentSize(100);
        highlightBuilder.preTags("<span style='color:blue '><b>").postTags("</b></span>");
        highlightBuilder.numOfFragments(2);
        highlightBuilder.noMatchSize(50);
        searchSourceBuilder.highlighter(highlightBuilder);

        return searchSourceBuilder;
    }

    public static StringBuilder findHiglight(SearchResult.Hit<IndexUnit, Void> indexUnitVoidHit, List<RequiredHighlight> requiredHighlights){
        StringBuilder highlight = new StringBuilder();
        for (String hf : indexUnitVoidHit.highlight.keySet() ) {
            for (RequiredHighlight rh : requiredHighlights) {
                if(hf.equals(rh.getFieldName())){
                    highlight.append(indexUnitVoidHit.highlight.get(hf).toString());
                }
            }
        }
        return highlight;
    }

    public static String getFileName(String fileLocation){
        String[] filename = fileLocation.split(Pattern.quote("\\"));
        return filename[filename.length-1];
    }
}
