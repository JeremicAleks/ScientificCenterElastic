package com.elastic.scientificenterelastic.dto;

import java.util.ArrayList;
import java.util.List;

public class AddReviewersDTO {
    private List<Long> reviewrsId;

    public AddReviewersDTO() {
        this.reviewrsId = new ArrayList<>();
    }

    public AddReviewersDTO(List<Long> reviewrsId) {
        this.reviewrsId = reviewrsId;
    }

    public List<Long> getReviewrsId() {
        return reviewrsId;
    }

    public void setReviewrsId(List<Long> reviewrsId) {
        this.reviewrsId = reviewrsId;
    }
}
