package com.dsaoDev.peopleAPI.dtos;

import java.util.Date;

import com.dsaoDev.peopleAPI.entities.Person;
import com.dsaoDev.peopleAPI.entities.enums.Genero;
import com.fasterxml.jackson.annotation.JsonFormat;


public class PersonResponseDTO {
	
	private Long id;
	
	private String nome;

	private String email;
	
	private String cpf;
	
	private Date dataNasc;
	
	private Genero sexo;


	public PersonResponseDTO(Person entity) {
		this.id = entity.getId();
		this.nome = entity.getNome();
		this.email = entity.getEmail();
		this.cpf = entity.getCpf();
		this.dataNasc = entity.getDataNasc();
		this.sexo = entity.getSexo();
	}


	public Long getId() {
		return id;
	}


	public String getNome() {
		return nome;
	}


	public String getEmail() {
		return email;
	}


	public String getCpf() {
		return cpf;
	}
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd/MM/yyyy")
	public Date getDataNasc() {
		return dataNasc;
	}


	public Genero getSexo() {
		return sexo;
	}
	
	
	
	
}
