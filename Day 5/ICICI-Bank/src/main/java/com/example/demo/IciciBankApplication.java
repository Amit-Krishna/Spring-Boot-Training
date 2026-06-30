package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class IciciBankApplication {

	public static void main(String[] args) {
		SpringApplication.run(IciciBankApplication.class, args);
		System.out.print("Bank Initiated Successfully");
	}

}
