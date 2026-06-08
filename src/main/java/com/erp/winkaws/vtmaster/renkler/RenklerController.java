package com.erp.winkaws.vtmaster.renkler;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.erp.winkaws.shared.GenericMessage;
import com.erp.winkaws.vtmaster.renkler.dto.RenklerCreateDTO;
import com.erp.winkaws.vtmaster.renkler.dto.RenklerDTO;
import com.erp.winkaws.vtmaster.renkler.dto.RenklerUpdateDTO;

@RequestMapping("/api/1.0.1/renkler")
@RestController
public class RenklerController {
	
	private final RenklerService renklerService;

	public RenklerController(RenklerService renklerService) {
		super();
		this.renklerService = renklerService;
	}
	
	@PostMapping
	public ResponseEntity<GenericMessage> save(@RequestBody RenklerCreateDTO dto) {
		renklerService.save(dto);
		return ResponseEntity.status(201).body(new GenericMessage("User created!"));
	}
	
	@PutMapping
	public ResponseEntity<GenericMessage> renklerUpdate(@RequestBody RenklerUpdateDTO dto) {
		renklerService.renklerUpdate(dto);
		return ResponseEntity.status(200).body(new GenericMessage("User updated!"));
	}
	
	@GetMapping
	public ResponseEntity<List<RenklerDTO>> getAllRenkler() {
		return ResponseEntity.status(200).body(renklerService.getAllRenkler());
	}

}
