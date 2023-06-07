package com.cognizant.truyum.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.service.CustomerService;

@Controller
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping(value="show-menu-list-customer")
	public String getMenuItemListCustomer(Model model) {
		List<MenuItem> menuItemList = customerService.getMenuItemListCustomer();
		model.addAttribute("menuItemListCustomer", menuItemList);
		return("menu-item-list-customer");
	}	
}
