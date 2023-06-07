package com.cognizant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.model.Employee;
import com.cognizant.repository.IEmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	IEmployeeRepository iEmployeeRepository;
	
	public List<Employee> getAllEmployees(){
		return iEmployeeRepository.findAll();
	}
	
	public Employee getEmployee(String id) {
		return iEmployeeRepository.findById(id).get();
	}
	
	public void addEmployee(Employee employee) {
		iEmployeeRepository.saveAndFlush(employee);
	}

}
