package com.cognizant.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.model.MyUser;
import com.cognizant.repository.UserRepo;

@Service
public class UserService {
	
	@Autowired
	private UserRepo userRepo;

	public void addUser(MyUser user) {
		userRepo.saveAndFlush(user);
		
	}

	public MyUser getUser(String userid) {
		return userRepo.findById(userid).get();
	}
	
	
	

}
