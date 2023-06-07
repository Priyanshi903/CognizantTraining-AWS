package com.cognizant.truyum.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.proxy.AdminProxy;

@Service
public class CustomerService {

	@Autowired
	private AdminProxy proxy;
	
	public List<MenuItem> getMenuItemListCustomer() {		
		return(proxy.getAllMenuItems());
	}
	
	public void addCartItem(long userId, long menuItemId) {
		proxy.addCartItem(userId, menuItemId);
	}

	public List<MenuItem> getAllCartItems(long userId){
		return(proxy.getAllCartItems(userId));
	}
	
	public void removeCartItem(long userId, long menuItemId) {
		proxy.deleteCartItem(userId, menuItemId);
	}
	
}
