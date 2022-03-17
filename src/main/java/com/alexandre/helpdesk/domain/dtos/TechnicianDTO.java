package com.alexandre.helpdesk.domain.dtos;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import com.alexandre.helpdesk.domain.Technician;
import com.alexandre.helpdesk.domain.enums.Profile;
import com.fasterxml.jackson.annotation.JsonFormat;

public class TechnicianDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	protected Integer id;   //Identificador
	protected String name; // Nome
	protected String itin; // Cpf
	protected String email; // Email
	protected String password; // Senha
	protected Set<Integer> profiles = new HashSet<>(); // Set de perfis
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	protected LocalDate creationDate = LocalDate.now(); // Data

	public TechnicianDTO() {
		super();
	}

	public TechnicianDTO(Technician obj) {
		super();
		this.id = obj.getId();
		this.name = obj.getName();
		this.itin = obj.getItin();
		this.email = obj.getEmail();
		this.password = obj.getPassword();
		this.profiles = obj.getProfiles().stream().map(p -> p.getCode()).collect(Collectors.toSet());
		this.creationDate = obj.getCreationDate();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getItin() {
		return itin;
	}

	public void setItin(String itin) {
		this.itin = itin;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Profile> getProfiles() {
		return profiles.stream().map(p -> Profile.toEnum(p)).collect(Collectors.toSet());
	}

	public void addProfile(Profile profile) {
		this.profiles.add(profile.getCode());
	}

	public LocalDate getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDate creationDate) {
		this.creationDate = creationDate;
	}
	
}
