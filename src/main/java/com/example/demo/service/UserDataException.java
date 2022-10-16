package com.example.demo.service;

public class UserDataException extends Exception {

	private static final long serialVersionUID = -4798965926484615958L;
	
	public UserDataException(String errorMessage) {
		super(errorMessage);
	}
}
