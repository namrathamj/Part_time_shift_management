package com.umass.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.umass.model.User;
import com.umass.repository.UserRepository;

@RestController
public class UserController {

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	UserRepository userRepository;
	
	@GetMapping(path = "/getUserdetails", produces= "application/json")
	@ResponseBody
	public ResponseEntity<List<User>> fetchUsersDetails() {
		List<User> users = userRepository.findAll();
		return ResponseEntity.ok().body(users);
	}	
	
	@GetMapping(path = "/users.get", produces= "application/json")
	@ResponseBody
	public ResponseEntity<User> fetchUser() {
		User users = userRepository.findByUsername("test@gmail.com");
		System.out.println("Paasssword is:::: "+ passwordEncoder.encode(users.getPassword()));
		return ResponseEntity.ok().body(users);
	}
}
