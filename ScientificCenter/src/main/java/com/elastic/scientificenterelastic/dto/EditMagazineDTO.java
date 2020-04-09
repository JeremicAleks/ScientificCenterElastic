package com.elastic.scientificenterelastic.dto;

public class EditMagazineDTO {
    private Long id;
    private boolean activate;

    public EditMagazineDTO() {
    }

    public EditMagazineDTO(Long id, boolean activate) {
        this.id = id;
        this.activate = activate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isActivate() {
        return activate;
    }

    public void setActivate(boolean activate) {
        this.activate = activate;
    }
}
