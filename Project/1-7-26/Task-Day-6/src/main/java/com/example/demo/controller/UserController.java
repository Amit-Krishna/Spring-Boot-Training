package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.UserEntity;
import com.example.demo.services.MyServices;

import jakarta.ws.rs.Path;

@RestController
public class UserController {
	@Autowired
	private MyServices services;
	
	@PostMapping("/addUser")
	public String addUser(@RequestBody UserEntity user)
	{
		return services.addUser(user);
	}
	
	@GetMapping("getAllUsers")
	public List<UserEntity> getAllUsers()
	{
		return services.getUsers();
	}
	
	@PutMapping("/raiseSalary/{id}/{raisePercent}")
	public String raiseSalary(@PathVariable int id,@PathVariable double raisePercent)
	{
		return services.handleSalaryRaise(id, raisePercent);
	}
}
