package com.cognizant.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cognizant.model.Employee;
import com.cognizant.proxy.EmployeeProxy;

@Controller
public class EmployeeWebController {

	@Autowired
	private EmployeeProxy employeeProxy;

	@RequestMapping("/")
	public String getAllEmployee(Model model) {
		List<Employee> employeeList = employeeProxy.getAllEmployees();
		model.addAttribute("employees", employeeList);
		return "employee";
	}

	@RequestMapping("/addEmployee")
	public String addEmployee(@ModelAttribute("employee") Employee employee, BindingResult result) {
		return "addEmployee";
	}

	@RequestMapping("/added")
	public String added(Employee employee) {
		employeeProxy.addEmployee(employee);
		return "redirect:/";
	}

	@RequestMapping("/{id}")
	public String deleteEmployee(@PathVariable String id) {
		employeeProxy.deleteEmployee(id);
		return "redirect:/";
	}

	@RequestMapping("/update")
	public String updateEmployee(@RequestParam("id") String id, Model model) {
		Employee e=employeeProxy.getEmployee(id);
		model.addAttribute("employee", e);
		return "updateEmployee";
	}
	
	@RequestMapping("/updated")
	public String updatedEmployee( @ModelAttribute("employee") Employee employee, BindingResult result) {
		
		employeeProxy.updateEmployee(employee);
		return "redirect:/";
	}

}
