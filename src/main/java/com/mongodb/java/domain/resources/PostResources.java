package com.mongodb.java.domain.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mongodb.java.domain.Post;
import com.mongodb.java.domain.resources.utils.URL;
import com.mongodb.java.services.PostServices;

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


	@RequestMapping(value = "/titlesearch", method = RequestMethod.GET)
	public ResponseEntity<List<Post>> findTitle(@RequestParam(value = "text", defaultValue = ",")String text) {
		text = URL.decoderParam(text);
		
		List<Post>list = servPost.findByTitle(text);
     
				
		
		return ResponseEntity.ok().body(list);
	}
}
