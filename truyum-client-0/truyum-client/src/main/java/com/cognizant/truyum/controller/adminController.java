package com.cognizant.truyum.controller;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.service.AdminService;

@Controller
public class adminController {

	@Autowired
	private AdminService adminService;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(java.util.Date.class, new CustomDateEditor(sdf, false));
	}

	@RequestMapping("show-menu-list-admin")
	public String getAllMenuItems(Model model) {
		List<MenuItem> menuItemList = adminService.getAllMenuItems();
		model.addAttribute("menuItemListAdmin", menuItemList);
		return ("menu-item-list-admin");
	}

	@RequestMapping(value = "/show-edit-menu-item")
	public String showEditMenuItem(Model model, @RequestParam("menuItemId") long menuItemId) {
		model.addAttribute("menuItem", adminService.getMenuItem(menuItemId));
		return ("edit-menu-item");
	}
	
	@RequestMapping(value = "/create-menu-item")
	public String showCreateMenuItem(Model model) {
		model.addAttribute("menuItem", new MenuItem());
		return ("edit-menu-item");
	}

	@PostMapping(value = "/edit-menu-item")
	public String editMenuItem(Model model, @ModelAttribute("menuItem") @Valid MenuItem menuItem, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			System.out.println(bindingResult.getErrorCount());
			System.out.println(bindingResult.getAllErrors());
			return ("edit-menu-item");

		}
		adminService.modifyMenuItem(menuItem);
		return ("edit-menu-item-status");
	}

}
