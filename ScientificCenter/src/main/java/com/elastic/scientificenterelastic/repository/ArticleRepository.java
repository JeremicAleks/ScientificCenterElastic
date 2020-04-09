package com.elastic.scientificenterelastic.repository;

import com.elastic.scientificenterelastic.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article,Long> {
}
