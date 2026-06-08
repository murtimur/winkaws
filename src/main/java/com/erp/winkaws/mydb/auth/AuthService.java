package com.erp.winkaws.mydb.auth;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.erp.winkaws.mydb.auth.dto.AuthResponse;
import com.erp.winkaws.mydb.auth.dto.Credentials;
import com.erp.winkaws.mydb.auth.exception.AuthenticationException;
import com.erp.winkaws.mydb.token.Token;
import com.erp.winkaws.mydb.token.TokenService;
import com.erp.winkaws.mydb.user.User;
import com.erp.winkaws.mydb.user.UserService;
import com.erp.winkaws.mydb.user.dto.UserDTO;
import com.erp.winkaws.mydb.user.mapper.UserMapper;

@Service
public class AuthService {

	private final UserService userService;

	private final PasswordEncoder passwordEncoder;

	private final TokenService tokenService;

	private final UserMapper userMapper;

	public AuthService(UserService userService, PasswordEncoder passwordEncoder, TokenService tokenService,
			UserMapper userMapper) {
		super();
		this.userService = userService;
		this.passwordEncoder = passwordEncoder;
		this.tokenService = tokenService;
		this.userMapper = userMapper;
	}

	@Transactional
	public AuthResponse authenticate(Credentials creds) {
		User inDB = userService.getUser(creds.username());
		if (inDB == null) throw new AuthenticationException();
		if (!passwordEncoder.matches(creds.password(), inDB.getPassword())) throw new AuthenticationException();
		Token token = tokenService.createToken(inDB, creds);
		UserDTO user = userMapper.toDTO(inDB);
		AuthResponse response = new AuthResponse();
		response.setToken(token);
		response.setUser(user);
		return response;
	}

	public void logout(String authorizationHeader) {
		tokenService.logout(authorizationHeader);
	}

}

