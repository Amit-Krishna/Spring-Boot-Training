package com.example.demo.except;

public class EmployeeNotFound extends RuntimeException {
	public EmployeeNotFound(String msg)
	{
		super(msg);
	}
}
