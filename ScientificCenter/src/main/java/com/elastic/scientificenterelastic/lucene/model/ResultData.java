package com.elastic.scientificenterelastic.lucene.model;

public final class ResultData {

	private String text;
	private String title;
	private String keywords;
	private String location;
	private String articleAbstract;
	private String author;
	private String scientificArea;
	private String idArticle;
	private String magazineType;
	private String magazineTitle;
	private String highlight;
	private String status;
	private String reviewers;
	private String filename;
	private String filedate;

	public ResultData() {
		super();
	}

	public ResultData(String text, String title, String keywords, String location, String articleAbstract, String author, String scientificArea, String idArticle, String magazineType, String magazineTitle, String status,  String highlight) {
		this.text = text;
		this.title = title;
		this.keywords = keywords;
		this.location = location;
		this.articleAbstract = articleAbstract;
		this.author = author;
		this.scientificArea = scientificArea;
		this.idArticle = idArticle;
		this.magazineType = magazineType;
		this.magazineTitle = magazineTitle;
		this.status = status;
		this.highlight = highlight;
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

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getHighlight() {
		return highlight;
	}

	public void setHighlight(String highlight) {
		this.highlight = highlight;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
