package com.elastic.scientificenterelastic.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String firstname;

    private String surname;

    private String city;

    private String country;

    private String title;

    private String email;

    private String username;

    private String password;

    private Boolean active;

    private Boolean reviewerCheck;

    private Boolean membership;

    @ManyToMany(fetch = FetchType.EAGER,cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "user_scientificareas",joinColumns = {@JoinColumn(name = "user_id")},inverseJoinColumns = {@JoinColumn(name = "scientific_area_id")})
    private Set<ScientificArea> choosenScientificAreas = new HashSet<>();

    @ManyToMany(fetch = FetchType.EAGER,cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "user_role",joinColumns = {@JoinColumn(name = "user_id")},inverseJoinColumns = {@JoinColumn(name = "id")})
    private Set<Role> roles;

    @OneToMany(mappedBy = "leadEditor", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<Magazine> magazineSet = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "edit_magazine_id")
    private Magazine editMagazine;

    @ManyToMany(fetch = FetchType.EAGER,mappedBy = "reviewers")
    private Set<Magazine> reviewedMagazines;

    @ManyToMany(fetch = FetchType.EAGER,mappedBy = "reviewers")
    private Set<Article> reviewedArticles;

    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;

    public User() {
    }

    public User(String firstname, String surname, String username, Set<Role> roles, Location location) {
        this.firstname = firstname;
        this.surname = surname;
        this.username = username;
        this.roles = roles;
        this.location = location;
    }

    public User(String firstname, String surname, String city, String country, String title, String email, String username, String password) {
        this.firstname = firstname;
        this.surname = surname;
        this.city = city;
        this.country = country;
        this.title = title;
        this.email = email;
        this.username = username;
        this.password = password;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public Set<Magazine> getMagazineSet() {
        return magazineSet;
    }

    public void setMagazineSet(Set<Magazine> magazineSet) {
        this.magazineSet = magazineSet;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Boolean getReviewerCheck() {
        return reviewerCheck;
    }

    public void setReviewerCheck(Boolean reviewerCheck) {
        this.reviewerCheck = reviewerCheck;
    }

    public Boolean getMembership() {
        return membership;
    }

    public void setMembership(Boolean membership) {
        this.membership = membership;
    }

    public Set<ScientificArea> getChoosenScientificAreas() {
        return choosenScientificAreas;
    }

    public void setChoosenScientificAreas(Set<ScientificArea> choosenScientificAreas) {
        this.choosenScientificAreas = choosenScientificAreas;
    }

    public Magazine getEditMagazine() {
        return editMagazine;
    }

    public void setEditMagazine(Magazine editMagazine) {
        this.editMagazine = editMagazine;
    }

    public Set<Magazine> getReviewedMagazines() {
        return reviewedMagazines;
    }

    public void setReviewedMagazines(Set<Magazine> reviewedMagazines) {
        this.reviewedMagazines = reviewedMagazines;
    }

    public Set<Article> getReviewedArticles() {
        return reviewedArticles;
    }

    public void setReviewedArticles(Set<Article> reviewedArticles) {
        this.reviewedArticles = reviewedArticles;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
