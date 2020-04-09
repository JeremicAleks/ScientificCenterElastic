package com.elastic.scientificenterelastic.service.serviceImpl;

import com.elastic.scientificenterelastic.domain.Article;
import com.elastic.scientificenterelastic.domain.Magazine;
import com.elastic.scientificenterelastic.domain.ScientificArea;
import com.elastic.scientificenterelastic.domain.User;
import com.elastic.scientificenterelastic.dto.AddArticleDTO;
import com.elastic.scientificenterelastic.dto.AddReviewersDTO;
import com.elastic.scientificenterelastic.dto.ArticleDTO;
import com.elastic.scientificenterelastic.dto.ArticleListDTO;
import com.elastic.scientificenterelastic.exception.StoreException;
import com.elastic.scientificenterelastic.mapper.ArticleMapper;
import com.elastic.scientificenterelastic.repository.ArticleRepository;
import com.elastic.scientificenterelastic.repository.MagazineRepository;
import com.elastic.scientificenterelastic.repository.ScientificAreaRepository;
import com.elastic.scientificenterelastic.repository.UserRepository;
import com.elastic.scientificenterelastic.service.ArticleService;
import com.elastic.scientificenterelastic.service.elastic.IndexerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    ArticleRepository articleRepository;
    @Autowired
    ArticleMapper articleMapper;
    @Autowired
    ScientificAreaRepository scientificAreaRepository;
    @Autowired
    MagazineRepository magazineRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    IndexerService indexerService;

    @Override
    public ArticleListDTO findAllArticles() {
        ArticleListDTO articleListDTO = new ArticleListDTO();
        List<Article> articleList = articleRepository.findAll();
        if(!articleList.isEmpty()){
            for(Article rad : articleList){
                articleListDTO.getArticleDTOS().add(articleMapper.map(rad));
            }
        }
//        else
//            throw new StoreException(HttpStatus.NOT_FOUND,"Naucni radovi ne postoje!");

        return articleListDTO;
    }

    @Override
    public ArticleDTO getOne(Long id) {
        Article article = articleRepository.getOne(id);
        if(article == null)
            throw new StoreException(HttpStatus.NOT_FOUND,"Naucni rad ne postoji!");
        return articleMapper.map(article);
    }

    @Override
    public Article findById(Long id) {
        return articleRepository.getOne(id);
    }

    @Override
    public ArticleDTO addArticle(AddArticleDTO naucniRadDTO) {
        Article rad = new Article();
        rad.setArticleAbstract(naucniRadDTO.getArticleAbstract());
        rad.setKeywords(naucniRadDTO.getKeywords());
        rad.setTitle(naucniRadDTO.getTitle());
        rad.setActive(naucniRadDTO.isActive());
        Magazine magazine = magazineRepository.getOne(naucniRadDTO.getScientificAreaId());
        rad.setMagazine(magazine);
        ScientificArea scientificArea = scientificAreaRepository.getOne(naucniRadDTO.getScientificAreaId());
        rad.setScientificArea(scientificArea);
        User author = userRepository.findByUsername(naucniRadDTO.getAuthorUsername());
        rad.setAuthor(author);
        rad = articleRepository.save(rad);

        return articleMapper.map(rad);
    }

    @Override
    public Boolean updateNaucniRad(ArticleDTO articleDTO, Long id) {
        return null;
    }

    @Override
    public Boolean deleteNaucniRad(Long id) {
        Article article = articleRepository.getOne(id);
        if(article == null)
            throw new StoreException(HttpStatus.NOT_FOUND,"Article doesn't exist!");

        articleRepository.delete(article);
        return true;
    }

    @Override
    public ArticleListDTO findAllUnactiveArticleForEditor(String username) {
        ArticleListDTO articleListDTO = new ArticleListDTO();
        List<Article> articles = articleRepository.findAll();
        for(Article article : articles){
            if(!article.isActive()){
                if(article.getMagazine().getLeadEditor().getUsername().equalsIgnoreCase(username))
                articleListDTO.getArticleDTOS().add(articleMapper.map(article));
            }
        }
        return articleListDTO;
    }

    @Override
    public ArticleDTO save(Article article) {
        return articleMapper.map(articleRepository.save(article));
    }

    @Override
    public ArticleDTO addReviewersArtcle(AddReviewersDTO addReviewersDTO, Long idArticle) {
        Article article = articleRepository.getOne(idArticle);
        Set<User> recenzenti = new HashSet<>();

        for(Long idUser: addReviewersDTO.getReviewrsId()){
            User user = userRepository.getOne(idUser);
            recenzenti.add(user);
        }

        article.setReviewers(recenzenti);
        article = articleRepository.save(article);
        indexerService.addReviewersInIndexedFile(addReviewersDTO,idArticle);
        return articleMapper.map(article);
    }

    @Override
    public ArticleDTO activateArticle(ArticleDTO articleDTO) {
        Article article = articleRepository.getOne(articleDTO.getId());
        article.setActive(articleDTO.isActive());
        article = articleRepository.save(article);
        indexerService.activateArticle(article);
        return articleMapper.map(article);
    }
}
