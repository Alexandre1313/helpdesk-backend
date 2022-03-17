package com.alexandre.helpdesk.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.alexandre.helpdesk.domain.enums.Profile;

@Entity
public class Client extends Person {
		
	private static final long serialVersionUID = 1L;
	
	@OneToMany(mappedBy = "client")
	private List<Called> calls = new ArrayList<>();

	public Client() {
		super();
		addProfiles(Profile.CLIENTE);
	}

	public Client(Integer id, String name, String itin, String email, String password) {
		super(id, name, itin, email, password);
		addProfiles(Profile.CLIENTE);
	}

	public List<Called> getCalls() {
		return calls;
	}

	public void setCalls(List<Called> calls) {
		this.calls = calls;
	}
	
}
