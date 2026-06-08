package com.erp.winkaws.mydb.authority.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;
import org.springframework.data.domain.Page;

import com.erp.winkaws.mydb.authority.Authority;
import com.erp.winkaws.mydb.authority.dto.AuthorityCreateDTO;
import com.erp.winkaws.mydb.authority.dto.AuthorityDTO;
import com.erp.winkaws.mydb.authority.dto.AuthorityUpdateDTO;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AuthorityMapper {

	AuthorityDTO toDTO(Authority entity);

	Authority toEntity(AuthorityCreateDTO dto);

	void update(AuthorityUpdateDTO dto, @MappingTarget Authority entity);

	default Page<AuthorityDTO> toDTOPage(Page<Authority> page) {
		return page.map(this::toDTO);
	}

}
