package com.dsaoDev.peopleAPI.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dsaoDev.peopleAPI.entities.Person;

public interface PersonRepository extends JpaRepository<Person, Long>{

}
