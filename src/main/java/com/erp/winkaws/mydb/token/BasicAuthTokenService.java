package com.erp.winkaws.mydb.token;

import java.util.Base64;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.erp.winkaws.mydb.auth.dto.Credentials;
import com.erp.winkaws.mydb.user.User;
import com.erp.winkaws.mydb.user.UserService;

@Service
@ConditionalOnProperty(name = "winka.token-type", havingValue = "basic")
public class BasicAuthTokenService implements TokenService{
	
	private final UserService userService;
	
	private final PasswordEncoder passwordEncoder;

	public BasicAuthTokenService(UserService userService, PasswordEncoder passwordEncoder) {
		super();
		this.userService = userService;
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	public Token createToken(User user, Credentials creds) {
		String usernameColonPassword = creds.username() + ":" + creds.password();
		String token = Base64.getEncoder().encodeToString(usernameColonPassword.getBytes());
		return new Token("Basic", token);
	}

	@Override
	public User verifyToken(String authorizationHeader) {
		if(authorizationHeader == null) return null;
		var base64Encoded = authorizationHeader.split("Basic ")[1];
		var decoded = new String(Base64.getDecoder().decode(base64Encoded));
		var credentials = decoded.split(":");
		var username = credentials[0];
		var password = credentials[1];
		User inDB = userService.getUser(username);
		if(inDB == null) return null;
		if(!passwordEncoder.matches(password, inDB.getPassword())) return null;
		return inDB;
	}

	@Override
	public void logout(String authorizationHeader) {
		
	}

}
