package com.erp.winkaws.codedb.stoklar;

import java.util.List;

import org.springframework.stereotype.Service;

import com.erp.winkaws.codedb.stoklar.dto.StoklarDTO;
import com.erp.winkaws.codedb.stoklar.mapper.StoklarMapper;

@Service
public class StoklarService {
	
	private final StoklarRepository stoklarRepository;
	
	private final StoklarMapper mapper;

	public StoklarService(StoklarRepository stoklarRepository, StoklarMapper mapper) {
		super();
		this.stoklarRepository = stoklarRepository;
		this.mapper = mapper;
	}
	
	public StoklarDTO getStokDto(String stokKodu) {
		return mapper.toDTO(stoklarRepository.findByStokKodu(stokKodu));
	}
	
	public List<StoklarDTO> getStoklar(String stokKodu) {
		return mapper.toDTOList(stoklarRepository.findByStokKoduContaining(stokKodu));
	}

}
