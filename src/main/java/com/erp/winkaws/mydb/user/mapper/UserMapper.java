package com.erp.winkaws.mydb.user.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;
import org.springframework.data.domain.Page;

import com.erp.winkaws.mydb.authority.mapper.AuthorityMapper;
import com.erp.winkaws.mydb.role.mapper.RoleMapper;
import com.erp.winkaws.mydb.user.User;
import com.erp.winkaws.mydb.user.dto.UserCreateDTO;
import com.erp.winkaws.mydb.user.dto.UserDTO;
import com.erp.winkaws.mydb.user.dto.UserUpdateDTO;
import com.erp.winkaws.mydb.usersettings.mapper.UserSettingsMapper;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, uses = { UserSettingsMapper.class,
		RoleMapper.class, AuthorityMapper.class })
public interface UserMapper {

	UserDTO toDTO(User entity);

	User toEntity(UserCreateDTO dto);

	void update(UserUpdateDTO dto, @MappingTarget User entity);

	default Page<UserDTO> toDTOPage(Page<User> page) {
		return page.map(this::toDTO);
	}

}
