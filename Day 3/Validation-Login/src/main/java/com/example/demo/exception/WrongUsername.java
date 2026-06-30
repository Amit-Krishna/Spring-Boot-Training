package com.example.demo.exception;


public class WrongUsername extends RuntimeException{
	public WrongUsername(String msg)
	{
		super(msg);
	}
}
