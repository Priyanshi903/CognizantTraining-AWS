package com.cognizant.truyum.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.cognizant.truyum.model.LoginModel;
import com.cognizant.truyum.service.LoginService;

import feign.FeignException;

@Controller
public class LoginController {

	@Autowired
	private LoginService loginService;

	@GetMapping("login")
	public String getLoginPage(Model model) {
		model.addAttribute("loginModel", new LoginModel());
		return ("login");
	}

	@PostMapping("login")
	public String getLoginDetails(@Valid @ModelAttribute("loginModel") LoginModel loginModel,BindingResult result,/*HttpServletRequest request*/Model model,HttpSession session) {
		try {
			if(result.hasErrors()) {
				return("login");
			}
			String token = loginService.login(loginModel);
			System.out.println(token);
			session.setAttribute("token", token);
//			request.getSession().setAttribute("token", token);
			return("redirect:/show-menu-list-admin");
		}
		catch(FeignException e) {
			if (e.getMessage().contains("User name")) {
				model.addAttribute("status", "Invalid Credentials!!");
			} else if (e.getMessage().contains("Password is wrong")) {
				model.addAttribute("status", "Invalid Credentials!!");
			} else if (e.getMessage().contains("Invalid Credential")) {
				model.addAttribute("status", "Invalid Credentials!!");
			}
			return("login");
		}
	}
}
