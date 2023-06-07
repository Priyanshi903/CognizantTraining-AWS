package com.cognizant.truyum.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.User;

public interface CartDao extends JpaRepository<Cart, Long>{
	public Cart findByUser(User user);
}