package com.cognizant.repository;

import org.springframework.stereotype.Repository;

import com.cognizant.model.MyUser;

/**
 * Repository class for storing, fetching and manipulating user data
 */
//@Repository
public interface UserRepo  {

	// Method to find a user details with user name
	public MyUser findByUserName(String name);
}
