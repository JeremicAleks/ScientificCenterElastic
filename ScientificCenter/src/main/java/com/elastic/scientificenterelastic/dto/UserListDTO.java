package com.elastic.scientificenterelastic.dto;

import java.util.ArrayList;
import java.util.List;

public class UserListDTO {
    List<UserDTO> users ;

    public UserListDTO() {
        this.users = new ArrayList<>();
    }

    public UserListDTO(List<UserDTO> users) {
        this.users = users;
    }

    public List<UserDTO> getUsers() {
        return users;
    }

    public void setUsers(List<UserDTO> users) {
        this.users = users;
    }
}
