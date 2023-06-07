package com.cognizant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class EmployeeMvcClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeMvcClientApplication.class, args);
	}

}