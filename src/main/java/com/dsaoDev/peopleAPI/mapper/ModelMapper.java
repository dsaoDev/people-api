package com.dsaoDev.peopleAPI.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.dsaoDev.peopleAPI.dtos.PersonRequestDTO;
import com.dsaoDev.peopleAPI.dtos.PersonResponseDTO;
import com.dsaoDev.peopleAPI.entities.Person;



@Mapper()
public interface ModelMapper {
	
	ModelMapper INSTANCE = Mappers.getMapper(ModelMapper.class);
	
	Person convertToPerson (PersonRequestDTO personDTO);
	PersonResponseDTO convertToDTO(Person person);
	List<PersonResponseDTO> listConverter(List<Person> list);


}
