package com.mongodb.java.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.mongodb.java.domain.User;
import com.mongodb.java.repository.UserRepository;
import com.mongodb.java.services.exeption.ObjectNotFoundException;

@Service
public class UserServices {

	@Autowired
	private UserRepository repo;

	public List<User> findALL() {
		return repo.findAll();
	}

	public User findById(String id) {
		Optional<User> user = repo.findById(id);
		return user.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));

	}

}
