package com.elastic.scientificenterelastic.exception;

import org.springframework.http.HttpStatus;

public class StoreException extends RuntimeException {

	private static final long serialVersionUID = 8015647556248899491L;

	private HttpStatus statusCode;
	private String message;

	public StoreException(HttpStatus statusCode, String message) {
		this.statusCode = statusCode;
		this.message = message;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public HttpStatus getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(HttpStatus statusCode) {
		this.statusCode = statusCode;
	}

	@Override
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
