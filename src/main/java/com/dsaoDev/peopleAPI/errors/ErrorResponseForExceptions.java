package com.dsaoDev.peopleAPI.errors;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

public record ErrorResponseForExceptions(
		 @JsonFormat(shape = Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss") LocalDateTime timestamp,
		Integer status, String error, String message, String path) {

}
