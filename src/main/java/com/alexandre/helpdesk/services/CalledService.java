package com.alexandre.helpdesk.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alexandre.helpdesk.domain.Called;
import com.alexandre.helpdesk.repositories.CalledRepository;
import com.alexandre.helpdesk.services.exceptions.ObjectNotFoundException;

@Service
public class CalledService {
	
	@Autowired
	private CalledRepository repository;
	
	public Called fyndById(Integer id) {
		Optional<Called> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto de id '" + id + "' não encontrado"));
	}
	
	
}
