package com.example.JWT1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.JWT1.config.TokenAuthenticationService;
import com.example.JWT1.entity.Users;
import com.example.JWT1.repo.UsersRepo;

@RestController
@RequestMapping("/api")
public class LoginController {

	@Autowired
	private UsersRepo userrepo;

	@PostMapping("/login")
	public String login(@RequestBody Users users) {
		if(userrepo.findByUsername(users.getUsername()) != null) {
			return TokenAuthenticationService.addAuthentication(users.getUsername());
		}
		return null;
	}
	
	@GetMapping("/hello")
	public String hello() {
		return "hello";
	}
	
}
