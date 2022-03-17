package com.alexandre.helpdesk.testconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.alexandre.helpdesk.services.DBServices;

@Configuration
@Profile("test")
public class TestConfig {
	
	@Autowired
	private DBServices dbService;
	
	@Bean
	public void instantiateDB() {
		this.dbService.instantiateDb();
	}
}
