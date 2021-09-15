package com.mongodb.java.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.mongodb.java.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

}
