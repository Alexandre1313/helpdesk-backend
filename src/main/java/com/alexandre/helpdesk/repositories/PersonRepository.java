package com.alexandre.helpdesk.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alexandre.helpdesk.domain.Person;

public interface PersonRepository extends JpaRepository<Person, Integer> {
	
	Optional<Person> findByItin(String itin);
	Optional<Person> findByEmail(String email);
}
