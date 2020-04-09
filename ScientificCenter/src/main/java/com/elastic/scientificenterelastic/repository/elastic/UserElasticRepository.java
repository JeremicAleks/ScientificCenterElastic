package com.elastic.scientificenterelastic.repository.elastic;

import com.elastic.scientificenterelastic.lucene.model.IndexUnitUser;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserElasticRepository extends ElasticsearchRepository<IndexUnitUser,String> {

    IndexUnitUser findByUserId(Long userId);
}
