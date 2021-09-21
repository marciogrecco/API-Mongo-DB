package com.mongodb.java.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mongodb.java.domain.Post;
import com.mongodb.java.repository.PostRepository;
import com.mongodb.java.services.exeption.ObjectNotFoundException;

@Service
public class PostServices {

	@Autowired
	private PostRepository repoPost;

	public Post findById(String id) {
		Optional<Post> post = repoPost.findById(id);
		return post.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));

	}

	public List<Post> findByTitle(String text) {

		return repoPost.findByTitleContaining(text);
	}
}