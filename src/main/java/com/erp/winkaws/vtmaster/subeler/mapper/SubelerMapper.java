package com.erp.winkaws.vtmaster.subeler.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import com.erp.winkaws.vtmaster.subeler.Subeler;
import com.erp.winkaws.vtmaster.subeler.dto.SubelerCreateDTO;
import com.erp.winkaws.vtmaster.subeler.dto.SubelerDTO;
import com.erp.winkaws.vtmaster.subeler.dto.SubelerUpdateDTO;

@Mapper(componentModel = "spring")
public interface SubelerMapper {
	
	SubelerDTO toDTO(Subeler entity);
	
	Subeler toEntity(SubelerCreateDTO dto);
	
	void update(SubelerUpdateDTO dto, @MappingTarget Subeler entity);

}
