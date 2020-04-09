package com.elastic.scientificenterelastic.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String keywords;

    private String articleAbstract;

    private String fileLocation;

    private boolean active;

    @OneToOne
    private ScientificArea scientificArea;

    @OneToOne
    private User author;

    @ManyToOne
    private Magazine magazine;

    @ManyToMany(fetch = FetchType.EAGER,cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name="reviewer_article",joinColumns = {@JoinColumn(name = "article_id")},inverseJoinColumns = {@JoinColumn(name = "user_id")} )
    private Set<User> reviewers;

    private String dOI;

    public Article() {
    }

    public Article(String title, String keywords, String articleAbstract, String fileLocation, boolean active, ScientificArea scientificArea, User author, Magazine magazine, Set<User> reviewers, String dOI) {
        this.title = title;
        this.keywords = keywords;
        this.articleAbstract = articleAbstract;
        this.fileLocation = fileLocation;
        this.active = active;
        this.scientificArea = scientificArea;
        this.author = author;
        this.magazine = magazine;
        this.reviewers = reviewers;
        this.dOI = dOI;
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

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public ScientificArea getScientificArea() {
        return scientificArea;
    }

    public void setScientificArea(ScientificArea scientificArea) {
        this.scientificArea = scientificArea;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Magazine getMagazine() {
        return magazine;
    }

    public void setMagazine(Magazine magazine) {
        this.magazine = magazine;
    }

    public Set<User> getReviewers() {
        return reviewers;
    }

    public void setReviewers(Set<User> reviewers) {
        this.reviewers = reviewers;
    }

    public String getdOI() {
        return dOI;
    }

    public void setdOI(String dOI) {
        this.dOI = dOI;
    }
}
