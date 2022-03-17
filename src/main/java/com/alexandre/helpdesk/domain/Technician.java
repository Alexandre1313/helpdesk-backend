package com.alexandre.helpdesk.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.alexandre.helpdesk.domain.dtos.TechnicianDTO;
import com.alexandre.helpdesk.domain.enums.Profile;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Technician extends Person {
	
	private static final long serialVersionUID = 1L;
	
	@JsonIgnore
	@OneToMany(mappedBy = "technician")
	private List<Called> calls = new ArrayList<>();

	public Technician() {
		super();
		addProfiles(Profile.CLIENTE);
	}

	public Technician(Integer id, String name, String itin, String email, String password) {
		super(id, name, itin, email, password);
		addProfiles(Profile.CLIENTE);
	}
	
	public Technician(TechnicianDTO objDTO) {
		super();
		this.id = objDTO.getId();
		this.name = objDTO.getName();
		this.itin = objDTO.getItin();
		this.email = objDTO.getEmail();
		this.password = objDTO.getPassword();
		this.profiles = objDTO.getProfiles().stream().map(p -> p.getCode()).collect(Collectors.toSet());
		this.creationDate = objDTO.getCreationDate();
	}

	public List<Called> getCalls() {
		return calls;
	}

	public void setCalls(List<Called> calls) {
		this.calls = calls;
	}
	
}
