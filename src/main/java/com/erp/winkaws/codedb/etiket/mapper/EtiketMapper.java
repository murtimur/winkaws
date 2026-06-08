package com.erp.winkaws.codedb.etiket.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import com.erp.winkaws.codedb.etiket.Etiket;
import com.erp.winkaws.codedb.etiket.dto.EtiketCreateDTO;
import com.erp.winkaws.codedb.etiket.dto.EtiketDTO;
import com.erp.winkaws.codedb.etiket.dto.EtiketUpdateDTO;

@Mapper(componentModel = "spring")
public interface EtiketMapper {
	
	EtiketDTO toDTO(Etiket entity);
	
	Etiket toEntity(EtiketCreateDTO dto);
	
	void update(EtiketUpdateDTO dto, @MappingTarget Etiket entity);
	
	default List<EtiketDTO> toDTOList(List<Etiket> list) {
		return list.stream().map(this::toDTO).toList();
	}

}
