package com.erp.winkaws.vtmaster.winkakullanicilari;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.erp.winkaws.vtmaster.winkakullanicilari.dto.KullanicilarDTO;

@RequestMapping({ "/api/1.0.1/kullanicilar" })
@RestController
public class KullanicilarController {
	
	private final KullanicilarService kullanicilarService;

	public KullanicilarController(KullanicilarService kullanicilarService) {
		super();
		this.kullanicilarService = kullanicilarService;
	}
	
	@GetMapping
	public List<KullanicilarDTO> findAllKullanicilar() {
		return kullanicilarService.findAllKullanicilar();
	}

}
