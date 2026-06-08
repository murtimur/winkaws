package com.erp.winkaws.vtmaster.winkakullanicilari;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.erp.winkaws.vtmaster.winkakullanicilari.dto.KullanicilarDTO;
import com.erp.winkaws.vtmaster.winkakullanicilari.mapper.KullanicilarMapper;

@Service
public class KullanicilarService {

	private final KullanicilarRepository kullanicilarRepository;

	private final KullanicilarMapper mapper;

	public KullanicilarService(KullanicilarRepository kullanicilarRepository, KullanicilarMapper mapper) {
		super();
		this.kullanicilarRepository = kullanicilarRepository;
		this.mapper = mapper;
	}
	
	public List<KullanicilarDTO> findAllKullanicilar() {
		return kullanicilarRepository.findByDurum((byte)0).stream().map(mapper::toDTO).collect(Collectors.toList());
	}
}
