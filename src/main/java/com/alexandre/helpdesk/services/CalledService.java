package com.alexandre.helpdesk.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alexandre.helpdesk.domain.Called;
import com.alexandre.helpdesk.domain.Client;
import com.alexandre.helpdesk.domain.Technician;
import com.alexandre.helpdesk.domain.dtos.CalledDTO;
import com.alexandre.helpdesk.domain.enums.Priority;
import com.alexandre.helpdesk.domain.enums.Status;
import com.alexandre.helpdesk.repositories.CalledRepository;
import com.alexandre.helpdesk.services.exceptions.ObjectNotFoundException;

@Service
public class CalledService {
	
	@Autowired
	private CalledRepository repository;
	
	@Autowired
	private TechnicianService technicianService;
	
	@Autowired
	private ClientService clientService;
	
	public Called fyndById(Integer id) {
		Optional<Called> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto de id '" + id + "' não encontrado"));
	}

	public List<Called> findAll() {
		return repository.findAll();
	}

	public Called create(@Valid CalledDTO objDTO) {
		return repository.save(newCalled(objDTO));
	}
	
	private Called newCalled(CalledDTO obj) {
		Technician technician = technicianService.fyndById(obj.getTechnician());
		Client client = clientService.fyndById(obj.getClient());
		
		Called called = new Called();
		if(obj.getId() != null) {
			called.setId(obj.getId());
		}
		called.setTechnician(technician);
		called.setClient(client);
		called.setPriority(Priority.toEnum(obj.getPriority()));
		called.setStatus(Status.toEnum(obj.getStatus()));
		called.setTitle(obj.getTitle());
		called.setComments(obj.getComments());
		return called;
	}
}
