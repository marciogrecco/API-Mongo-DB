package com.mongodb.java.domain.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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

	@RequestMapping(value = "/users", method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody userDTO obDto) {

		User user = services.fromDTO(obDto);
		user = services.insert(user);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable String id) {
		services.deleteByID(id);
		return ResponseEntity.noContent().build();
	}
}










