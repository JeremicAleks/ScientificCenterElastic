package com.elastic.scientificenterelastic.lucene.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Document(indexName = IndexUnit.INDEX_NAME, type = IndexUnit.TYPE_NAME, shards = 1, replicas = 0)
public class IndexUnit {

	public static final String INDEX_NAME = "digitallibrary";
	public static final String TYPE_NAME = "article";
	
	public static final String DATE_PATTERN = "yyyy-MM-dd";

	@Field(type = FieldType.Text, store = true)
	private String text;
	@Field(type = FieldType.Text,  store = true)
	private String title;
	@Field(type = FieldType.Text, store = true)
	private String keywords;
	@Field(type = FieldType.Text, store = true)
	private String articleAbstract;
	@Field(type = FieldType.Text, store = true)
	private String author;
	@Field(type = FieldType.Text, store = true)
	private String scientificArea;
	@Field(type = FieldType.Text, store = true)
	private String idArticle;
	@Field(type = FieldType.Text, store = true)
	private String magazineType;
	@Field(type = FieldType.Text, store = true)
	private String magazineTitle;
	@Field(type = FieldType.Text, store = true)
	private String reviewers;
	@Field(type = FieldType.Text, store = true)
	private String status;
	@Id
	@Field(type = FieldType.Text, store = true)
	private String filename;

	@Field(type = FieldType.Text, store = true)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_PATTERN)
	private String filedate;
	
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getKeywords() {
		return keywords;
	}
	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getFiledate() {
		return filedate;
	}
	public void setFiledate(String filedate) {
		this.filedate = filedate;
	}
	public String getArticleAbstract() {
		return articleAbstract;
	}
	public void setArticleAbstract(String articleAbstract) {
		this.articleAbstract = articleAbstract;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getScientificArea() {
		return scientificArea;
	}
	public void setScientificArea(String scientificArea) {
		this.scientificArea = scientificArea;
	}
	public String getReviewers() {
		return reviewers;
	}
	public void setReviewers(String reviewers) {
		this.reviewers = reviewers;
	}
	public String getIdArticle() {
		return idArticle;
	}
	public void setIdArticle(String idArticle) {
		this.idArticle = idArticle;
	}
	public String getMagazineType() {
		return magazineType;
	}
	public void setMagazineType(String magazineType) {
		this.magazineType = magazineType;
	}
	public String getMagazineTitle() {
		return magazineTitle;
	}
	public void setMagazineTitle(String magazineTitle) {
		this.magazineTitle = magazineTitle;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
