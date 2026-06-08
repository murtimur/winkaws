package com.erp.winkaws.vtmaster.renkler.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import com.erp.winkaws.vtmaster.renkler.Renkler;
import com.erp.winkaws.vtmaster.renkler.dto.RenklerCreateDTO;
import com.erp.winkaws.vtmaster.renkler.dto.RenklerDTO;
import com.erp.winkaws.vtmaster.renkler.dto.RenklerUpdateDTO;

@Mapper(componentModel = "spring")
public interface RenklerMapper {
	
	RenklerDTO toDTO(Renkler entity);
	
	Renkler toEntity(RenklerCreateDTO dto);
	
	void update(RenklerUpdateDTO dto, @MappingTarget Renkler entity);
	
	default List<RenklerDTO> toDTOList(List<Renkler> list) {
		return list.stream().map(this::toDTO).toList();
	}

}
