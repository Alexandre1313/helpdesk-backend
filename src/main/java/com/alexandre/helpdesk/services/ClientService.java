package com.alexandre.helpdesk.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.alexandre.helpdesk.domain.Person;
import com.alexandre.helpdesk.domain.Client;
import com.alexandre.helpdesk.domain.dtos.ClientDTO;
import com.alexandre.helpdesk.repositories.PersonRepository;
import com.alexandre.helpdesk.repositories.ClientRepository;
import com.alexandre.helpdesk.services.exceptions.DataIntegrityViolationException;
import com.alexandre.helpdesk.services.exceptions.ObjectNotFoundException;

@Service
public class ClientService {

	@Autowired
	private BCryptPasswordEncoder enc;
	@Autowired
	private ClientRepository repository;
	@Autowired
	private PersonRepository  personRepository;
	
	public Client fyndById(Integer id) {
		Optional<Client> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto de id '" + id + "' não encontrado"));
	}

	public List<Client> findAll() {
		return repository.findAll();
	}

	public Client create(ClientDTO objDTO) {
		objDTO.setId(null);
		objDTO.setPassword(enc.encode(objDTO.getPassword()));
		validByItinAndEmail(objDTO); 
		Client newObj = new Client(objDTO);
		return repository.save(newObj);
	}
	
	public Client update(Integer id, @Valid ClientDTO objDTO) {
		objDTO.setId(id);
		Client oldObj = fyndById(id);
		if(!objDTO.getPassword().equals(oldObj.getPassword())) {
			objDTO.setPassword(enc.encode(objDTO.getPassword()));
		}
		validByItinAndEmail(objDTO);
		oldObj = new Client(objDTO);
		return repository.save(oldObj);
	}
	
	public void delete(Integer id) {
		Client obj = fyndById(id);
		if(obj.getCalls().size() > 0) {
			throw new DataIntegrityViolationException("Cliente possui ordens de serviço"
					+ " e não pode ser deletado");
		}
		repository.deleteById(id);		
	}

	private void validByItinAndEmail(ClientDTO objDTO) {
		Optional<Person> obj = personRepository.findByItin(objDTO.getItin());
		if(obj.isPresent() && obj.get().getId() != objDTO.getId()) {
			throw new DataIntegrityViolationException("CPF já cadastrado no sistema");
		}
		obj = personRepository.findByEmail(objDTO.getEmail());
		if(obj.isPresent() && obj.get().getId() != objDTO.getId()) {
			throw new DataIntegrityViolationException("E-mail já cadastrado no sistema");
		}
	}

}
