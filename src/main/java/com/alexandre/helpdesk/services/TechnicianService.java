package com.alexandre.helpdesk.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alexandre.helpdesk.domain.Technician;
import com.alexandre.helpdesk.domain.dtos.TechnicianDTO;
import com.alexandre.helpdesk.repositories.TechnicianRepository;
import com.alexandre.helpdesk.services.exceptions.ObjectNotFoundException;

@Service
public class TechnicianService {

	@Autowired
	private TechnicianRepository repository;
	
	public Technician fyndById(Integer id) {
		Optional<Technician> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto de id '" + id + "' não encontrado"));
	}

	public List<Technician> findAll() {
		return repository.findAll();
	}

	public Technician create(TechnicianDTO objDTO) {
		objDTO.setId(null);
		Technician newObj = new Technician(objDTO);
		return repository.save(newObj);
	}
}
