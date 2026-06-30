package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CartPaymentServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CartPaymentServiceApplication.class, args);
		System.out.println("Payment Started");
	}

}
