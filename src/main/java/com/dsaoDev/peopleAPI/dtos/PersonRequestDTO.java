package com.dsaoDev.peopleAPI.dtos;

import java.time.LocalDate;

import com.dsaoDev.peopleAPI.entities.enums.Genero;

import lombok.Getter;

@Getter
public class PersonRequestDTO {

	

	private String nome;
	
	private String email;
	
	private String cpf;
	
	private LocalDate dataNasc;
	
	private Genero sexo;
}
