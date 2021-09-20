package com.mongodb.java.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mongodb.java.DTO.userDTO;
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

	public User insert(User obj) {
		return repo.insert(obj);
	}

	public User update(User obj) {
		User newObj = findById(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}

	private void updateData(User newObj, User obj) {
		newObj.setNome(obj.getNome());
		newObj.setEmail(obj.getEmail());

	}

	public void deleteByID(String id) {
		findById(id);
		repo.deleteById(id);
	}

	public User fromDTO(userDTO objDTO) {
		return new User(objDTO.getId(), objDTO.getNome(), objDTO.getEmail());
	}

}
