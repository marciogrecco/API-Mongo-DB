package com.mongodb.java.domain.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mongodb.java.domain.User;

@RestController
@RequestMapping(value = "/users")
public class UserResources {

	
	@GetMapping
	public ResponseEntity<List<User>> findALL() {

		List<User> list = new ArrayList<>();

		User user1 = new User(1, "Marcio", "marcio.;greco@g");
		User user2 = new User(2, "Carlos da silva", "carlos@gmail");
	
	
	   list.addAll(Arrays.asList(user1,user2));
	
	return ResponseEntity.ok().body(list);
	}

}
