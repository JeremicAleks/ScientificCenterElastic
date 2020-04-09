package com.elastic.scientificenterelastic.service.serviceImpl.elastic;

import com.elastic.scientificenterelastic.domain.Article;
import com.elastic.scientificenterelastic.dto.AddReviewersDTO;
import com.elastic.scientificenterelastic.helper.IndexerHelper;
import com.elastic.scientificenterelastic.helper.SearchAndHiglihtHelper;
import com.elastic.scientificenterelastic.lucene.indexing.Indexer;
import com.elastic.scientificenterelastic.lucene.model.IndexUnit;
import com.elastic.scientificenterelastic.repository.elastic.ArticleElasticRepository;
import com.elastic.scientificenterelastic.service.ArticleService;
import com.elastic.scientificenterelastic.service.elastic.IndexerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class IndexerServiceImpl implements IndexerService {

    @Autowired
    ArticleService articleService;

    @Autowired
    Indexer indexer;
    @Autowired
    ArticleElasticRepository articleElasticRepository;


    @Override
    public void saveFileAndIndex(MultipartFile file, Long idArticle) {
        Article article = articleService.findById(idArticle);
        if (!file.isEmpty()) {
            try {
                Path currentWorkingDir = Paths.get("").toAbsolutePath();
                String realPathtoUploads = currentWorkingDir.normalize().toString()+"\\src\\main\\resources\\upload\\";
                if (!new File(realPathtoUploads).exists()) {
                    new File(realPathtoUploads).mkdir();
                }
                String orgName = file.getOriginalFilename();
                String filePath = realPathtoUploads + orgName;
                article.setFileLocation(filePath);
                File dest = new File(filePath);
                file.transferTo(dest);
                articleService.save(article);
            }catch (IOException e)
            {
                System.out.println(e.getMessage());
            }
            indexUploadedFile(idArticle);
        }
    }

    @Override
    public void indexUploadedFile(Long idArticle) {
        Article article = articleService.findById(idArticle);
        if(article.getFileLocation()!=null){
            indexer.add(IndexerHelper.indexFileHelper(article));
        }
    }

    @Override
    public void addReviewersInIndexedFile(AddReviewersDTO addReviewersDTO, Long idArticle) {
        Article article = articleService.findById(idArticle);
        IndexUnit indexUnit = articleElasticRepository.findByFilename(SearchAndHiglihtHelper.getFileName(article.getFileLocation()));
        StringBuilder recen = new StringBuilder("");
        addReviewersDTO.getReviewrsId().forEach(x -> recen.append(x).append(","));
        indexUnit.setReviewers(recen.toString().substring(0,recen.length()-1));
        indexer.add(indexUnit);
    }

    @Override
    public void activateArticle(Article article) {
        IndexUnit indexUnit = articleElasticRepository.findByFilename(SearchAndHiglihtHelper.getFileName(article.getFileLocation()));
        indexUnit.setStatus("aktivan");
        indexer.add(indexUnit);
    }
}
