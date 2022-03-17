package com.alexandre.helpdesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alexandre.helpdesk.domain.Called;

public interface CalledRepository extends JpaRepository<Called, Integer> {

}
