package com.elastic.scientificenterelastic.dto;

public class ActivateReviewerDTO {
    private Long userId;
    private boolean activate;

    public ActivateReviewerDTO() {
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public boolean isActivate() {
        return activate;
    }

    public void setActivate(boolean activate) {
        this.activate = activate;
    }
}
