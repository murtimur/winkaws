package com.erp.winkaws.vtmaster.subeler;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.erp.winkaws.vtmaster.subeler.dto.SubelerDTO;
import com.erp.winkaws.vtmaster.subeler.mapper.SubelerMapper;

@Service
public class SubelerService {

	private final SubelerRepository subelerRepository;
	
	private final SubelerMapper mapper;

	public SubelerService(SubelerRepository subelerRepository, SubelerMapper mapper) {
		super();
		this.subelerRepository = subelerRepository;
		this.mapper = mapper;
	}
	
	public List<SubelerDTO> findAllSubeler() {
		return subelerRepository.findByDurum((byte)0).stream().map(mapper::toDTO).collect(Collectors.toList());
	}
	
}
