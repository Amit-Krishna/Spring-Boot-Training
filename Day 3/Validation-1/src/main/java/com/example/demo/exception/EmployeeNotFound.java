package com.example.demo.exception;


public class EmployeeNotFound extends RuntimeException {
	public EmployeeNotFound(String msg)
	{
		super(msg);
	}

}
