package com.cognizant.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.model.Employee;
import com.cognizant.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping
	public List<Employee> getAllEmployees(){
		return employeeService.getAllEmployees();
	}
	
	@GetMapping("/{id}")
	public Employee getEmployee(@PathVariable String id) {
		return employeeService.getEmployee(id);
	}
	
	@PostMapping
	public List<Employee> addEmployee(@RequestBody Employee employee){
		employeeService.addEmployee(employee);
		return employeeService.getAllEmployees();
	}
	
	@DeleteMapping("/{id}")
	public List<Employee> deleteEmployee(@PathVariable String id){
		employeeService.deleteEmployee(id);
		return employeeService.getAllEmployees();
	}
	
	@PutMapping
	public List<Employee> updateEmployee(@RequestBody Employee employee){
		employeeService.updateEmployee(employee);
		return employeeService.getAllEmployees();
	}

}
