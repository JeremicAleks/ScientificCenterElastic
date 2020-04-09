package com.elastic.scientificenterelastic.dto;


import java.util.List;
import java.util.Set;

public class MagazineDTO {
    private Long magazineId;

    private String name;

    private String iSSN;

    private String magazineType;

    private UserDTO leadEditor;

    private Set<UserDTO> editors;

    private Set<UserDTO> reviewers;

    private List<ScientificAreaDTO> scientificAreas;

    private double price;

    private boolean activeStatus;

    private boolean needEdit;

    public MagazineDTO() {
    }

    public MagazineDTO(Long magazineId, String name, String iSSN, String magazineType, UserDTO leadEditor, Set<UserDTO> editors, Set<UserDTO> reviewers, List<ScientificAreaDTO> scientificAreas, double price, boolean activeStatus, boolean needEdit) {
        this.magazineId = magazineId;
        this.name = name;
        this.iSSN = iSSN;
        this.magazineType = magazineType;
        this.leadEditor = leadEditor;
        this.editors = editors;
        this.reviewers = reviewers;
        this.scientificAreas = scientificAreas;
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

    public UserDTO getLeadEditor() {
        return leadEditor;
    }

    public void setLeadEditor(UserDTO leadEditor) {
        this.leadEditor = leadEditor;
    }

    public Set<UserDTO> getEditors() {
        return editors;
    }

    public void setEditors(Set<UserDTO> editors) {
        this.editors = editors;
    }

    public Set<UserDTO> getReviewers() {
        return reviewers;
    }

    public void setReviewers(Set<UserDTO> reviewers) {
        this.reviewers = reviewers;
    }

    public List<ScientificAreaDTO> getScientificAreas() {
        return scientificAreas;
    }

    public void setScientificAreas(List<ScientificAreaDTO> scientificAreas) {
        this.scientificAreas = scientificAreas;
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

    public boolean isNeedEdit() {
        return needEdit;
    }

    public void setNeedEdit(boolean needEdit) {
        this.needEdit = needEdit;
    }
}
