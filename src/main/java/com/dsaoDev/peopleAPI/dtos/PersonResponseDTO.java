package com.dsaoDev.peopleAPI.dtos;

import java.time.LocalDateTime;
import java.util.Date;

import com.dsaoDev.peopleAPI.entities.enums.Genero;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import lombok.NoArgsConstructor;
import lombok.Setter;



@NoArgsConstructor
@Setter
public class PersonResponseDTO {
	
	
	  private Long id;
	  
	  private String nome;
	  
	  private String email;
	  
	  private String cpf;
	  
	  private Date dataNasc;
	  
	  private Genero sexo;
	  
	  @JsonFormat(shape = Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
	  private LocalDateTime dataCriacao;
	  
	  
	 
	  

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
	
	@JsonFormat(pattern="dd/MM/yyyy")
	public Date getDataNasc() {
		return dataNasc;
	}

	public Genero getSexo() {
		return sexo;
	}
	 
	
	


	
	
	
}
