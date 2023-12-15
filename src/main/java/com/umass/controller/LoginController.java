package com.umass.controller;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Controller
@Tag(name = "Login Controller", description = "Endpoints for user login")
public class LoginController {

    @Operation(summary = "Get login details", description = "Endpoint to get login details")
    @GetMapping(path = "/private/home")
    public String getLoginDetails(@AuthenticationPrincipal UserDetails userDetails, Model model) {
        model.addAttribute("username", userDetails.getUsername());
        return "user.html";
    }

    @Operation(summary = "Get login details and navigation", description = "Endpoint to get login details and navigation")
    @GetMapping(path = "/private/studenthome")
    public String getLoginDetailsAndNav(@AuthenticationPrincipal UserDetails userDetails, Model model) {
        model.addAttribute("username", userDetails.getUsername());
        return "studenthome.html";
    }
}
