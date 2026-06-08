package com.erp.winkaws.printer;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping({"/api/1.0.1/yazicilar"})
@RestController
public class PrinterController {
	
	private final PrinterService printerService;
	
	@GetMapping
	public ResponseEntity<List<Printer>> findAll() {
		return ResponseEntity.status(200).body(printerService.findAll());
	}

}
