package com.cognizant.repository;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
import com.cognizant.model.Employee;

@EnableScan
public interface EmpRepository extends CrudRepository<Employee, String> {

}
