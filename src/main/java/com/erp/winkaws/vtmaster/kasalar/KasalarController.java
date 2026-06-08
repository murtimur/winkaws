package com.erp.winkaws.vtmaster.kasalar;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.erp.winkaws.vtmaster.kasalar.dto.KasalarDTO;

@RequestMapping("/api/1.0.1/kasalar")
@RestController
public class KasalarController {
	
	private final KasalarService kasalarService;

	public KasalarController(KasalarService kasalarService) {
		super();
		this.kasalarService = kasalarService;
	}
	
	@GetMapping
	public List<KasalarDTO> getAllKasalar() {
		return kasalarService.findAllKasalar();
	}

}
