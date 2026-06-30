package com.example.demo.exception;

public class WrongPass extends RuntimeException {
	public WrongPass(String msg)
	{
		super(msg);
	}
}
