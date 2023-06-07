package com.cognizant.truyum.controller;

import java.util.List;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.truyum.exception.InvalidTokenException;
import com.cognizant.truyum.exception.MenuItemNotFoundException;
import com.cognizant.truyum.feign.AuthFeign;
import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.service.MenuItemService;

@RestController
@RequestMapping("/")
public class MenuItemController {
	
	@Autowired
	private MenuItemService menuItemService;
	
	@Autowired
	private AuthFeign authorisationClient;
	
	@GetMapping
	public List<MenuItem> getAllMenuItems(@RequestHeader(name = "Authorization") String token) throws InvalidTokenException{
		System.out.println("Checking Validation=====================token="+token);
		if (authorisationClient.validate(token)) {
			System.out.println("Checking Validation=====================2 "+token);
			return menuItemService.getMenuItemListCustomer();
		}
		else {
			throw new InvalidTokenException("You not logged in");
		}
	}
	
	@GetMapping("/{id}")
	public MenuItem getMenuItemById(@RequestHeader(name = "Authorization") String token,@PathVariable long id) throws MenuItemNotFoundException, InvalidTokenException {
		if (authorisationClient.validate(token)) {
			return menuItemService.getMenuItemById(id);
		}
		else {
			throw new InvalidTokenException("You not logged in");
		}
	}
	
	@PutMapping("/admin")
	public MenuItem modifyMenuItem(@RequestHeader(name = "Authorization") String token,@RequestBody @Valid MenuItem menuItem) throws MenuItemNotFoundException, InvalidTokenException {
		if (authorisationClient.validate(token)) {
			menuItemService.modifyMenuItem(menuItem);
			return menuItemService.getMenuItemById(menuItem.getId());
		}
		else {
			throw new InvalidTokenException("You not logged in");
		}
		
	}
	
	@GetMapping("/admin")
	public List<MenuItem> getAllMenuItemsAdmin(@RequestHeader(name = "Authorization") String token) throws InvalidTokenException{
		System.out.println("Checking Validation=====================token="+token);
		if (authorisationClient.validate(token)) {
			System.out.println("Checking Validation=====================2 "+token);
		return menuItemService.getMenuItemListAdmin();
		}
		else {
			throw new InvalidTokenException("You not logged in");
		}
	}
	
	@PostMapping("/admin")
	public MenuItem save(@RequestHeader(name = "Authorization") String token,@RequestBody @Valid MenuItem menuItem) throws MenuItemNotFoundException, InvalidTokenException {
		if (authorisationClient.validate(token)) {
			menuItemService.save(menuItem);
			return menuItemService.getMenuItemById(menuItem.getId());
		}
		else {
			throw new InvalidTokenException("You not logged in");
		}
	}
	
	

}
