package com.dsaoDev.peopleAPI.util;

import java.util.List;

import org.springframework.stereotype.Component;

import com.dsaoDev.peopleAPI.dtos.PersonRequestDTO;
import com.dsaoDev.peopleAPI.entities.Person;
import com.dsaoDev.peopleAPI.exceptions.EmptyListException;

@Component
public class PersonUtil {
	
	
	
	
	public void atualizarPessoa(Person person, PersonRequestDTO personDTO) {
		person.setEmail(personDTO.getEmail());
		person.setNome(personDTO.getNome());
		person.setCpf(personDTO.getCpf());
		person.setSexo(personDTO.getSexo());
		person.setDataNasc(personDTO.getDataNasc());
	}
	
	public List<Person> checkIfListIsEmpty (List<Person> list) {
		if (list.isEmpty()) {
			throw new EmptyListException("no momento a lista se encontra vazia");
		}
		return list;

	}


}
