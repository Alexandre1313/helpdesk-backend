package com.alexandre.helpdesk.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.alexandre.helpdesk.domain.Person;
import com.alexandre.helpdesk.domain.Technician;
import com.alexandre.helpdesk.domain.dtos.TechnicianDTO;
import com.alexandre.helpdesk.repositories.PersonRepository;
import com.alexandre.helpdesk.repositories.TechnicianRepository;
import com.alexandre.helpdesk.services.exceptions.DataIntegrityViolationException;
import com.alexandre.helpdesk.services.exceptions.ObjectNotFoundException;

@Service
public class TechnicianService {

	@Autowired
	private BCryptPasswordEncoder enc;
	@Autowired
	private TechnicianRepository repository;
	@Autowired
	private PersonRepository  personRepository;
	
	public Technician fyndById(Integer id) {
		Optional<Technician> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto de id '" + id + "' não encontrado"));
	}

	public List<Technician> findAll() {
		return repository.findAll();
	}

	public Technician create(TechnicianDTO objDTO) {
		objDTO.setId(null);
		objDTO.setPassword(enc.encode(objDTO.getPassword()));
		validByItinAndEmail(objDTO);
		itinNumberIsValid(objDTO);
		Technician newObj = new Technician(objDTO);
		return repository.save(newObj);
	}
	
	public Technician update(Integer id, @Valid TechnicianDTO objDTO) {
		objDTO.setId(id);
		Technician oldObj = fyndById(id);
		if(!objDTO.getPassword().equals(oldObj.getPassword())) {
			objDTO.setPassword(enc.encode(objDTO.getPassword()));
		}
		validByItinAndEmail(objDTO);
		itinNumberIsValid(objDTO);
		oldObj = new Technician(objDTO);
		return repository.save(oldObj);
	}
	
	private void itinNumberIsValid(TechnicianDTO objDTO) {
		// TODO Auto-generated method stub
	}

	public void delete(Integer id) {
		Technician obj = fyndById(id);
		if(obj.getCalls().size() > 0) {
			throw new DataIntegrityViolationException("Técnico possui ordens de serviço"
					+ " e não pode ser deletado");
		}
		repository.deleteById(id);		
	}

	private void validByItinAndEmail(TechnicianDTO objDTO) {
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
