package com.dsaoDev.peopleAPI.errors;

import java.time.Instant;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ErrorDescription {
	
	private Instant timestamp;
	private Integer status;
	private String error;
	private String message;
	private String path;

}
