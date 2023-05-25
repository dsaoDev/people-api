package com.dsaoDev.peopleAPI.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dsaoDev.peopleAPI.dtos.PersonRequestDTO;
import com.dsaoDev.peopleAPI.dtos.PersonResponseDTO;
import com.dsaoDev.peopleAPI.entities.Person;
import com.dsaoDev.peopleAPI.exceptions.PersonNotFoundException;
import com.dsaoDev.peopleAPI.mapper.ModelMapper;
import com.dsaoDev.peopleAPI.repositories.PersonRepository;
import com.dsaoDev.peopleAPI.util.PersonUtil;

@Service
public class PersonServiceImpl implements PersonService {
	
	@Autowired
	PersonRepository repository;
	@Autowired
	PersonUtil personUtil;

	

	@Override
	public PersonResponseDTO save(PersonRequestDTO personRequestDTO) {
		Person person = ModelMapper.INSTANCE.convertToPerson(personRequestDTO);
		return ModelMapper.INSTANCE.convertToDTO(repository.save(person));
		
		
		
		
	}

	@Override
	public List<PersonResponseDTO> findAll() {
		return ModelMapper.INSTANCE.listConverter(personUtil.checkIfListIsEmpty(repository.findAll()));
		
	}
	
	@Override
	public PersonResponseDTO findById(Long id) {
		return ModelMapper.INSTANCE.convertToDTO(repository.findById(id).orElseThrow(() -> new PersonNotFoundException("id: " + id + " não existe")));
	}

	@Override
	public PersonResponseDTO update(PersonRequestDTO personRequestDTO, Long id) {
		Person person = returnPerson(id);
		personUtil.atualizarPessoa(person, personRequestDTO);
		return ModelMapper.INSTANCE.convertToDTO(repository.save(person));
		
	}

	@Override
	public String deleteById(Long id) {
		Person person = returnPerson(id);
		repository.deleteById(person.getId());
		return "Pessoa com id: " + id + " foi deletado com Sucesso";
	}
	
	
	
	
	  //FindById retornando Person // Re-uso
		public Person returnPerson(Long id) {
			return repository.findById(id).orElseThrow(() -> new PersonNotFoundException("id: " + id + " não existe"));
		}


}
