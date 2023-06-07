package com.cognizant.truyum.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.ModelAndView;

import com.cognizant.truyum.model.LoginModel;

public interface LoginService {
	Boolean validate(String token);

    String login(LoginModel model);
    
    public ModelAndView checkStatus(HttpServletRequest request);
}
