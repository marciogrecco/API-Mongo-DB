package com.mongodb.java.domain.resources;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
		List<userDTO> listDTO = user.stream().map(x -> new userDTO(x)).collect(Collectors.toList());

		return ResponseEntity.ok().body(listDTO);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<userDTO> findID(@PathVariable String id) {

		User user = services.findById(id);

		return ResponseEntity.ok().body(new userDTO(user));
	}
}
