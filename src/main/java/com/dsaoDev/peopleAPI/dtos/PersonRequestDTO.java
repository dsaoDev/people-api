package com.dsaoDev.peopleAPI.dtos;

import java.util.Date;

import org.hibernate.validator.constraints.br.CPF;

import com.dsaoDev.peopleAPI.entities.enums.Genero;
import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;


@Getter

public class PersonRequestDTO {


	@Schema(description = "Nome da Pessoa", example = "string")
	@NotBlank(message = "campo nome é obrigatorio")
	@Size(min = 2, message = "nome tem que ter pelomenos 2 caracteres")
	private String nome;

	@Schema(description = "Endereço de Email", example = "string" ,pattern = "aaaa@hotmail.com")
	@NotBlank(message = "campo email é obrigatorio")
	@Email(message = "email mal formado")
	private String email;
	
	@Schema(description = "CPF DA PESSOA", example = "string", pattern = "XXX.XXX.XXX-XX")
	@NotNull(message = "campo cpf é obrigatorio")
	@CPF(message = "CPF mal formado (exemplo -> ###-###-###-##)")
	private String cpf;

	@Schema(description = "DATA DE NASCIMENTO", example = "dd/MM/yyyy", pattern = "dd/MM/yyyy")
	@JsonFormat(pattern = "dd/MM/yyyy")
	@NotNull(message = "campo DATA é obrigatorio")
	private Date dataNasc;
	
	@Schema(description = "GENERO", example = "string", pattern = "MASCULINO/FEMININO")
	private Genero sexo;

}
