package com.elastic.scientificenterelastic.dto;

public class ScientificAreaDTO {

    private Long scientificAreaId;
    private String name;

    public ScientificAreaDTO() {
    }

    public ScientificAreaDTO(Long scientificAreaId, String name) {
        this.scientificAreaId = scientificAreaId;
        this.name = name;
    }

    public Long getScientificAreaId() {
        return scientificAreaId;
    }

    public void setScientificAreaId(Long scientificAreaId) {
        this.scientificAreaId = scientificAreaId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
