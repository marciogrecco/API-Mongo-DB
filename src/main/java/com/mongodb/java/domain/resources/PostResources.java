package com.mongodb.java.domain.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mongodb.java.DTO.userDTO;
import com.mongodb.java.domain.Post;
import com.mongodb.java.domain.User;
import com.mongodb.java.services.PostServices;
import com.mongodb.java.services.UserServices;

@RestController
@RequestMapping(value = "/post")
public class PostResources {

	@Autowired
	private PostServices servPost;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Post> findpost(@PathVariable String id) {
		Post user = servPost.findById(id);
		return ResponseEntity.ok().body(user);
	}

}
