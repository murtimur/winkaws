package com.erp.winkaws.mydb.role.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.data.domain.Page;

import com.erp.winkaws.mydb.role.Role;
import com.erp.winkaws.mydb.role.dto.RoleCreateDTO;
import com.erp.winkaws.mydb.role.dto.RoleDTO;
import com.erp.winkaws.mydb.role.dto.RoleUpdateDTO;

@Mapper(componentModel = "spring")
public interface RoleMapper {

	RoleDTO toDTO(Role role);
	
	Role toEntity(RoleCreateDTO role);
	
	void update(RoleUpdateDTO role, @MappingTarget Role entity);
	
	default Page<RoleDTO> toDTOpage(Page<Role> page) {
		return page.map(this::toDTO);
	}
	
}
