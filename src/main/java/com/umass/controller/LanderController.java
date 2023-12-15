package com.umass.controller;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Tag(name = "Lander Controller", description = "Endpoints for landing and login")
public class LanderController {

    @Operation(summary = "Get the signup page", description = "Endpoint to get the signup page")
    @GetMapping(path = "/signup.html")
    public String getLander(Model model) {
        return "signup.html";
    }

    @Operation(summary = "Get the login page", description = "Endpoint to get the login page")
    @GetMapping(path = "/login")
    public String login(Model model) {
        return "login.html";
    }
}
