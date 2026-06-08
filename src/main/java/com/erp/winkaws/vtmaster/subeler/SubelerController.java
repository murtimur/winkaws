package com.erp.winkaws.vtmaster.subeler;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.erp.winkaws.vtmaster.subeler.dto.SubelerDTO;

@RequestMapping("/api/1.0.1/subeler")
@RestController
public class SubelerController {

	private final SubelerService subelerService;

	public SubelerController(SubelerService subelerService) {
		super();
		this.subelerService = subelerService;
	}
	
	@GetMapping
	public List<SubelerDTO> getAllSubeler() {
		return subelerService.findAllSubeler();
	}
	
}
