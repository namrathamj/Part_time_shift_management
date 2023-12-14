package com.umass.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.umass.controller.UserController;
import com.umass.model.User;
import com.umass.repository.UserRepository;

import io.micrometer.common.util.StringUtils;

@Service
public class UserService implements UserController{
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	UserRepository userRepository;

	@Override
	public ResponseEntity<List<User>> fetchUsersDetails() {
		List<User> users = userRepository.findAll();
		return ResponseEntity.ok().body(users);
	}	
	
	// TODO : remove before submission
	@Override
	public ResponseEntity<User> fetchUser(@RequestParam("username") String username) {
		User users = userRepository.findByUsername(username);
		return ResponseEntity.ok().body(users);
	}
	
	@Override
	public ResponseEntity<String> createUser(@RequestParam(value = "username", required=true) String username,
			@RequestParam(value= "password", required=true) String password){
		
		if(StringUtils.isNotBlank(username) && StringUtils.isNotBlank(password)) {
			User user = userRepository.findByUsername(username);
			if(Objects.isNull(user)) {
				userRepository.save(User.builder()
						.username(username)
						.password(passwordEncoder.encode(password)).build());
				return ResponseEntity.ok().body("User registered successfully");
			}
			else {
				return ResponseEntity.ok().body("User ALREADY EXISTS");
			}
		}
		return ResponseEntity.ok().body("Username and password cannot be empty");
	}

}
