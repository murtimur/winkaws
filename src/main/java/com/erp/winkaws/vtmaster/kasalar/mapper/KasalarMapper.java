package com.erp.winkaws.vtmaster.kasalar.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

import com.erp.winkaws.vtmaster.kasalar.Kasalar;
import com.erp.winkaws.vtmaster.kasalar.dto.KasalarCreateDTO;
import com.erp.winkaws.vtmaster.kasalar.dto.KasalarDTO;
import com.erp.winkaws.vtmaster.kasalar.dto.KasalarUpdateDTO;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface KasalarMapper {
	
	KasalarDTO toDTO(Kasalar kasalar);
	
	Kasalar toEntity(KasalarCreateDTO dto);
	
	void update(KasalarUpdateDTO dto, @MappingTarget Kasalar entity);

}
