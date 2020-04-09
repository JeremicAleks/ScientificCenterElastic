package com.elastic.scientificenterelastic.repository.elastic;

import com.elastic.scientificenterelastic.lucene.model.IndexUnit;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleElasticRepository extends ElasticsearchRepository<IndexUnit,String> {

    List<IndexUnit> findByTitle(String title);

    IndexUnit findByFilename(String filename);

}
