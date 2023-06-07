package com.cognizant.truyum.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.proxy.AdminProxy;

@Service
public class AdminService {

	@Autowired
	private AdminProxy adminProxy;
	
	public List<MenuItem> getAllMenuItems(){
		List<MenuItem> menuItemList = adminProxy.getAllMenuItems();
		return(menuItemList);
	}
	
	public MenuItem getMenuItem(long menuItemId) {
		MenuItem menuItem = adminProxy.getMenuItem(menuItemId);
		return(menuItem);
	}

	public void modifyMenuItem(MenuItem menuItem) {
		adminProxy.saveMenuItem(menuItem);
	}
}
