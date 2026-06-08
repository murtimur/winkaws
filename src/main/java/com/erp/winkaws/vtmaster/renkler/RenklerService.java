package com.erp.winkaws.vtmaster.renkler;

import java.util.List;

import org.springframework.stereotype.Service;

import com.erp.winkaws.vtmaster.renkler.dto.RenklerCreateDTO;
import com.erp.winkaws.vtmaster.renkler.dto.RenklerDTO;
import com.erp.winkaws.vtmaster.renkler.dto.RenklerUpdateDTO;
import com.erp.winkaws.vtmaster.renkler.mapper.RenklerMapper;

@Service
public class RenklerService {

	private final RenklerRepository renklerRepository;
	
	private final RenklerMapper renklerMapper;

	public RenklerService(RenklerRepository renklerRepository, RenklerMapper renklerMapper) {
		super();
		this.renklerRepository = renklerRepository;
		this.renklerMapper = renklerMapper;
	}
	
	public void save(RenklerCreateDTO dto) {
		if(dto == null) return;
		renklerRepository.save(renklerMapper.toEntity(dto));
	}
	
	public void renklerUpdate(RenklerUpdateDTO dto) {
		if(dto == null) return;
		Renkler renkler = renklerRepository.findById(dto.getId()).orElseThrow(()-> new RuntimeException("Renk bulunamadı" + dto.getId()));
		renklerMapper.update(dto, renkler);
		renklerRepository.save(renkler);
	}
	
	public List<RenklerDTO> getAllRenkler() {
		return renklerMapper.toDTOList(renklerRepository.findAll());
	}
	
}
