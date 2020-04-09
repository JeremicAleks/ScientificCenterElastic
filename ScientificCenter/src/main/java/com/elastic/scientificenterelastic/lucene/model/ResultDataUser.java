package com.elastic.scientificenterelastic.lucene.model;

import org.springframework.data.elasticsearch.core.geo.GeoPoint;

public final class ResultDataUser {

	private String username;
	private String firstname;
	private String surname;
	private String locationName;
	private String lokacija;
	private String userId;
	private String userRole;
	private GeoPoint geo_point;

	public ResultDataUser() {
		super();
	}

	public ResultDataUser(String username, String firstname, String surname, String locationName, String lokacija, String userId, String userRole, GeoPoint geo_point) {
		this.username = username;
		this.firstname = firstname;
		this.surname = surname;
		this.locationName = locationName;
		this.lokacija = lokacija;
		this.userId = userId;
		this.userRole = userRole;
		this.geo_point = geo_point;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	public String getLokacija() {
		return lokacija;
	}

	public void setLokacija(String lokacija) {
		this.lokacija = lokacija;
	}

	public GeoPoint getGeo_points() {
		return geo_point;
	}

	public void setGeo_point(GeoPoint geo_point) {
		this.geo_point = geo_point;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public GeoPoint getGeo_point() {
		return geo_point;
	}
}
