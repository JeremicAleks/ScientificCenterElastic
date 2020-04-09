package com.elastic.scientificenterelastic.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Magazine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long magazineId;

    private String name;

    private String iSSN;

    private String magazineType;

    @ManyToOne
    @JoinColumn(name = "lead_editor_id")
    private User leadEditor;

    @OneToMany(mappedBy ="editMagazine", fetch = FetchType.EAGER)
    private Set<User> editors;

    @ManyToMany(fetch = FetchType.EAGER,cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name="reviewers_magazine",joinColumns = {@JoinColumn(name = "magazine_id")},inverseJoinColumns = {@JoinColumn(name = "user_id")} )
    private Set<User> reviewers;

    @ManyToMany(fetch = FetchType.EAGER,cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name="scientificareas_magazines",joinColumns = {@JoinColumn(name = "magazine_id")},inverseJoinColumns = {@JoinColumn(name = "scientificarea_id")} )
    private Set<ScientificArea> scientificAreas;

    @OneToMany(mappedBy = "magazine",fetch = FetchType.EAGER)
    private Set<Article> articles;

    private double price;

    private boolean activeStatus;

    private Boolean needEdit;

    public Magazine() {
    }

    public Magazine(String name, String iSSN, String magazineType, User leadEditor, Set<User> editors, Set<User> reviewers, Set<ScientificArea> scientificAreas, Set<Article> articles, double price, boolean activeStatus, Boolean needEdit) {
        this.name = name;
        this.iSSN = iSSN;
        this.magazineType = magazineType;
        this.leadEditor = leadEditor;
        this.editors = editors;
        this.reviewers = reviewers;
        this.scientificAreas = scientificAreas;
        this.articles = articles;
        this.price = price;
        this.activeStatus = activeStatus;
        this.needEdit = needEdit;
    }

    public Long getMagazineId() {
        return magazineId;
    }

    public void setMagazineId(Long magazineId) {
        this.magazineId = magazineId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getiSSN() {
        return iSSN;
    }

    public void setiSSN(String iSSN) {
        this.iSSN = iSSN;
    }

    public String getMagazineType() {
        return magazineType;
    }

    public void setMagazineType(String magazineType) {
        this.magazineType = magazineType;
    }

    public User getLeadEditor() {
        return leadEditor;
    }

    public void setLeadEditor(User leadEditor) {
        this.leadEditor = leadEditor;
    }

    public Set<User> getEditors() {
        return editors;
    }

    public void setEditors(Set<User> editors) {
        this.editors = editors;
    }

    public Set<User> getReviewers() {
        return reviewers;
    }

    public void setReviewers(Set<User> reviewers) {
        this.reviewers = reviewers;
    }

    public Set<ScientificArea> getScientificAreas() {
        return scientificAreas;
    }

    public void setScientificAreas(Set<ScientificArea> scientificAreas) {
        this.scientificAreas = scientificAreas;
    }

    public Set<Article> getArticles() {
        return articles;
    }

    public void setArticles(Set<Article> articles) {
        this.articles = articles;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isActiveStatus() {
        return activeStatus;
    }

    public void setActiveStatus(boolean activeStatus) {
        this.activeStatus = activeStatus;
    }

    public Boolean getNeedEdit() {
        return needEdit;
    }

    public void setNeedEdit(Boolean needEdit) {
        this.needEdit = needEdit;
    }
}
