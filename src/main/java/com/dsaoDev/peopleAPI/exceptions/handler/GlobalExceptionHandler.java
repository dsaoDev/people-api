package com.dsaoDev.peopleAPI.exceptions.handler;

import java.sql.SQLIntegrityConstraintViolationException;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.dsaoDev.peopleAPI.errors.ErrorDescription;
import com.dsaoDev.peopleAPI.exceptions.EmptyListException;
import com.dsaoDev.peopleAPI.exceptions.PersonNotFoundException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(PersonNotFoundException.class)
	public ResponseEntity<ErrorDescription> entityNotFoundE(PersonNotFoundException e, HttpServletRequest request) {
		ErrorDescription error = new ErrorDescription(Instant.now(), HttpStatus.NOT_FOUND.value(),
				"Entidade não foi encontrada", e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);

	}

	@ExceptionHandler(EmptyListException.class)
	public ResponseEntity<ErrorDescription> emptyListEx(EmptyListException e, HttpServletRequest request) {
		ErrorDescription error = new ErrorDescription(Instant.now(), HttpStatus.NOT_FOUND.value(), "Lista vazia",
				e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}

	@ExceptionHandler(SQLIntegrityConstraintViolationException.class)
	public ResponseEntity<ErrorDescription> constraintViolationE(SQLIntegrityConstraintViolationException e,
			HttpServletRequest request) {
		ErrorDescription error = new ErrorDescription(Instant.now(), HttpStatus.BAD_REQUEST.value(),
				"Violação de identidade", "CPF OU EMAIL já cadastrados no sistema", request.getRequestURI());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> MethodArgumentNotValidE(MethodArgumentNotValidException e) {
		Map<String, String> mapOfErrors = new HashMap<>();

		e.getBindingResult().getFieldErrors()
				.forEach(error -> mapOfErrors.put("Erro no campo -> " + error.getField(), error.getDefaultMessage()));

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(mapOfErrors);

	}

	
	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<ErrorDescription> HttpMessageNotReadableE(HttpMessageNotReadableException e,
			HttpServletRequest request) {
		ErrorDescription error = new ErrorDescription(Instant.now(), HttpStatus.BAD_REQUEST.value(),
				"Parametro de data invalido", "Formato de data esperado dd/MM/yyyy", request.getRequestURI());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}
	 
}
