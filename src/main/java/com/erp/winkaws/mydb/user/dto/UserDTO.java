package com.erp.winkaws.mydb.user.dto;

import java.util.HashSet;
import java.util.Set;

import com.erp.winkaws.mydb.authority.Permission;
import com.erp.winkaws.mydb.authority.dto.AuthorityDTO;
import com.erp.winkaws.mydb.role.dto.RoleDTO;
import com.erp.winkaws.mydb.usersettings.dto.UserSettingsDTO;

public record UserDTO(Integer id, Boolean status, String username, String image, Set<RoleDTO> roles,
		UserSettingsDTO settings, Set<AuthorityDTO> authorities, Set<Permission> permissions) {

	public UserDTO {
		if (roles == null) {
			roles = new HashSet<RoleDTO>();
		}
		if (authorities == null) {
			authorities = new HashSet<AuthorityDTO>();
		}
		if (permissions == null) {
			permissions = new HashSet<Permission>();
		}
	}

}
