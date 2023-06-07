package com.cognizant.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.model.Employee;
import com.cognizant.repository.EmpRepository;

@Service
public class EmployeeService {
	
	@Autowired
	EmpRepository iEmployeeRepository;
	
	public Iterable<Employee> getAllEmployees(){
		return iEmployeeRepository.findAll();
	}
	
	public Employee getEmployee(String id) {
		return iEmployeeRepository.findById(id).get();
	}
	
	public void addEmployee(Employee employee) {
		iEmployeeRepository.save(employee);
	}

}
