package com.umass.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.umass.model.User;

public interface UserRepository extends MongoRepository<User, String>{
       
	User findByUsername(String username);
	
}
