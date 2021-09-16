package com.mongodb.java.domain.resources.exception;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;



public class StandardError implements Serializable{

	private static final long serialVersionUID = 1L;
	private Long timestamp;
	private int staus;
	private String error;
	private String message;
	private String path;

	public StandardError(long l, int i, String string, String string2, HttpServletRequest request) {

	}

	
	public StandardError(Long timestamp, int staus, String error, String message, String path) {
		super();
		this.timestamp = timestamp;
		this.staus = staus;
		this.error = error;
		this.message = message;
		this.path = path;
	}




	public Long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}

	public Integer getStaus() {
		return staus;
	}

	public void setStaus(Integer staus) {
		this.staus = staus;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

}
