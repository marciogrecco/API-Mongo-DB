package com.mongodb.java.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mongodb.java.domain.User;
import com.mongodb.java.repository.UserRepository;

@Service
public class UserServices {

	@Autowired
	private UserRepository repo;

	public List<User> findALL() {
		return repo.findAll();
	}

}
