package com.dsaoDev.peopleAPI.dtos;

import java.time.LocalDate;

import com.dsaoDev.peopleAPI.entities.Person;
import com.dsaoDev.peopleAPI.entities.enums.Genero;

import lombok.Getter;

@Getter
public class PersonResponseDTO {
	
	private Long id;
	
	private String nome;

	private String email;
	
	private String cpf;
	
	private LocalDate dataNasc;
	
	private Genero sexo;


	public PersonResponseDTO(Person entity) {
		this.id = entity.getId();
		this.nome = entity.getNome();
		this.email = entity.getEmail();
		this.cpf = entity.getCpf();
		this.dataNasc = entity.getDataNasc();
		this.sexo = entity.getSexo();
	}
	
	
}
