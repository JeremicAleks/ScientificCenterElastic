package com.elastic.scientificenterelastic.dto;

import java.util.Set;

public class ArticleDTO {

    private Long id;

    private String title;

    private String keywords;

    private String articleAbstract;

    private String fileLocation;

    private ScientificAreaDTO scientificArea;

    private MagazineDTO magazine;

     //TODO prebaciti u dto da bude samo ime i prezime ne ceo userDTO
    private UserDTO author;

    private Set<UserDTO> reviewers;

    private boolean active;

    public ArticleDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getArticleAbstract() {
        return articleAbstract;
    }

    public void setArticleAbstract(String articleAbstract) {
        this.articleAbstract = articleAbstract;
    }

    public String getFileLocation() {
        return fileLocation;
    }

    public void setFileLocation(String fileLocation) {
        this.fileLocation = fileLocation;
    }

    public ScientificAreaDTO getScientificArea() {
        return scientificArea;
    }

    public void setScientificArea(ScientificAreaDTO scientificArea) {
        this.scientificArea = scientificArea;
    }

    public MagazineDTO getMagazine() {
        return magazine;
    }

    public void setMagazine(MagazineDTO magazine) {
        this.magazine = magazine;
    }

    public UserDTO getAuthor() {
        return author;
    }

    public void setAuthor(UserDTO author) {
        this.author = author;
    }

    public Set<UserDTO> getReviewers() {
        return reviewers;
    }

    public void setReviewers(Set<UserDTO> reviewers) {
        this.reviewers = reviewers;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
