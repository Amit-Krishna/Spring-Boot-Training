package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CartRestController {
	
	@GetMapping("/cart/getData")
	public String getCart()
	{
		return "Thankyou for buying clothes";
	}
}
