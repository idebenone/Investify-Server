package com.example.weinv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = {"com.example.weinv.entity", "com.example.weinv.dto"})
public class WeinvApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeinvApplication.class, args);
	}
	
	}
