package com.alexandre.helpdesk.resource;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alexandre.helpdesk.domain.Technician;
import com.alexandre.helpdesk.domain.dtos.TechnicianDTO;
import com.alexandre.helpdesk.services.TechnicianService;

@RestController
@RequestMapping(value = "/tecnicos")
public class TechnicianResource {
	
	@Autowired
	private TechnicianService service;
	
	@GetMapping(value = "/{id}" )
	public ResponseEntity<TechnicianDTO> findById(@PathVariable Integer id) {
		Technician obj = service.fyndById(id);
		return ResponseEntity.ok().body(new TechnicianDTO(obj));
	}
	
	@GetMapping
	public ResponseEntity<List<TechnicianDTO>> findAll() {
		List<Technician> list = service.findAll();
		List<TechnicianDTO> listDTO = list.stream().map(t -> new TechnicianDTO(t)).
				collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
}
