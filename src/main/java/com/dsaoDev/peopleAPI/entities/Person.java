package com.dsaoDev.peopleAPI.entities;

import java.time.LocalDate;

import com.dsaoDev.peopleAPI.entities.enums.Genero;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Person {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Setter(value = AccessLevel.NONE)
	private Long id;
	
	@Column(nullable = false, length = 30)
	private String nome;
	
	@Column(nullable = false, length = 30)
	private String email;
	
	@Column(nullable = false, length = 14, unique = true)
	private String cpf;
	
	@Column(nullable = false)
	private LocalDate dataNasc;
	
	@Enumerated(EnumType.STRING)
	private Genero sexo;

	@Builder
	public Person(String nome, String email, String cpf, LocalDate dataNasc, Genero sexo) {
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
		this.dataNasc = dataNasc;
		this.sexo = sexo;
	}
	
	

}
