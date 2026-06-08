package com.erp.winkaws.codedb.stokrbk.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.data.domain.Page;

import com.erp.winkaws.codedb.stokrbk.StokRBK;
import com.erp.winkaws.codedb.stokrbk.dto.StokRBKCreateDTO;
import com.erp.winkaws.codedb.stokrbk.dto.StokRBKDTO;
import com.erp.winkaws.codedb.stokrbk.dto.StokRBKUpdateDTO;

@Mapper(componentModel = "spring")
public interface StokRBKMapper {
	
	StokRBKDTO toDTO(StokRBK entity);
	
	StokRBK toEntity(StokRBKCreateDTO dto);
	
	void update(StokRBKUpdateDTO dto, @MappingTarget StokRBK entity);
	
	default Page<StokRBKDTO> toDTOPage(Page<StokRBK> page) {
		return page.map(this::toDTO);
	}
	
	default List<StokRBKDTO> toDTOList(List<StokRBK> list) {
		return list.stream().map(this::toDTO).toList();
	}

}
