package com.erp.winkaws.codedb.birimler.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.data.domain.Page;

import com.erp.winkaws.codedb.birimler.Birimler;
import com.erp.winkaws.codedb.birimler.dto.BirimlerCreateDTO;
import com.erp.winkaws.codedb.birimler.dto.BirimlerDTO;
import com.erp.winkaws.codedb.birimler.dto.BirimlerUpdateDTO;

@Mapper(componentModel = "spring")
public interface BirimlerMapper {
	
	BirimlerDTO toDTO(Birimler entity);
	
	Birimler toEntity(BirimlerCreateDTO dto);
	
	void update(BirimlerUpdateDTO dto, @MappingTarget Birimler entity);
	
	default Page<BirimlerDTO> toDTOPage(Page<Birimler> page) {
		return page.map(this::toDTO);
	}
	
	default List<BirimlerDTO> toDTOList(List<Birimler> list) {
		return list.stream().map(this::toDTO).toList();
	}

}
