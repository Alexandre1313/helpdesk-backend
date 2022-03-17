package com.alexandre.helpdesk.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alexandre.helpdesk.domain.Called;
import com.alexandre.helpdesk.domain.Client;
import com.alexandre.helpdesk.domain.Technician;
import com.alexandre.helpdesk.domain.enums.Priority;
import com.alexandre.helpdesk.domain.enums.Profile;
import com.alexandre.helpdesk.domain.enums.Status;
import com.alexandre.helpdesk.repositories.CalledRepository;
import com.alexandre.helpdesk.repositories.ClientRepository;
import com.alexandre.helpdesk.repositories.TechnicianRepository;

@Service
public class DBServices {
	
	@Autowired
	private TechnicianRepository technicianRepository; 
	@Autowired
	private ClientRepository clientRepository;
	@Autowired
	private CalledRepository calledRepository;
	
	public void instantiateDb() {
		Technician	technicianOne = new Technician(null, "Alexandre Cordeiro",
				"00061268984", "alexandre.13a@gmail.com", "123");
		technicianOne.addProfiles(Profile.ADMIN);
		
		Client clientOne = new Client(null, "Linus Torvald", "03113040957",
				"torvalds@gmail.com", "123");
		
		Called called = new Called(null, Priority.MEDIA, Status.ANDAMENTO,
				"Chamado 01", "Primeiro chamado", technicianOne, clientOne);
		
		technicianRepository.saveAll(Arrays.asList(technicianOne));
		clientRepository.saveAll(Arrays.asList(clientOne));
		calledRepository.saveAll(Arrays.asList(called));
	}
}
