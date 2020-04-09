package com.elastic.scientificenterelastic.service.elastic;

import com.elastic.scientificenterelastic.domain.Article;
import com.elastic.scientificenterelastic.dto.AddReviewersDTO;
import org.springframework.web.multipart.MultipartFile;

public interface IndexerService {
    void saveFileAndIndex(MultipartFile file, Long idArticle);
    void indexUploadedFile(Long idArticle);
    void addReviewersInIndexedFile(AddReviewersDTO addReviewersDTO, Long idArticle);

    void activateArticle(Article article);
}
