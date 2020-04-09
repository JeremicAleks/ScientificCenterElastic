package com.elastic.scientificenterelastic.lucene.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.annotations.GeoPointField;
import org.springframework.data.elasticsearch.core.geo.GeoPoint;

@Document(indexName = IndexUnitUser.INDEX_NAME, type = IndexUnitUser.TYPE_NAME, shards = 1, replicas = 0)
public class IndexUnitUser {

	public static final String INDEX_NAME = "users";
	public static final String TYPE_NAME = "user";
	
	@Id
	@Field(type = FieldType.Text, store = true)
	private String username;
	@Field(type = FieldType.Text,  store = true)
	private String firstname;
	@Field(type = FieldType.Text, store = true)
	private String surname;
	@Field(type = FieldType.Text, store = true)
	private String locationName;
	@Field(type = FieldType.Text, store = true)
	private String lokacija;
	@Field(type = FieldType.Text, store = true)
	private String userId;
	@Field(type = FieldType.Text, store = true)
	private String userRole;

	@GeoPointField
	private GeoPoint geo_point;



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

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	public GeoPoint getGeo_point() {
		return geo_point;
	}

	public void setGeo_point(GeoPoint geo_point) {
		this.geo_point = geo_point;
	}
}
