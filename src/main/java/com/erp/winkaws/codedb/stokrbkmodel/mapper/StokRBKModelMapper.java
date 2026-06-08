package com.erp.winkaws.codedb.stokrbkmodel.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.data.domain.Page;

import com.erp.winkaws.codedb.stokrbkmodel.StokRBKModel;
import com.erp.winkaws.codedb.stokrbkmodel.dto.StokRBKModelCreateDTO;
import com.erp.winkaws.codedb.stokrbkmodel.dto.StokRBKModelDTO;
import com.erp.winkaws.codedb.stokrbkmodel.dto.StokRBKModelUpdateDTO;

@Mapper(componentModel = "spring")
public interface StokRBKModelMapper {
	
	StokRBKModelDTO toDTO(StokRBKModel entity);
	
	StokRBKModel toEntity(StokRBKModelCreateDTO dto);
	
	void update(StokRBKModelUpdateDTO dto, @MappingTarget StokRBKModel entity);
	
	default Page<StokRBKModelDTO> toDTOPage(Page<StokRBKModel> page) {
		return page.map(this::toDTO);
	}
	
	default List<StokRBKModelDTO> toDTOList(List<StokRBKModel> list) {
		return list.stream().map(this::toDTO).toList();
	}

}
