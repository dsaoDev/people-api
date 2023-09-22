package com.dsaoDev.peopleAPI.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import com.dsaoDev.peopleAPI.dtos.PersonRequestDTO;
import com.dsaoDev.peopleAPI.dtos.PersonResponseDTO;
import com.dsaoDev.peopleAPI.entities.Person;



@Mapper(unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface PeopleMapper {
	
	PeopleMapper INSTANCE = Mappers.getMapper(PeopleMapper.class);
	
	PersonResponseDTO convertToDTO(Person person);
	Person convertToPerson (PersonRequestDTO personDTO);


}
