package com.alexandre.helpdesk.domain;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import com.alexandre.helpdesk.domain.enums.Profile;

public abstract class Person {
	
	protected Integer id;   //Identificador
	protected String name; // Nome
	protected String itin; // Cpf
	protected String email; // Email
	protected String password; // Senha
	protected Set<Integer> profiles = new HashSet<>(); // Set de perfis
	protected LocalDate creationDate = LocalDate.now(); // Data
	
	public Person() {
		super();
		addProfiles(Profile.CLIENTE);
	}

	public Person(Integer id, String name, String itin, String email, String password) {
		super();
		this.id = id;
		this.name = name;
		this.itin = itin;
		this.email = email;
		this.password = password;
		addProfiles(Profile.CLIENTE);
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

	public void addProfiles(Profile profile) {
		this.profiles.add(profile.getCode());
	}

	public LocalDate getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDate creationDate) {
		this.creationDate = creationDate;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, itin);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		return Objects.equals(id, other.id) && Objects.equals(itin, other.itin);
	}
	
}
