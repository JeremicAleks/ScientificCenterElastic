package com.elastic.scientificenterelastic.dto;

import com.elastic.scientificenterelastic.lucene.model.ResultDataUser;

import java.util.ArrayList;
import java.util.List;

public class GeoSearchResponseDTO {
    private UserListDTO userListDTO;
    private List<ResultDataUser> resultDataUsers;

    public GeoSearchResponseDTO() {
        this.userListDTO = new UserListDTO();
        this.resultDataUsers = new ArrayList<>();

    }

    public UserListDTO getUserListDTO() {
        return userListDTO;
    }

    public void setUserListDTO(UserListDTO userListDTO) {
        this.userListDTO = userListDTO;
    }

    public List<ResultDataUser> getResultDataUsers() {
        return resultDataUsers;
    }

    public void setResultDataUsers(List<ResultDataUser> resultDataUsers) {
        this.resultDataUsers = resultDataUsers;
    }
}
