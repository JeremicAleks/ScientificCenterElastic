package com.elastic.scientificenterelastic.dto;

public class AddArticleDTO {

    private String title;

    private String keywords;

    private String articleAbstract;

    private String fileLocation;

    private Long scientificAreaId;

    private Long magazineId;

    private String authorUsername;

    private boolean active;

    public AddArticleDTO() {
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

    public Long getScientificAreaId() {
        return scientificAreaId;
    }

    public void setScientificAreaId(Long scientificAreaId) {
        this.scientificAreaId = scientificAreaId;
    }

    public Long getMagazineId() {
        return magazineId;
    }

    public void setMagazineId(Long magazineId) {
        this.magazineId = magazineId;
    }

    public String getAuthorUsername() {
        return authorUsername;
    }

    public void setAuthorUsername(String authorUsername) {
        this.authorUsername = authorUsername;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
