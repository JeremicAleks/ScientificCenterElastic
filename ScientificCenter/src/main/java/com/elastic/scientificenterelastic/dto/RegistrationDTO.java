package com.elastic.scientificenterelastic.dto;

import java.util.List;

public class RegistrationDTO {

    private String firstname;

    private String surname;

    private String city;

    private String country;

    private String title;

    private String email;

    private String username;

    private String password;

    private Boolean reviewerCheck;

    private Boolean active;

    private List<Long> scientificAreasIds;

    public RegistrationDTO() {
    }

    public RegistrationDTO(String firstname, String surname, String city, String country, String title, String email, String username, String password, Boolean reviewerCheck, Boolean active, List<Long> scientificAreasIds) {
        this.firstname = firstname;
        this.surname = surname;
        this.city = city;
        this.country = country;
        this.title = title;
        this.email = email;
        this.username = username;
        this.password = password;
        this.reviewerCheck = reviewerCheck;
        this.active = active;
        this.scientificAreasIds = scientificAreasIds;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getReviewerCheck() {
        return reviewerCheck;
    }

    public void setReviewerCheck(Boolean reviewerCheck) {
        this.reviewerCheck = reviewerCheck;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public List<Long> getScientificAreasIds() {
        return scientificAreasIds;
    }

    public void setScientificAreasIds(List<Long> scientificAreasIds) {
        this.scientificAreasIds = scientificAreasIds;
    }
}
