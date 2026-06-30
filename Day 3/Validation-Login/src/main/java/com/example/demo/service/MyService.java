package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.login;
import com.example.demo.exception.WrongUsername;
import com.example.demo.reposatory.MyRepo;

@Service
public class MyService {
	@Autowired
	private MyRepo repo;
	
	public String add(login l)
	{
		repo.save(l);
		return "Success";
	}
	public String handelLogin( @RequestParam String username,@RequestParam String password,Model model)
	{
		Optional<login> user = repo.findById(username);

	    if(user.isEmpty())
	    {
	        model.addAttribute("error", "User not found");
	        return "login";
	    }
//		
		login e=repo.getReferenceById(username);
		if(e.getPassword().equals(password))
		{
			model.addAttribute("username",e.getUsername());
			return "welcome";
		}
		model.addAttribute("error","user not found or wrong password");
		return "login";
	}
	public String showLoginPage() {
		return "login"; // login.html
		
	}
}
