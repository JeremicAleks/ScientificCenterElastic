package com.elastic.scientificenterelastic.dto;

import java.util.ArrayList;
import java.util.List;

public class MagazineListDTO {
    List<MagazineDTO> magazines;

    public MagazineListDTO() {
        this.magazines = new ArrayList<>();
    }

    public MagazineListDTO(List<MagazineDTO> magazines) {
        this.magazines = magazines;
    }

    public List<MagazineDTO> getMagazines() {
        return magazines;
    }

    public void setMagazines(List<MagazineDTO> magazines) {
        this.magazines = magazines;
    }
}

