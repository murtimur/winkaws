package com.erp.winkaws.mydb.auth.dto;

import com.erp.winkaws.mydb.token.Token;
import com.erp.winkaws.mydb.user.dto.UserDTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthResponse {

	private UserDTO user;
	
	private Token token;
	
}
