package com.dsaoDev.peopleAPI.exceptions;

public class EmptyPageException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public EmptyPageException(String msg) {
		super(msg);
	}
	
}
