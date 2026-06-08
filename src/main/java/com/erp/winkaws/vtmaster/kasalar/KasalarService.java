package com.erp.winkaws.vtmaster.kasalar;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.erp.winkaws.vtmaster.kasalar.dto.KasalarDTO;
import com.erp.winkaws.vtmaster.kasalar.mapper.KasalarMapper;

@Service
public class KasalarService {

	private final KasalarRepository kasalarRepository;
	
	private final KasalarMapper kasalarMapper;

	public KasalarService(KasalarRepository kasalarRepository, KasalarMapper kasalarMapper) {
		super();
		this.kasalarRepository = kasalarRepository;
		this.kasalarMapper = kasalarMapper;
	}
	
	public List<KasalarDTO> findAllKasalar() {
		return kasalarRepository.findByDurum((byte)0).stream().map(kasalarMapper::toDTO).collect(Collectors.toList());
	}
	
	//Eski JAVA surumlerinde 
	//public List<KasalarDTO> findAllKasalar() {
	//	return kasalarRepository.findByDurum((byte)0).stream().map(kasalarMapper::toDTO).toList();
	//}
	
}
