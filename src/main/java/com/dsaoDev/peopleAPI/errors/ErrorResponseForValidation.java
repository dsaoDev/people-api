package com.dsaoDev.peopleAPI.errors;

import java.time.LocalDateTime;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder(value = {"timeStamp", "status", "error" , "mapaDeErros", "path"})
public record ErrorResponseForValidation(
			@JsonFormat(shape = Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
			
		    LocalDateTime timeStamp, 
			 Integer status,
			  String error ,
			 String path,
		 Map<String,String> mapaDeErros) {
				
	 

}
