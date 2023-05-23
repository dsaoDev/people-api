package com.dsaoDev.peopleAPI.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dsaoDev.peopleAPI.dtos.PersonRequestDTO;
import com.dsaoDev.peopleAPI.dtos.PersonResponseDTO;
import com.dsaoDev.peopleAPI.repositories.PersonRepository;
import com.dsaoDev.peopleAPI.util.PersonMapper;

@Service
public class PersonServiceImpl implements PersonService {
	
	@Autowired
	PersonRepository repository;
	@Autowired
	PersonMapper personMapper;

	@Override
	public PersonResponseDTO save(PersonRequestDTO personRequestDTO) {
		return null;
	}

	@Override
	public List<PersonResponseDTO> findAll() {
		return null;
	}

	@Override
	public PersonResponseDTO findById(Long id) {
		return null;
	}

	@Override
	public PersonResponseDTO update(PersonRequestDTO personRequestDTO, Long id) {
		return null;
	}

	@Override
	public String deleteById(Long id) {
		return null;
	}
	


}
