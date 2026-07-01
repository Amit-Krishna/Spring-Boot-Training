package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.demo.entity.UserEntity;
import com.example.demo.reposatory.MyRepo;

@Service
public class MyServices {
	@Autowired
	private MyRepo repo;
	
	public String addUser(UserEntity user)
	{
		if("programmer".equalsIgnoreCase(user.getDesignation())) user.setSalary(25000);
		else if("manager".equalsIgnoreCase(user.getDesignation())) user.setSalary(30000);
		else if("tester".equalsIgnoreCase(user.getDesignation())) user.setSalary(20000);
		repo.save(user);
		return "Success";
	}
	
	public List<UserEntity> getUsers()
	{
		return repo.findAll();
	}
	
	public String handleSalaryRaise(int id,double raisePercent)
	{
		Optional<UserEntity> user = repo.findById(id);
		if(user.isEmpty())return "Id dosent exist";
	    UserEntity e = user.get();
		e.setSalary((1+(raisePercent/100))*e.getSalary());
		repo.save(e);
		return "Success";
	}
	public String exit()
	{
		return "Thanks for using our services";
	}
}
