package com.erp.winkaws.codedb.etiket;

import org.springframework.stereotype.Service;

import com.erp.winkaws.codedb.etiket.dto.EtiketCreateDTO;
import com.erp.winkaws.codedb.etiket.mapper.EtiketMapper;

@Service
public class EtiketService {
	
	private final EtiketRepository etiketRepository;
	
	private final EtiketMapper mapper;

	public EtiketService(EtiketRepository etiketRepository, EtiketMapper mapper) {
		super();
		this.etiketRepository = etiketRepository;
		this.mapper = mapper;
	}
	
	public void save(EtiketCreateDTO dto) {
		if(dto == null) return;
		etiketRepository.save(mapper.toEntity(dto));
	}

}
