package com.cognizant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * This is the main class for Authorisation class
 * 
 * @authorPOD 6
 *
 */
@SpringBootApplication
@EnableFeignClients
public class AuthServiceApplication {

	/**
	 * Main class
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(AuthServiceApplication.class, args);
	}

}
