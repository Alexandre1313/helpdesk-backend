package com.alexandre.helpdesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alexandre.helpdesk.domain.Technician;

public interface TechnicianRepository extends JpaRepository<Technician, Integer> {

}
