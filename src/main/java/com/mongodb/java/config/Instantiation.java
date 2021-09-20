package com.mongodb.java.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.mongodb.java.DTO.AuthorDTO;
import com.mongodb.java.domain.Post;
import com.mongodb.java.domain.User;
import com.mongodb.java.repository.PostRepository;
import com.mongodb.java.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository repoUser;
	@Autowired
	private PostRepository repoPost;

	@Override
	public void run(String... args) throws Exception {

		SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy");

		repoUser.deleteAll();
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		User max = new User(null, "max turino", "max@gmail.com");
		User rob = new User(null, "rob Grey", "rob@gmail.com");
		User silas = new User(null, "silas alberto", "silas@gmail.com");
		User brian = new User(null, "brian neves", "brias@gmail.com");
		
		Post p1 = new Post(null, data.parse("28/03/2018"), "Hoje acordei feliz", "Vou viajar para são paulo abraços",
				new AuthorDTO(alex));
		Post p2 = new Post(null, data.parse("30/10/2018"), "Bom dia", "Tenha um òtimo dia", new AuthorDTO(maria));
		repoPost.saveAll(Arrays.asList(p1, p2));
		
		repoUser.saveAll(Arrays.asList(maria, alex, bob, max, rob, silas, brian));
        
        maria.getPost().addAll(Arrays.asList(p2));
        repoUser.save(maria);
	}

}
