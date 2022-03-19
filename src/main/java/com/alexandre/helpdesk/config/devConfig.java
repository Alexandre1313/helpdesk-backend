package com.alexandre.helpdesk.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.alexandre.helpdesk.services.DBServices;

@Configuration
@Profile("dev")
public class devConfig {
	
	@Autowired
	private DBServices dbService;
	
	@Value("${spring.jpa.hibernate.ddl-auto}")
	private String value;
	
	@Bean
	public boolean instantiateDB() {
		if(value.equals("create")){
			this.dbService.instantiateDb();
		}
		return false;
	}
}
