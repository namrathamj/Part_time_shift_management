package com.umass.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

	@GetMapping(path = "/home")
	public String getLoginDetails(@AuthenticationPrincipal UserDetails userdetails, Model model) {
		model.addAttribute("username", userdetails.getUsername());
		return "home.html";
	}

	@GetMapping(path = "/studenthome")
	public String getLoginDetailsandnav(@AuthenticationPrincipal UserDetails userdetails, Model model) {
		model.addAttribute("username", userdetails.getUsername());
		return "studenthome.html";
	}
}
