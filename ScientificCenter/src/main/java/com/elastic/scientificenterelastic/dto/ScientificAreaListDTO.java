package com.elastic.scientificenterelastic.dto;
import java.util.ArrayList;
import java.util.List;

public class ScientificAreaListDTO {
    List<ScientificAreaDTO> scientificAreas;

    public ScientificAreaListDTO() {
        this.scientificAreas = new ArrayList<>();
    }

    public ScientificAreaListDTO(List<ScientificAreaDTO> scientificAreas) {
        this.scientificAreas = scientificAreas;
    }

    public List<ScientificAreaDTO> getScientificAreas() {
        return scientificAreas;
    }

    public void setScientificAreas(List<ScientificAreaDTO> scientificAreas) {
        this.scientificAreas = scientificAreas;
    }
}
