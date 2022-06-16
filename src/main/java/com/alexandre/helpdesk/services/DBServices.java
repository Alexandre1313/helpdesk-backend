package com.alexandre.helpdesk.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
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
				"63133496794", "alexandre.13a@gmail.com", enc.encode("2240890"));
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
		
		
		Technician	technicianEight = new Technician(null, "Osni César Pires Ribeiro",
				"09987430546", "osnipiresd@gmail.com", enc.encode("1234567"));
		technicianEight.addProfiles(Profile.ADMIN);
		
		Client clientEight = new Client(null, "Bruno Borba", "11774657368",
				"brunob@gmail.com", enc.encode("1234567"));
		
		Called calledEight = new Called(null, Priority.MEDIA, Status.ANDAMENTO,
				"Chamado 07", "Sétimo chamado", technicianEight, clientEight);
		
		
		Technician	technician1 = new Technician(null, "Ariel Douglas Gonçalves",
				"74032164827", "teste1@gmail.com", enc.encode("2103108"));
		technician1.addProfiles(Profile.TECNICO);
		
		Technician	technician2 = new Technician(null, "Bruno Gabriel de Borba",
				"57554388541", "teste2@gmail.com", enc.encode("2411570"));
		technician2.addProfiles(Profile.TECNICO);
		
		Technician	technician3 = new Technician(null, "Christian Schoeller",
				"44049044870", "teste3@gmail.com", enc.encode("2451111"));
		technician3.addProfiles(Profile.TECNICO);
		
		Client client1 = new Client(null, "Pedro Pereira dos Santos", "26044075311",
				"butr@gmail.com", enc.encode("1234567"));
		
		Client client2 = new Client(null, "Juvenal Lisboa", "35174278106",
				"malan@gmail.com", enc.encode("1234567"));
		
		Client client3 = new Client(null, "Joarez Sebastião da Cunha", "55815879304",
				"bisael@gmail.com", enc.encode("1234567"));
		
		Client client4 = new Client(null, "João Goulart", "81368399215",
				"jgjuvento@gmail.com", enc.encode("1234567"));
		
		Client client5 = new Client(null, "Pedro Rosa Guimarães", "60824815505",
				"pedro ros@gmail.com", enc.encode("1563986"));
		
		Client client6 = new Client(null, "Joãozinho da Lua", "29360622338",
				"jodalu@gmail.com", enc.encode("8965874"));
		
		Client client7 = new Client(null, "Pedro Pirapora Gomes", "15331869793",
				"pedrinhopira@gmail.com", enc.encode("45874569"));
		
		Client client8 = new Client(null, "Caio Lacerda Júnior", "55334389555",
				"caio_lacerda@gmail.com", enc.encode("12345678965896"));
		
		Client client9 = new Client(null, "Tin Berles Lee", "24286154599",
				"tim@gmail.com", enc.encode("1234567745896"));
		
		
		Called called1 = new Called(null, Priority.MEDIA, Status.ENCERRADO,
				"Conserto TV 42'", "Led queimado", technicianOne, client9);
		
		Called called2 = new Called(null, Priority.BAIXA, Status.ABERTO,
				"Conserto Nottbook Asus", "Bateria não carrega", technicianTwo, client8);
		
		Called called3 = new Called(null, Priority.ALTA, Status.ENCERRADO,
				"Conserto Celular Nókia", "Display quebrado", technicianOne, client7);
		
		Called called4 = new Called(null, Priority.ALTA, Status.ENCERRADO,
				"Conserto Bike aro 26'", "Pneu vazio", technicianThree, client6);
		
		Called called5 = new Called(null, Priority.MEDIA, Status.ABERTO,
				"Conserto Lavadoura Roupas", "Carambola quebrada", technicianFive, client5);
		
		Called called6 = new Called(null, Priority.ALTA, Status.ENCERRADO,
				"Conserto Video Game", "Compartimento do DVD avariado", technicianOne, clientFour);
		
		Called called7 = new Called(null, Priority.BAIXA, Status.ENCERRADO,
				"Conserto Monitor 17'", "Leds internos Soltos", technicianEight, client1);
		
		Called called8 = new Called(null, Priority.BAIXA, Status.ENCERRADO,
				"Conserto de Câmara de Ar", "Remendo", technician1, clientEight);
		
		
		
		Called called9 = new Called(null, Priority.ALTA, Status.ENCERRADO,
				"Conserto IPHONE 8", "Avaria no display", technician3, client7);
		
		Called called10 = new Called(null, Priority.BAIXA, Status.ABERTO,
				"Conserto Notbook Acer", "Touchpad estragado", technicianFour, client1);
		
		Called called11 = new Called(null, Priority.ALTA, Status.ENCERRADO,
				"Conserto máquina roçar grama", "Hélice quebrada", technicianFive, client2);
		
		Called called12 = new Called(null, Priority.ALTA, Status.ENCERRADO,
				"Conserto Bike aro 13 monark", "Traca câmbio 21 marchas", technicianThree, client6);
		
		Called called13 = new Called(null, Priority.MEDIA, Status.ABERTO,
				"Conserto Lavadoura Roupas", "Bomba de esvaziamento queimada", technicianFive, client7);
		
		Called called14 = new Called(null, Priority.MEDIA, Status.ENCERRADO,
				"Conserto violão", "Cordas arrebentadas", technicianOne, clientFive);
		
		Called called15 = new Called(null, Priority.BAIXA, Status.ENCERRADO,
				"Conserto câmara de ar motocicleta", "Remendo", technicianEight, client7);
		
		Called called16 = new Called(null, Priority.BAIXA, Status.ENCERRADO,
				"Conserto de Câmara de Ar automotiva", "Remendo", technician3, clientEight);
		
		
		
		Called called17 = new Called(null, Priority.ALTA, Status.ENCERRADO,
				"Conserto bola futsal", "Remendo", technician1, client7);
		
		Called called18 = new Called(null, Priority.ALTA, Status.ABERTO,
				"Conserto MacBook Pro 13", "Bateria não carrega", technician3, client1);
		
		Called called19 = new Called(null, Priority.ALTA, Status.ENCERRADO,
				"Conserto pistão", "Limpeza do mesmo", technicianOne, client7);
		
		Called called20 = new Called(null, Priority.ALTA, Status.ENCERRADO,
				"Conserto mesa 6 cadeiras", "Pintura envelhecida", technicianThree, client7);
		
		Called called21 = new Called(null, Priority.ALTA, Status.ABERTO,
				"Conserto Lavadoura Roupas Cônsul", "Carambola quebrada, bomba de esgotamento queimada", technicianFive, client5);
		
		Called called22 = new Called(null, Priority.ALTA, Status.ENCERRADO,
				"Conserto Video Game Nintendo Wii", "Compartimento do DVD avariado", technician1, clientFour);
		
		Called called23 = new Called(null, Priority.ALTA, Status.ENCERRADO,
				"Conserto Monitor 14", "Leds internos Soltos", technicianSix, clientOne);
		
		Called called24 = new Called(null, Priority.ALTA, Status.ENCERRADO,
				"Conserto de Jaqueta Couro Motociclista", "Pintura terá de ser refeita", technicianOne, clientEight);
		
				
		technicianRepository.saveAll(Arrays.asList(technicianOne, technicianTwo, technicianThree, 
				technicianFour, technicianFive, technicianSix, technicianSeven, technicianEight, 
				technician1, technician2, technician3));
		clientRepository.saveAll(Arrays.asList(clientOne, clientTwo, clientThree, 
				clientFour, clientFive, clientSix, clientSeven, clientEight, client1, 
				client2, client3, client4, client5, client6, client7, client8, client9));
		calledRepository.saveAll(Arrays.asList(calledOne, calledTwo, 
				calledFour, calledFive, calledSix, calledSeven, calledEight, called8
				, called7, called6, called5, called4, called3, called2, called1 
				, called9, called10, called11, called12, called13, called14, called15
				, called17, called16, called5, called18, called19, called20, called21
				, called22, called23, called24));
	}
}
