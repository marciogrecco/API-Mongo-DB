package com.mongodb.java.DTO;

import java.util.Date;

public class CommentsDTO {
	private String text;
	private Date date;
	private AuthorDTO autor;

	public CommentsDTO() {

	}

	public CommentsDTO( String text, Date date, AuthorDTO autor) {
		super();

		this.text = text;
		this.date = date;
		this.autor = autor;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;

	}

	public AuthorDTO getAutor() {
		return autor;
	}

	public void setAutor(AuthorDTO autor) {
		this.autor = autor;
	}

}
