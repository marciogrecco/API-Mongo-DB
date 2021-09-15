package com.mongodb.java.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.mongodb.java.domain.User;
import com.mongodb.java.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository repoUser;

	@Override
	public void run(String... args) throws Exception {
		

		repoUser.deleteAll();
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		User max = new User(null, "max turino", "max@gmail.com");
		User rob = new User(null, "rob Grey", "rob@gmail.com");
		User silas = new User(null, "silas alberto", "silas@gmail.com");
		User brian = new User(null, "brian neves", "brias@gmail.com");

	   repoUser.saveAll(Arrays.asList(maria,alex,bob,max,rob,silas,brian));
	
	}

}
