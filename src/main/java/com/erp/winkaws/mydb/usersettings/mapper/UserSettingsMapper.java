package com.erp.winkaws.mydb.usersettings.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;
import org.springframework.data.domain.Page;

import com.erp.winkaws.mydb.usersettings.UserSettings;
import com.erp.winkaws.mydb.usersettings.dto.UserSettingsCreateDTO;
import com.erp.winkaws.mydb.usersettings.dto.UserSettingsDTO;
import com.erp.winkaws.mydb.usersettings.dto.UserSettingsUpdateDTO;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserSettingsMapper {
	
	UserSettingsDTO toDTO(UserSettings entity);
	
	UserSettings toEntity(UserSettingsCreateDTO dto);
	
	void update(UserSettingsUpdateDTO dto, @MappingTarget UserSettings entity);
	
	default Page<UserSettingsDTO> toDTOPage(Page<UserSettings> page){
		return page.map(this::toDTO);
	}

}
