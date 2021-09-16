package com.mongodb.java.DTO;

import java.io.Serializable;

import com.mongodb.java.domain.User;

public class userDTO implements Serializable {


	private static final long serialVersionUID = 1L;
	private String id;
	private String nome;
	private String email;

	public userDTO() {

	}

	public userDTO(User obj) {

		id = obj.getId();
		nome = obj.getNome();
		email = obj.getEmail();

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
