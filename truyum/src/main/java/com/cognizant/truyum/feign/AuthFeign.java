package com.cognizant.truyum.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import com.cognizant.truyum.model.User;

@FeignClient(name = "auth-service",url = "http://localhost:8081")
public interface AuthFeign {
	
	@GetMapping("/auth/validate")
	public boolean validate(@RequestHeader(name = "Authorization") String token);
	
	@GetMapping("auth/users/{userid}")
	public User getUser(@PathVariable String userid);

}
/*
 * { "userName": "mahima", "password":"abc1", "role":"User" }
 */