package com.elastic.scientificenterelastic.service;


import com.elastic.scientificenterelastic.domain.Article;
import com.elastic.scientificenterelastic.dto.AddArticleDTO;
import com.elastic.scientificenterelastic.dto.AddReviewersDTO;
import com.elastic.scientificenterelastic.dto.ArticleDTO;
import com.elastic.scientificenterelastic.dto.ArticleListDTO;

public interface ArticleService {

    ArticleListDTO findAllArticles();
    ArticleDTO getOne(Long id);
    Article findById(Long id);
    ArticleDTO addArticle(AddArticleDTO addArticleDTO);
    Boolean updateNaucniRad(ArticleDTO articleDTO, Long id);
    Boolean deleteNaucniRad(Long id);
    ArticleListDTO findAllUnactiveArticleForEditor(String username);

    ArticleDTO save(Article article);

    ArticleDTO addReviewersArtcle(AddReviewersDTO addReviewersDTO, Long idArticle);

    ArticleDTO activateArticle(ArticleDTO articleDTO);
}
