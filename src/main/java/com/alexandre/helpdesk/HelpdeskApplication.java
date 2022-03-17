package com.alexandre.helpdesk;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.alexandre.helpdesk.domain.Called;
import com.alexandre.helpdesk.domain.Client;
import com.alexandre.helpdesk.domain.Technician;
import com.alexandre.helpdesk.domain.enums.Priority;
import com.alexandre.helpdesk.domain.enums.Profile;
import com.alexandre.helpdesk.domain.enums.Status;
import com.alexandre.helpdesk.repositories.CalledRepository;
import com.alexandre.helpdesk.repositories.ClientRepository;
import com.alexandre.helpdesk.repositories.TechnicianRepository;

@SpringBootApplication
public class HelpdeskApplication implements CommandLineRunner {
	
	@Autowired
	private TechnicianRepository technicianRepository; 
	@Autowired
	private ClientRepository clientRepository;
	@Autowired
	private CalledRepository calledRepository;

	public static void main(String[] args) {
		SpringApplication.run(HelpdeskApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
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
