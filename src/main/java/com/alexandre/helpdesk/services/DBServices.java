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
				"torvalds@gmail.com", "12356");
		
		Called calledOne = new Called(null, Priority.MEDIA, Status.ANDAMENTO,
				"Chamado 01", "Primeiro chamado", technicianOne, clientOne);
		
		
		Technician	technicianTwo = new Technician(null, "Paulo Gouvea da Costa",
				"87739562874", "pgouvea@gmail.com", "5893");
		technicianOne.addProfiles(Profile.TECNICO);
		
		Client clientTwo = new Client(null, "Pedro Goulart", "97202482622",
				"pg@gmail.com", "7458");
		
		Called calledTwo = new Called(null, Priority.BAIXA, Status.ABERTO,
				"Chamado 02", "Segundo chamado", technicianTwo, clientTwo);
		
		
		Technician	technicianThree = new Technician(null, "Ambrósio Pinto da Cruz",
				"54114095861", "ambrosino@gmail.com", "3340");
		technicianOne.addProfiles(Profile.TECNICO);
		
		Client clientThree = new Client(null, "Carlos Pereira Gomes", "69214454299",
				"cpg@gmail.com", "334596");
		
		Called calledThree = new Called(null, Priority.ALTA, Status.ENCERRADO,
				"Chamado 03", "Terceiro chamado", technicianThree, clientThree);
		
		
		Technician	technicianFour = new Technician(null, "Ancelmo Nunes Barreto",
				"79652831310", "anc.nunes@gmail.com", "999865");
		technicianOne.addProfiles(Profile.TECNICO);
		
		Client clientFour = new Client(null, "Gabriel Pereira Matos", "26403981307",
				"gaby.per.matos@gmail.com", "332587");
		
		Called calledFour = new Called(null, Priority.MEDIA, Status.ANDAMENTO,
				"Chamado 04", "Quarto chamado", technicianFour, clientFour);
		
		
		Technician	technicianFive = new Technician(null, "Mauricio Calabrez",
				"35811220812", "maurici@gmail.com", "123589745");
		technicianOne.addProfiles(Profile.TECNICO);
		
		Client clientFive = new Client(null, "Teles da Siva Peixoto", "49202526419",
				"telespeix@gmail.com", "49863");
		
		Called calledFive = new Called(null, Priority.ALTA, Status.ABERTO,
				"Chamado 05", "Quinto chamado", technicianFive, clientFive);
		
		
		Technician	technicianSix = new Technician(null, "Andrade Benetton",
				"26185786940", "andrade.b@gmail.com", "4125896");
		technicianOne.addProfiles(Profile.TECNICO);
		
		Client clientSix = new Client(null, "Larissa Monterey", "26286457500",
				"larissa.jk@gmail.com", "3365879");
		
		Called calledSix = new Called(null, Priority.MEDIA, Status.ANDAMENTO,
				"Chamado 06", "Sexto chamado", technicianSix, clientSix);
		
		
		Technician	technicianSeven = new Technician(null, "Osvaldo Lindberg",
				"35768744886", "osvald.lind@gmail.com", "9998656985");
		technicianOne.addProfiles(Profile.TECNICO);
		
		Client clientSeven = new Client(null, "Abel da luz", "96666702328",
				"abel.hgf@gmail.com", "123321");
		
		Called calledSeven = new Called(null, Priority.MEDIA, Status.ANDAMENTO,
				"Chamado 07", "Sétimo chamado", technicianSeven, clientSeven);
		
		
		technicianRepository.saveAll(Arrays.asList(technicianOne, technicianTwo, technicianThree, 
				technicianFour, technicianFive, technicianSix, technicianSeven));
		clientRepository.saveAll(Arrays.asList(clientOne, clientTwo, clientThree, 
				clientFour, clientFive, clientSix, clientSeven));
		calledRepository.saveAll(Arrays.asList(calledOne, calledTwo, calledThree, 
				calledFour, calledFive, calledSix, calledSeven));
	}
}
