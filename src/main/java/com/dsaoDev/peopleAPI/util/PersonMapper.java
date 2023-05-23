package com.dsaoDev.peopleAPI.util;

import org.springframework.stereotype.Component;

import com.dsaoDev.peopleAPI.dtos.PersonRequestDTO;
import com.dsaoDev.peopleAPI.dtos.PersonResponseDTO;
import com.dsaoDev.peopleAPI.entities.Person;

@Component
public class PersonMapper {
	
	public Person convertFromDtoToPerson(PersonRequestDTO personRequestDTO) {
		return Person.builder()
					.nome(personRequestDTO.getNome())
					.email(personRequestDTO.getEmail())
					.cpf(personRequestDTO.getCpf())
					.dataNasc(personRequestDTO.getDataNasc())
					.sexo(personRequestDTO.getSexo())
					.build();
	}
	
	public PersonResponseDTO convertFromPersonToDTO(Person person) {
		return new PersonResponseDTO(person);
	}
	


}
