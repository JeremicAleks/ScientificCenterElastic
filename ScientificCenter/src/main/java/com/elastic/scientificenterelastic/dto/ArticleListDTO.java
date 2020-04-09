package com.elastic.scientificenterelastic.dto;

import java.util.ArrayList;
import java.util.List;

public class ArticleListDTO {
    List<ArticleDTO> articleDTOS;

    public ArticleListDTO() {
        this.articleDTOS = new ArrayList<>();

    }

    public ArticleListDTO(List<ArticleDTO> articleDTOS) {
        this.articleDTOS = articleDTOS;
    }

    public List<ArticleDTO> getArticleDTOS() {
        return articleDTOS;
    }

    public void setArticleDTOS(List<ArticleDTO> articleDTOS) {
        this.articleDTOS = articleDTOS;
    }
}
