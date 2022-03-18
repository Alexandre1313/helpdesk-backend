package com.alexandre.helpdesk.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alexandre.helpdesk.domain.Called;
import com.alexandre.helpdesk.domain.dtos.CalledDTO;
import com.alexandre.helpdesk.services.CalledService;

@RestController
@RequestMapping(value = "/chamados")
public class CalledResources {
	
	@Autowired
	private CalledService service; 
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<CalledDTO> findById(@PathVariable Integer id) {
		Called obj = service.fyndById(id);
		return ResponseEntity.ok().body(new CalledDTO(obj));
	} 
	
	
}
