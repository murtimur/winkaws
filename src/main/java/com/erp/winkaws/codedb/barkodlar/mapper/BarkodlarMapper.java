package com.erp.winkaws.codedb.barkodlar.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.data.domain.Page;

import com.erp.winkaws.codedb.barkodlar.Barkodlar;
import com.erp.winkaws.codedb.barkodlar.dto.BarkodlarCreateDTO;
import com.erp.winkaws.codedb.barkodlar.dto.BarkodlarDTO;
import com.erp.winkaws.codedb.barkodlar.dto.BarkodlarUpdateDTO;

@Mapper(componentModel = "spring")
public interface BarkodlarMapper {
	
	BarkodlarDTO toDTO(Barkodlar entity);
	
	Barkodlar toEntity(BarkodlarCreateDTO dto);
	
	void update(BarkodlarUpdateDTO dto, @MappingTarget Barkodlar entity);
	
	default Page<BarkodlarDTO> toDTOPage(Page<Barkodlar> page) {
		return page.map(this::toDTO);
	}
	
	default List<BarkodlarDTO> toDTOList(List<Barkodlar> list) {
		return list.stream().map(this::toDTO).toList();
	}

}
