package com.dsaoDev.peopleAPI.util;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.dsaoDev.peopleAPI.dtos.PersonRequestDTO;
import com.dsaoDev.peopleAPI.dtos.PersonResponseDTO;
import com.dsaoDev.peopleAPI.entities.Person;

@Component
public class PersonMapper {
	
	//Conversão de DTO para Pessoa
	public Person convertFromDtoToPerson(PersonRequestDTO personRequestDTO) {
		return Person.builder()
					.nome(personRequestDTO.getNome())
					.email(personRequestDTO.getEmail())
					.cpf(personRequestDTO.getCpf())
					.dataNasc(personRequestDTO.getDataNasc())
					.sexo(personRequestDTO.getSexo())
					.build();
	}
	
	//Conversão de Entidade pesssoa para DTO
	public PersonResponseDTO convertFromPersonToDTO(Person person) {
		return new PersonResponseDTO(person);
	}
	
	//Conversão de uma lista de Pessoas para uma Lista de PessoasDTO
	public List<PersonResponseDTO> converterLista(List<Person> personList){
		return personList.stream().map(person -> new PersonResponseDTO(person)).collect(Collectors.toList());
	}
	
	//Metodo apenas para atualizar os dados de uma Entidade pessoa de acordo com o Request do Usuario
	public void atualizarPessoa(Person person, PersonRequestDTO personDTO) {
		person.setEmail(personDTO.getEmail());
		person.setNome(personDTO.getNome());
		person.setCpf(personDTO.getCpf());
		person.setSexo(personDTO.getSexo());
		person.setDataNasc(personDTO.getDataNasc());
	}
	


}
