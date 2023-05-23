package com.dsaoDev.peopleAPI.exceptions;

public class PersonNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public PersonNotFoundException(String msg) {
		super(msg);
	}
	
}
