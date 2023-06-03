package com.dsaoDev.peopleAPI.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dsaoDev.peopleAPI.dtos.PersonRequestDTO;
import com.dsaoDev.peopleAPI.dtos.PersonResponseDTO;
import com.dsaoDev.peopleAPI.services.PersonService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/api/people")
public class PersonController {
	
	@Autowired
	private PersonService personService;
	
	@PostMapping
	public ResponseEntity<PersonResponseDTO> save (@Valid @RequestBody PersonRequestDTO personDTO){
		return new ResponseEntity<PersonResponseDTO>(personService.save(personDTO), HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<Page<PersonResponseDTO>> findAll(Pageable pageable){
		return ResponseEntity.ok(personService.findAll(pageable));
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<PersonResponseDTO> findById (@PathVariable(name = "id") Long id){
		return ResponseEntity.ok(personService.findById(id));
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<PersonResponseDTO> update (@Valid @RequestBody PersonRequestDTO personDTO, @PathVariable(name = "id")Long id){
		return ResponseEntity.ok(personService.update(personDTO, id));
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<String> delete (@PathVariable(name = "id") Long id){
		return ResponseEntity.ok(personService.deleteById(id));
	}
	

}
