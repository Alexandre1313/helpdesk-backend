package com.alexandre.helpdesk.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
	
	@Autowired
	private BCryptPasswordEncoder enc;
	
	public void instantiateDb() {
		Technician	technicianOne = new Technician(null, "Alexandre Cordeiro",
				"00061268984", "alexandre.13a@gmail.com", enc.encode("13041979"));
		technicianOne.addProfiles(Profile.ADMIN);
		
		Client clientOne = new Client(null, "Linus Torvald", "03113040957",
				"torvalds@gmail.com", enc.encode("12356"));
		
		Called calledOne = new Called(null, Priority.MEDIA, Status.ANDAMENTO,
				"Chamado 01", "Primeiro chamado", technicianOne, clientOne);
		
		
		Technician	technicianTwo = new Technician(null, "Paulo Gouvea da Costa",
				"87739562874", "pgouvea@gmail.com", enc.encode("5893"));
		technicianTwo.addProfiles(Profile.TECNICO);
		
		Client clientTwo = new Client(null, "Pedro Goulart", "97202482622",
				"pg@gmail.com", enc.encode("7458"));
		
		Called calledTwo = new Called(null, Priority.BAIXA, Status.ABERTO,
				"Chamado 02", "Segundo chamado", technicianTwo, clientTwo);
		
		
		Technician	technicianThree = new Technician(null, "Ambrósio Pinto da Cruz",
				"54114095861", "ambrosino@gmail.com", enc.encode("3340"));
		technicianThree.addProfiles(Profile.TECNICO);
		
		Client clientThree = new Client(null, "Carlos Pereira Gomes", "69214454299",
				"cpg@gmail.com", enc.encode("334596"));
		
		Technician	technicianFour = new Technician(null, "Ancelmo Nunes Barreto",
				"79652831310", "anc.nunes@gmail.com", enc.encode("999865"));
		technicianFour.addProfiles(Profile.TECNICO);
		
		Client clientFour = new Client(null, "Gabriel Pereira Matos", "26403981307",
				"gaby.per.matos@gmail.com", enc.encode("332587"));
		
		Called calledFour = new Called(null, Priority.MEDIA, Status.ANDAMENTO,
				"Chamado 04", "Quarto chamado", technicianFour, clientFour);
		
		
		Technician	technicianFive = new Technician(null, "Mauricio Calabrez",
				"35811220812", "maurici@gmail.com", enc.encode("123589745"));
		technicianFive.addProfiles(Profile.TECNICO);
		
		Client clientFive = new Client(null, "Teles da Siva Peixoto", "49202526419",
				"telespeix@gmail.com", enc.encode("49863"));
		
		Called calledFive = new Called(null, Priority.ALTA, Status.ABERTO,
				"Chamado 05", "Quinto chamado", technicianFive, clientFive);
		
		
		Technician	technicianSix = new Technician(null, "Andrade Benetton",
				"26185786940", "andrade.b@gmail.com", enc.encode("4125896"));
		technicianSix.addProfiles(Profile.TECNICO);
		
		Client clientSix = new Client(null, "Larissa Monterey", "26286457500",
				"larissa.jk@gmail.com", enc.encode("3365879"));
		
		Called calledSix = new Called(null, Priority.MEDIA, Status.ANDAMENTO,
				"Chamado 06", "Sexto chamado", technicianSix, clientSix);
		
		
		Technician	technicianSeven = new Technician(null, "Osvaldo Lindberg",
				"35768744886", "osvald.lind@gmail.com", enc.encode("9998656985"));
		technicianSeven.addProfiles(Profile.TECNICO);
		
		Client clientSeven = new Client(null, "Abel da luz", "96666702328",
				"abel.hgf@gmail.com", enc.encode("123321"));
		
		Called calledSeven = new Called(null, Priority.MEDIA, Status.ANDAMENTO,
				"Chamado 07", "Sétimo chamado", technicianSeven, clientSeven);
		
		
		technicianRepository.saveAll(Arrays.asList(technicianOne, technicianTwo, technicianThree, 
				technicianFour, technicianFive, technicianSix, technicianSeven));
		clientRepository.saveAll(Arrays.asList(clientOne, clientTwo, clientThree, 
				clientFour, clientFive, clientSix, clientSeven));
		calledRepository.saveAll(Arrays.asList(calledOne, calledTwo, 
				calledFour, calledFive, calledSix, calledSeven));
	}
}
