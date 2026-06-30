package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.reposatory.MyRepo;

@Service
public class MyServices {
	@Autowired
	private MyRepo repo;
	
	public boolean addUser(User user)
	{
		if("programmer".equalsIgnoreCase(user.getDesignation())) user.setSalary(25000);
		else if("manager".equalsIgnoreCase(user.getDesignation())) user.setSalary(30000);
		else if("tester".equalsIgnoreCase(user.getDesignation())) user.setSalary(20000);
		repo.save(user);
		return user.getBool();
		
	}
	
	public List<User> getUsers()
	{
		return repo.findAll();
	}
	
	public boolean handleSalaryRaise(int id)
	{
		Optional<User> user = repo.findById(id);
		if(user.isEmpty())return false;
	    User e = user.get();
		e.setSalary(2*e.getSalary());
		repo.save(e);
		return true;
	}
	public String exit()
	{
		return "Main";
	}
	
	 
}
