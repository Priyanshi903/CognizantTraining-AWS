package com.cognizant.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.cognizant.feign.TruYumFeign;
import com.cognizant.model.MyUser;
import com.cognizant.model.UserCredentials;
import com.cognizant.repository.UserRepo;

/**
 * Service implementation class for UserDetailsService
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

//	@Autowired
//	private UserRepo userRepo;
	
	@Autowired
	private TruYumFeign truYumProxy;

	/**
	 * Overriding method to load the user details from database with user name
	 * 
	 * @param userName
	 * @return This returns the user name and password
	 */
	@Override
	public UserDetails loadUserByUsername(String username) {
		
		UserCredentials user = truYumProxy.getUserById(username);
		System.out.println(user.getUserName()+user.getPassword());
		return new User(user.getUserName(), user.getPassword(), AuthorityUtils.createAuthorityList(user.getRole().toString()));
	}

}
