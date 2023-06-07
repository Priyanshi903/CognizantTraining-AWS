package com.cognizant.truyum.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.truyum.dao.UserDao;
import com.cognizant.truyum.model.User;

@Service
public class userService {
	
	@Autowired
	private UserDao userDao;

	public void addUser(User user) {
		userDao.saveAndFlush(user);
	}
	
	public User getUser(String id) {
		return userDao.findById(id).get();
	}

}
