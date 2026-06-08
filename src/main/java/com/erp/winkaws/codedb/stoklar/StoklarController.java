package com.erp.winkaws.codedb.stoklar;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.erp.winkaws.codedb.stoklar.dto.StoklarDTO;

@RequestMapping("/api/1.0.1/stoklar")
@RestController
public class StoklarController {
	
	private final StoklarService stoklarService;

	public StoklarController(StoklarService stoklarService) {
		super();
		this.stoklarService = stoklarService;
	}
	
	@PostMapping("/stok")
	public StoklarDTO getStokDTO(@RequestParam String stokKodu) {
		return stoklarService.getStokDto(stokKodu);
	}
	
	@PostMapping("/stoklar")
	public List<StoklarDTO> getStoklarDTOs(@RequestParam String stokKodu) {
		return stoklarService.getStoklar(stokKodu);
	}

}
