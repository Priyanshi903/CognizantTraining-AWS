package com.cognizant.truyum.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.cognizant.truyum.dao.MenuItemDao;
import com.cognizant.truyum.exception.MenuItemNotFoundException;
import com.cognizant.truyum.model.MenuItem;


@Service
public class MenuItemService {
	@Autowired
	private MenuItemDao menuItemDao;
	
	public List<MenuItem> getMenuItemListCustomer() {
		return menuItemDao.findByActiveDateOfLaunchLessThan(new Date());
	}

	public MenuItem getMenuItemById(long id) throws MenuItemNotFoundException {
		Optional<MenuItem> menuItem=menuItemDao.findById(id);
		if(menuItem==null)
			throw new MenuItemNotFoundException("MenuItem Not Found");
		return menuItem.get();
	}
	
	public void modifyMenuItem(MenuItem menuItem) throws MenuItemNotFoundException {
		menuItemDao.saveAndFlush(menuItem);
	}

	public List<MenuItem> getMenuItemListAdmin() {
		return menuItemDao.findAll();
	}

	public MenuItem save(MenuItem menuItem) {
		menuItemDao.saveAndFlush(menuItem);
		return menuItemDao.getById(menuItem.getId());
	}
	
}
