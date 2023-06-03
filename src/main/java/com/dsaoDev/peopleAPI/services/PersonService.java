package com.dsaoDev.peopleAPI.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.dsaoDev.peopleAPI.dtos.PersonRequestDTO;
import com.dsaoDev.peopleAPI.dtos.PersonResponseDTO;

public interface PersonService {
	
	 PersonResponseDTO save(PersonRequestDTO personRequestDTO);
	 
	 Page<PersonResponseDTO> findAll(Pageable pageable);
	 
	 PersonResponseDTO findById(Long id);
	 
	 PersonResponseDTO update (PersonRequestDTO personRequestDTO, Long id);
	 
	 String deleteById(Long id);
	
}
