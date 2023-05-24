package com.dsaoDev.peopleAPI.exceptions.handler;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.dsaoDev.peopleAPI.errors.ErrorDescription;
import com.dsaoDev.peopleAPI.exceptions.EmptyListException;
import com.dsaoDev.peopleAPI.exceptions.PersonNotFoundException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(PersonNotFoundException.class)
	public ResponseEntity<ErrorDescription> EntityNotFoundE(PersonNotFoundException e, HttpServletRequest request){
		 ErrorDescription error = new ErrorDescription(Instant.now(), HttpStatus.NOT_FOUND.value(), "Entidade não foi encontrada", e.getMessage(), request.getRequestURI());
		 return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
		                        
	}
	
	@ExceptionHandler(EmptyListException.class)
	public ResponseEntity<ErrorDescription> EmptyListEx(EmptyListException e, HttpServletRequest request){
		ErrorDescription error = new ErrorDescription(Instant.now(), HttpStatus.NOT_FOUND.value(), "Lista vazia", e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}
}
