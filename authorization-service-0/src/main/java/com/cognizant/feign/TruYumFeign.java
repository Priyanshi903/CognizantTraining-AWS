package com.cognizant.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cognizant.model.UserCredentials;


@FeignClient(name = "truyum-rest-app",url="http://localhost:8080/users")
public interface TruYumFeign {
	
	@GetMapping("/{userid}")
	public UserCredentials getUserById(@PathVariable String userid);
}
