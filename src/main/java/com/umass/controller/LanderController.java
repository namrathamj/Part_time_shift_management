package com.umass.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LanderController {

	@GetMapping(path = "/")
	public String getLander(Model model) {
		model.addAttribute("title", "My Thymeleaf Template");
		return "index.html";
	}
	

	@GetMapping(path = "/login")
	public String login(Model model) {
		return "login.html";
	}
}
