package com.elastic.scientificenterelastic.mapper;

import com.elastic.scientificenterelastic.domain.Article;
import com.elastic.scientificenterelastic.dto.ArticleDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring",uses = {ScientificAreaMapper.class, MagazineMapper.class})
public interface ArticleMapper {
    ArticleDTO map(Article article);

    Article map(ArticleDTO source);
}
