package com.erp.winkaws.mydb.token;

import java.util.Optional;
import java.util.UUID;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

import com.erp.winkaws.mydb.auth.dto.Credentials;
import com.erp.winkaws.mydb.user.User;
import com.erp.winkaws.mydb.user.UserService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
@ConditionalOnProperty(name = "winka.token-type", havingValue = "opaque")
public class OpaqueToken implements TokenService {

	private final TokenRepository tokenRepository;
	private final UserService userService;

	@Override
	public Token createToken(User user, Credentials creds) {
		String value = UUID.randomUUID().toString();
		Token token = new Token();
		token.setUser(user);
		token.setToken(value);
		return tokenRepository.save(token);
	}

	@Override
	public User verifyToken(String authorizationHeader) {
		return getToken(authorizationHeader).map(token -> token.getUser().getId())
				.flatMap(userService::findByIdWithRoles).orElse(null);
	}

	@Override
	public void logout(String authorizationHeader) {
		getToken(authorizationHeader).ifPresent(tokenRepository::delete);
	}

	private Optional<Token> getToken(String authorizationHeader) {
		if (authorizationHeader == null || !authorizationHeader.startsWith("Bearer ")) {
			return Optional.empty();
		}
		String[] parts = authorizationHeader.split(" ");
		if (parts.length < 2) {
			return Optional.empty();
		}
		return tokenRepository.findById(parts[1]);
	}
	
}
