package com.erp.winkaws.mydb.user.dto;

import java.util.HashSet;
import java.util.Set;

import com.erp.winkaws.mydb.authority.Permission;
import com.erp.winkaws.mydb.authority.dto.AuthorityCreateDTO;
import com.erp.winkaws.mydb.role.dto.RoleCreateDTO;
import com.erp.winkaws.mydb.user.validation.UniqueUsername;
import com.erp.winkaws.mydb.usersettings.dto.UserSettingsCreateDTO;

import jakarta.validation.constraints.NotBlank;

public record UserCreateDTO(Integer id, Boolean status, @NotBlank @UniqueUsername String username, @NotBlank String password,
		String image, Set<RoleCreateDTO> roles, UserSettingsCreateDTO settings, Set<AuthorityCreateDTO> authorities,
		Set<Permission> permissions) {

	public UserCreateDTO {
		if (roles == null) {
			roles = new HashSet<RoleCreateDTO>();
		}
		if (authorities == null) {
			authorities = new HashSet<AuthorityCreateDTO>();
		}
		if (permissions == null) {
			permissions = new HashSet<Permission>();
		}
	}

}
