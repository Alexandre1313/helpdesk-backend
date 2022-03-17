package com.alexandre.helpdesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alexandre.helpdesk.domain.Person;

public interface PersonRepository extends JpaRepository<Person, Integer> {

}
