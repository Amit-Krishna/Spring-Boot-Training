package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Entity
public class login {
	@Id
	@NotNull(message="Name should be not null")
	@Pattern(regexp="^[a-zA-Z0-9]+$",message="Name must only contain letters and numbers")
	private String username;
	
	@NotNull(message="Password should not be null")
	@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[^a-zA-Z0-9]).{4,16}$",message="Pass must contain letters numers and special char")
	private String password;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public login(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	public login() {}
}
