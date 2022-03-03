package com.app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class AppController {

	@GetMapping
	public String testDemo()
	{
		return "Welcome to spring...";
	}
	
	@GetMapping("/login")
	public String testLogin()
	{
		return "Login page...";
	}
}
