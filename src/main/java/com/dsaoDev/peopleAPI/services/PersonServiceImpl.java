package com.dsaoDev.peopleAPI.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dsaoDev.peopleAPI.dtos.PersonRequestDTO;
import com.dsaoDev.peopleAPI.dtos.PersonResponseDTO;
import com.dsaoDev.peopleAPI.entities.Person;
import com.dsaoDev.peopleAPI.repositories.PersonRepository;
import com.dsaoDev.peopleAPI.util.PersonMapper;

import jakarta.persistence.EntityNotFoundException;

@Service
public class PersonServiceImpl implements PersonService {
	
	@Autowired
	PersonRepository repository;
	@Autowired
	PersonMapper personMapper;

	@Override
	public PersonResponseDTO save(PersonRequestDTO personRequestDTO) {
		Person person = personMapper.convertFromDtoToPerson(personRequestDTO);
		return personMapper.convertFromPersonToDTO(repository.save(person));
	}

	@Override
	public List<PersonResponseDTO> findAll() {
		return personMapper.converterLista(repository.findAll());
	}
	
	//FindById retornando PersonResponseDTO
	@Override
	public PersonResponseDTO findById(Long id) {
		return personMapper.convertFromPersonToDTO(repository.findById(id).orElseThrow(() -> new EntityNotFoundException()));
	}

	@Override
	public PersonResponseDTO update(PersonRequestDTO personRequestDTO, Long id) {
		Person person = returnPerson(id);
		personMapper.atualizarPessoa(person, personRequestDTO);
		return personMapper.convertFromPersonToDTO(repository.save(person));
		
	}

	@Override
	public String deleteById(Long id) {
		Person person = returnPerson(id);
		repository.deleteById(person.getId());
		return "Pessoa com id: " + id + " foi deletado com Sucesso";
	}
	
	
	
	
	  //FindById retornando Person // Re-uso
		public Person returnPerson(Long id) {
			return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Id não encontrado : " + id));
		}


}
