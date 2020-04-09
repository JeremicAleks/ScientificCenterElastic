package com.elastic.scientificenterelastic.dto;

import java.util.List;

public class AddMagazineDataDTO {

    private String name;

    private String iSSN;

    private String magazineType;

    private String leadEditorUsername;

    private List<Long> scientificAreaIds;

    private double price;

    private boolean activeStatus;

    public AddMagazineDataDTO() {
    }

    public AddMagazineDataDTO(String name, String iSSN, String magazineType, String leadEditorUsername, List<Long> scientificAreaIds, double price, boolean activeStatus) {
        this.name = name;
        this.iSSN = iSSN;
        this.magazineType = magazineType;
        this.leadEditorUsername = leadEditorUsername;
        this.scientificAreaIds = scientificAreaIds;
        this.price = price;
        this.activeStatus = activeStatus;
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

    public String getLeadEditorUsername() {
        return leadEditorUsername;
    }

    public void setLeadEditorUsername(String leadEditorUsername) {
        this.leadEditorUsername = leadEditorUsername;
    }

    public List<Long> getScientificAreaIds() {
        return scientificAreaIds;
    }

    public void setScientificAreaIds(List<Long> scientificAreaIds) {
        this.scientificAreaIds = scientificAreaIds;
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
}
