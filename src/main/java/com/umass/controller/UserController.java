package com.umass.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.umass.model.User;

@RestController
public interface UserController {
	
	@GetMapping(path = "/public/users", produces= "application/json")
	public ResponseEntity<List<User>> fetchUsersDetails();
	
	@GetMapping(path = "/private/users.get", produces= "application/json")
	public ResponseEntity<User> fetchUser(@RequestParam("username") String username);
	
	@PostMapping(path = "/public/api/users", produces = "application/json")
	public ResponseEntity<String> createUser(@RequestParam(value = "username", required=true) String username,
			@RequestParam(value= "password", required=true) String password);
}
