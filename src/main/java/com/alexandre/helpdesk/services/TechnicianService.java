package com.alexandre.helpdesk.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alexandre.helpdesk.domain.Technician;
import com.alexandre.helpdesk.repositories.TechnicianRepository;

@Service
public class TechnicianService {

	@Autowired
	private TechnicianRepository repository;
	
	public Technician fyndById(Integer id) {
		Optional<Technician> obj = repository.findById(id);
		return obj.orElse(null);
	}
}
