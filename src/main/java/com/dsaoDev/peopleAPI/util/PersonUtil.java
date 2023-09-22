package com.dsaoDev.peopleAPI.util;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.dsaoDev.peopleAPI.dtos.PersonRequestDTO;
import com.dsaoDev.peopleAPI.dtos.PersonResponseDTO;
import com.dsaoDev.peopleAPI.entities.Person;
import com.dsaoDev.peopleAPI.exceptions.EmptyPageException;
import com.dsaoDev.peopleAPI.mapper.PeopleMapper;

@Component
public class PersonUtil {
	
	public void atualizarPessoa(Person person, PersonRequestDTO personDTO) {
		person.setEmail(personDTO.getEmail());
		person.setNome(personDTO.getNome());
		person.setCpf(personDTO.getCpf());
		person.setSexo(personDTO.getSexo());
		person.setDataNasc(personDTO.getDataNasc());
	}
	
	public Page<Person> checkIfPageIsEmpty (Page<Person> pageOfPerson) {
		if (pageOfPerson.isEmpty()) {
			throw new EmptyPageException("Paginas vazias");
		}
		return pageOfPerson;

	}
	
	public Page<PersonResponseDTO> pageConverter (Page<Person> pageOfEntity){
		 Page<PersonResponseDTO> dtosPage = pageOfEntity.map(this::returnInstanceConverter);
		 return dtosPage;
			
		}
	
	public PersonResponseDTO returnInstanceConverter(Person person) {
	return PeopleMapper.INSTANCE.convertToDTO(person);

 }

}
