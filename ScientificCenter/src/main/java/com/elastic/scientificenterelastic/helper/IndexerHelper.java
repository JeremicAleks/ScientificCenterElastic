package com.elastic.scientificenterelastic.helper;


import com.elastic.scientificenterelastic.domain.Article;
import com.elastic.scientificenterelastic.domain.User;
import com.elastic.scientificenterelastic.lucene.indexing.Indexer;
import com.elastic.scientificenterelastic.lucene.model.IndexUnit;
import com.elastic.scientificenterelastic.lucene.model.IndexUnitUser;
import org.springframework.data.elasticsearch.core.geo.GeoPoint;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.regex.Pattern;

@Component
public final class IndexerHelper {
    private static Indexer indexer;

    private IndexerHelper(Indexer indexer){IndexerHelper.indexer = indexer;}

    public static IndexUnit indexFileHelper(Article article){
        IndexUnit indexUnit = indexer.getHandler(article.getFileLocation()).getIndexUnit(new File(article.getFileLocation()));
        indexUnit.setTitle(article.getTitle());
        indexUnit.setKeywords(article.getKeywords());
        indexUnit.setArticleAbstract(article.getArticleAbstract());
        indexUnit.setAuthor(article.getAuthor().getFirstname().concat(" ").concat(article.getAuthor().getSurname()));
        indexUnit.setIdArticle(article.getId().toString());
        indexUnit.setMagazineTitle(article.getMagazine().getName());
        indexUnit.setMagazineType(article.getMagazine().getMagazineType());
        indexUnit.setScientificArea(article.getScientificArea().getName());
        if(article.isActive())
        indexUnit.setStatus("active");
        else
        indexUnit.setStatus("inactive");
        String[] fileName = article.getFileLocation().split(Pattern.quote("\\"));
        indexUnit.setFilename(fileName[fileName.length-1]);
        return indexUnit;
    }

    public static IndexUnitUser indexUserHelper(User user){
        IndexUnitUser indexUnitUser = new IndexUnitUser();
        indexUnitUser.setUserId(user.getUserId().toString());
        indexUnitUser.setFirstname(user.getFirstname());
        indexUnitUser.setUsername(user.getUsername());
        indexUnitUser.setSurname(user.getSurname());
        indexUnitUser.setUserRole(user.getRoles().iterator().next().getName());
//        indexUnitUser.setLocation(user.getLocation().getLat() + "," + user.getLocation().getLng());
        indexUnitUser.setLocationName(user.getLocation().getName());
        indexUnitUser.setGeo_point(new GeoPoint(user.getLocation().getLat(),user.getLocation().getLng()));
        return indexUnitUser;
    }
}
