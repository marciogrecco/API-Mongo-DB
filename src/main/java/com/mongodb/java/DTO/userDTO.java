package com.mongodb.java.DTO;

import java.io.Serializable;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.mongodb.java.domain.User;

public class userDTO implements Serializable {


	private static final long serialVersionUID = 1L;
	private String id;
	private String nome;
	private String email;

	public userDTO(ResponseEntity<Optional<User>> user) {

	}

	public userDTO(User x) {

		id = x.getId();
		nome = x.getNome();
		email = x.getEmail();

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
