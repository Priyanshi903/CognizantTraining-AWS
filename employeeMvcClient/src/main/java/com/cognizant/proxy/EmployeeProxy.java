package com.cognizant.proxy;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.cognizant.model.Employee;

//@FeignClient(name = "employee-rest-app",url = "http://localhost:8081")
@FeignClient(name = "employee-rest-app",url = "http://54.177.180.155:8081")
public interface EmployeeProxy {
	
	@GetMapping("/employees")
	public List<Employee> getAllEmployees();
	
	@PostMapping("/employees")
	public List<Employee> addEmployee(@RequestBody Employee employee);
	
	@DeleteMapping("employees/{id}")
	public List<Employee> deleteEmployee(@PathVariable String id);
	
	@GetMapping("/employees/{id}")
	public Employee getEmployee(@PathVariable String id);
	
	@PutMapping("/employees")
	public List<Employee> updateEmployee(@RequestBody Employee employee);

}
