package com.cognizant.truyum.feign;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.cognizant.truyum.model.LoginModel;

@FeignClient(name = "auth-service", url = "http://localhost:8082/auth")
public interface AuthClient {
    
    @GetMapping("/validate")
    public boolean validate(String token);

    @PostMapping("/login")
    public String login(LoginModel model);
}
