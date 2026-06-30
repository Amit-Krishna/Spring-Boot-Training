package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.consumer.PaymentRestConsumer;


@RestController
public class BnakRestController {
	@Autowired
	private PaymentRestConsumer consumer;
	
	@GetMapping("/getBankData")
	public String getBankData()
	{
		return "From Bank: thank you for using icici for: "+consumer.getData(); 
	}
}
