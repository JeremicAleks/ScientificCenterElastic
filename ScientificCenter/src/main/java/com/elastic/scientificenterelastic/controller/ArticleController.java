package com.elastic.scientificenterelastic.controller;

import com.elastic.scientificenterelastic.domain.Article;
import com.elastic.scientificenterelastic.dto.AddArticleDTO;
import com.elastic.scientificenterelastic.dto.AddReviewersDTO;
import com.elastic.scientificenterelastic.dto.ArticleDTO;
import com.elastic.scientificenterelastic.service.ArticleService;
import com.elastic.scientificenterelastic.service.elastic.IndexerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@RestController
@RequestMapping("api/article")
public class ArticleController {

    @Autowired
    ArticleService articleService;
    @Autowired
    IndexerService indexerService;

    @GetMapping
    public ResponseEntity<?> getAllRadove(){
        return ResponseEntity.ok(articleService.findAllArticles());
    }

    @GetMapping(value = "/{idArticle}")
    public ResponseEntity<?> getOneArticle(@PathVariable Long idArticle){return ResponseEntity.ok(articleService.getOne(idArticle));}

    @PostMapping
    public ResponseEntity<?> addRad(@RequestBody AddArticleDTO addArticleDTO){
        return ResponseEntity.ok(articleService.addArticle(addArticleDTO));
    }

    @GetMapping("/inactiveArticle/{username}")
    public ResponseEntity<?> getUnacitveArticleForEditor(@PathVariable String username){
        return ResponseEntity.ok(articleService.findAllUnactiveArticleForEditor(username));
    }

    @PostMapping("/addReviewers/{idArticle}")
    public ResponseEntity<?> addReviewers(@RequestBody AddReviewersDTO addReviewersDTO, @PathVariable Long idArticle){
        return ResponseEntity.ok(articleService.addReviewersArtcle(addReviewersDTO,idArticle));
    }
    @PutMapping("/activateArticle")
    public ResponseEntity<?> activateArticle(@RequestBody ArticleDTO articleDTO){
        return ResponseEntity.ok(articleService.activateArticle(articleDTO));
    }



    @PostMapping(value = "/{idArticle}")
    public ResponseEntity<?> uploadFile(@RequestBody MultipartFile file, @PathVariable Long idArticle) throws IOException {
        indexerService.saveFileAndIndex(file,idArticle);
        return ResponseEntity.ok(true);
    }


    @GetMapping("/pdf/{idArticle}")
    public ResponseEntity<byte[]> downloadPdf(@PathVariable Long idArticle){
        Article article = articleService.findById(idArticle);
        FileInputStream fileStream;
        File file = new File(article.getFileLocation());

        try
        {
            fileStream = new FileInputStream(file);
            byte[] contents = new byte[(int) file.length()];
            fileStream.read(contents);

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.parseMediaType("application/pdf"));
            String filename = article.getTitle() + ".pdf";
            headers.setContentDispositionFormData(filename, filename);
            return new ResponseEntity<>(contents, headers, HttpStatus.OK);
        }catch (IOException e){
            System.out.println("Greska prilikom preuzimanja fajla");
        }
        return null;
    }





}
