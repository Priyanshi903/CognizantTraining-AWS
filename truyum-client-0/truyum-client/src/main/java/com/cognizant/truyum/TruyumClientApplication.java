package com.cognizant.truyum;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class TruyumClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(TruyumClientApplication.class, args);
	}

}
