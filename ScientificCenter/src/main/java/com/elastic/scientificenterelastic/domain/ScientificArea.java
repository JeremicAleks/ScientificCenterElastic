package com.elastic.scientificenterelastic.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class ScientificArea {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long scientificAreaId;

    private String name;

    @ManyToMany(fetch = FetchType.EAGER,mappedBy = "scientificAreas")
    private Set<Magazine> magazineSet = new HashSet<>();

    @ManyToMany(fetch = FetchType.EAGER,mappedBy = "choosenScientificAreas")
    private Set<User> users = new HashSet<>();

    public ScientificArea() {
    }

    public Long getScientificAreaId() {
        return scientificAreaId;
    }

    public void setScientificAreaId(Long scientificAreaId) {
        this.scientificAreaId = scientificAreaId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Magazine> getMagazineSet() {
        return magazineSet;
    }

    public void setMagazineSet(Set<Magazine> magazineSet) {
        this.magazineSet = magazineSet;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
