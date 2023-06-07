package com.cognizant.truyum.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.cognizant.truyum.feign.AuthClient;
import com.cognizant.truyum.model.LoginModel;

@Service
public class LoginServiceImpl implements LoginService{

	@Autowired
    private AuthClient authClient;

    @Override
    public Boolean validate(String token) {
//    	authClient.validate(token);
        return(authClient.validate(token));
    }

    @Override
    public String login(LoginModel model) {
        String token = authClient.login(model);
//        log.error(token);
        return token;
    }

	@Override
	public ModelAndView checkStatus(HttpServletRequest request) {
		if(request.getSession().getAttribute("token")==null)
		{
//			log.debug("User not logged in.Redirecting to login page");
			return new ModelAndView(new RedirectView("login"));
		}
		String token=request.getSession().getAttribute("token").toString();
		try {
			if(!authClient.validate(token)) {
//				log.debug("Token is either invalid or expired. Redirecting to Login Page");
				return new ModelAndView(new RedirectView("session-expired"));
			}
		}
		catch (Exception e) {
//			log.debug("Token is either invalid or expired. Redirecting to login page");
			return new ModelAndView(new RedirectView("session-expired"));
			// TODO: handle exception
		}
		return null;
	}
}
