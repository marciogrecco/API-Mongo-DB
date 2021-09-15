package com.mongodb.java.domain.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mongodb.java.domain.User;
import com.mongodb.java.services.UserServices;

@RestController
@RequestMapping(value = "/users")
public class UserResources {

	@Autowired
	private UserServices services;

	@GetMapping
	public ResponseEntity<List<User>> findALL() {

		List<User> user = services.findALL();

		return ResponseEntity.ok().body(user);
	}

}
