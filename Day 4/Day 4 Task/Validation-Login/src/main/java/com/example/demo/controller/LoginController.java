package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.login;
import com.example.demo.service.MyService;

import jakarta.validation.Valid;

@RestController
public class LoginController {
	@Autowired
	private MyService service;
	
	@PostMapping("/add")
	public String add(@Valid @RequestBody login l)
	{
		return service.add(l);
	}
	
}
