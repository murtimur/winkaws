package com.erp.winkaws.mydb.user.dto;

import java.util.HashSet;
import java.util.Set;

import com.erp.winkaws.mydb.authority.Permission;
import com.erp.winkaws.mydb.authority.dto.AuthorityUpdateDTO;
import com.erp.winkaws.mydb.role.dto.RoleUpdateDTO;
import com.erp.winkaws.mydb.usersettings.dto.UserSettingsUpdateDTO;

import jakarta.validation.constraints.NotBlank;

public record UserUpdateDTO(Integer id, Boolean status, @NotBlank String username, String password,
		String image, Set<RoleUpdateDTO> roles, UserSettingsUpdateDTO settings, Set<AuthorityUpdateDTO> authorities,
		Set<Permission> permissions) {

	public UserUpdateDTO {
		if (roles == null) {
			roles = new HashSet<RoleUpdateDTO>();
		}
		if (authorities == null) {
			authorities = new HashSet<AuthorityUpdateDTO>();
		}
		if (permissions == null) {
			permissions = new HashSet<Permission>();
		}
	}

}
