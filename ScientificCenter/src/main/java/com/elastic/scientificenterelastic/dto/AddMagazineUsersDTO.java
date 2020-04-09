package com.elastic.scientificenterelastic.dto;

import java.util.List;

public class AddMagazineUsersDTO {
    private Long id;
    private List<Long> reviewersIds;
    private List<Long> editorsIds;

    public AddMagazineUsersDTO() {
    }

    public List<Long> getReviewersIds() {
        return reviewersIds;
    }

    public void setReviewersIds(List<Long> reviewersIds) {
        this.reviewersIds = reviewersIds;
    }

    public List<Long> getEditorsIds() {
        return editorsIds;
    }

    public void setEditorsIds(List<Long> editorsIds) {
        this.editorsIds = editorsIds;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
