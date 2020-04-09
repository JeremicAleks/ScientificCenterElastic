package com.elastic.scientificenterelastic.dto;

import com.elastic.scientificenterelastic.lucene.model.ResultData;

import java.util.ArrayList;
import java.util.List;

public class MoreLikeThisResponeDTO {
    private UserListDTO reviewers;
    private List<String> bookTitle;
    private List<ResultData> resultData;

    public MoreLikeThisResponeDTO() {
        this.reviewers = new UserListDTO();
        this.bookTitle = new ArrayList<>();
        this.resultData = new ArrayList<>();
    }

    public UserListDTO getReviewers() {
        return reviewers;
    }

    public void setReviewers(UserListDTO reviewers) {
        this.reviewers = reviewers;
    }

    public List<String> getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(List<String> bookTitle) {
        this.bookTitle = bookTitle;
    }

    public List<ResultData> getResultData() {
        return resultData;
    }

    public void setResultData(List<ResultData> resultData) {
        this.resultData = resultData;
    }
}
