package com.cognizant.truyum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.truyum.exception.InvalidTokenException;
import com.cognizant.truyum.feign.AuthFeign;
import com.cognizant.truyum.model.User;
import com.cognizant.truyum.service.userService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private userService userService;
	
	@Autowired
	private AuthFeign authorisationClient;
	
	@PostMapping
	public void addUser( @RequestBody User user) {
			
		
			userService.addUser(user);
		
	}
	
	@GetMapping("/{userid}")
	public User getUserById(@PathVariable String userid){
		
			return userService.getUser(userid);
	}
	
}
