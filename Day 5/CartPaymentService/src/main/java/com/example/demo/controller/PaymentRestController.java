package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.consumer.CartRestConsumer;

@RestController
public class PaymentRestController {
	@Autowired
	private CartRestConsumer consumer;
	
	@GetMapping("/getPaymentData")
	public String getPaymentData()
	{
		return "From payment-service: thank you for using UPI: "+consumer.getData(); 
	}
}
