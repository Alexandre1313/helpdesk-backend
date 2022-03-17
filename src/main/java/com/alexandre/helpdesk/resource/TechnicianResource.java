package com.alexandre.helpdesk.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alexandre.helpdesk.domain.Technician;
import com.alexandre.helpdesk.services.TechnicianService;

@RestController
@RequestMapping(value = "/tecnicos")
public class TechnicianResource {
	
	@Autowired
	private TechnicianService service;
	
	@GetMapping(value = "/{id}" )
	public ResponseEntity<Technician> findById(@PathVariable Integer id) {
		Technician obj = service.fyndById(id);
		return ResponseEntity.ok().body(obj);
	}
	

}
