package com.umass.controller;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.umass.model.User;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name = "User Controller", description = "Endpoints for managing user details")
public interface UserController {

    @Operation(summary = "Fetch user details", description = "Endpoint to fetch details of all users")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved the list of users")
    })
    @GetMapping(path = "/public/users", produces = "application/json")
    public ResponseEntity<List<User>> fetchUsersDetails();

    @Operation(summary = "Fetch user details by username", description = "Endpoint to fetch details of a user by username")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved the user details"),
            @ApiResponse(responseCode = "404", description = "User not found")
    })
    @GetMapping(path = "/private/users.get", produces = "application/json")
    public ResponseEntity<User> fetchUser(
            @Parameter(in = ParameterIn.QUERY, name = "username", description = "Username of the user to be fetched", required = true)
            @RequestParam("username") String username);

    @Operation(summary = "Create a new user", description = "Endpoint to create a new user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Successfully created the user"),
            @ApiResponse(responseCode = "400", description = "Bad request, invalid input")
    })
    @PostMapping(path = "/public/api/users", produces = "application/json")
    public ResponseEntity<String> createUser(
            @RequestParam(value = "username", required = true) String username,
            @RequestParam(value = "password", required = true) String password);
}
