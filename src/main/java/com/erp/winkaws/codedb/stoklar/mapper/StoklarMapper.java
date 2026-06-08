package com.erp.winkaws.codedb.stoklar.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;
import org.springframework.data.domain.Page;

import com.erp.winkaws.codedb.birimler.mapper.BirimlerMapper;
import com.erp.winkaws.codedb.stoklar.Stoklar;
import com.erp.winkaws.codedb.stoklar.dto.StoklarCreateDTO;
import com.erp.winkaws.codedb.stoklar.dto.StoklarDTO;
import com.erp.winkaws.codedb.stoklar.dto.StoklarUpdate;
import com.erp.winkaws.codedb.stokrbk.mapper.StokRBKMapper;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, uses = { BirimlerMapper.class,
		StokRBKMapper.class })
public interface StoklarMapper {

	StoklarDTO toDTO(Stoklar stoklar);

	Stoklar toEntity(StoklarCreateDTO dto);

	void update(StoklarUpdate dto, @MappingTarget Stoklar entity);

	default Page<StoklarDTO> toDTOPage(Page<Stoklar> page) {
		return page.map(this::toDTO);
	}

	default List<StoklarDTO> toDTOList(List<Stoklar> list) {
		return list.stream().map(this::toDTO).toList();
	}

}
