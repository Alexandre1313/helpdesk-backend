package com.alexandre.helpdesk.domain;

import java.util.ArrayList;
import java.util.List;

public class Client extends Person {
	
	private List<Called> calls = new ArrayList<>();

	public Client() {
		super();
	}

	public Client(Integer id, String name, String itin, String email, String password) {
		super(id, name, itin, email, password);
	}

	public List<Called> getCalls() {
		return calls;
	}

	public void setCalls(List<Called> calls) {
		this.calls = calls;
	}
	
}
