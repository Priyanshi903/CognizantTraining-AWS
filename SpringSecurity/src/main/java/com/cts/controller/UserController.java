package com.cts.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	
	@GetMapping("/hello")
	public String getHelloForUser(){
		return "Hello user";
	}
	
	@GetMapping("/admin")
	public String getHelloForAdmin(){
		return "Hello admin";
	}
	
	@PostMapping("/")
	public String getHelloForAll(){
		return "Hello user-admin";
	}

}
