package com.dsaoDev.peopleAPI.services;

import java.util.List;

import com.dsaoDev.peopleAPI.dtos.PersonRequestDTO;
import com.dsaoDev.peopleAPI.dtos.PersonResponseDTO;

public interface PersonService {
	
	 PersonResponseDTO save(PersonRequestDTO personRequestDTO);
	 
	 List<PersonResponseDTO> findAll();
	 
	 PersonResponseDTO findById(Long id);
	 
	 PersonResponseDTO update (PersonRequestDTO personRequestDTO, Long id);
	 
	 String deleteById(Long id);
	
}
