package com.mongodb.java.domain.resources;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.apache.el.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mongodb.java.DTO.userDTO;
import com.mongodb.java.domain.User;
import com.mongodb.java.services.UserServices;

@RestController
@RequestMapping(value = "/users")
public class UserResources {

	@Autowired
	private UserServices services;

	@GetMapping
	public ResponseEntity<List<userDTO>> findALL() {

		List<User> user = services.findALL();
        List<userDTO>listDTO = user.stream().map(x -> new userDTO(x)).collect(Collectors.toList());
		
		return ResponseEntity.ok().body(listDTO);
	}

}
