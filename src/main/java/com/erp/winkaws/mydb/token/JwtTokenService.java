package com.erp.winkaws.mydb.token;

import javax.crypto.SecretKey;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

import com.erp.winkaws.mydb.auth.dto.Credentials;
import com.erp.winkaws.mydb.user.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;

@Service
@ConditionalOnProperty(name = "winka.token-type", havingValue = "jwt")
public class JwtTokenService implements TokenService{
	
	SecretKey key = Keys.hmacShaKeyFor("secret-meganet-winka-mobiletoken".getBytes());

	ObjectMapper mapper = new ObjectMapper();
	
	public static record TokenSubject(int id) {}

	@Override
	public Token createToken(User user, Credentials creds) {
	    TokenSubject tokenSubject = new TokenSubject(user.getId());
	    try {
	        String subject = mapper.writeValueAsString(tokenSubject);
	        String token = Jwts.builder().subject(subject).signWith(key).compact();
	        return new Token("Bearer", token);
	    } catch (JsonProcessingException e) {
	        e.printStackTrace();
	    }
	    return null;
	}

	@Override
	public User verifyToken(String authorizationHeader) {
		if (authorizationHeader == null)
			return null;
		var token = authorizationHeader.split(" ")[1];
		JwtParser parser = Jwts.parser().verifyWith(key).build();
		try {
			Jws<Claims> claims = parser.parseSignedClaims(token);
			var subject = claims.getPayload().getSubject();
			var tokenSubject = mapper.readValue(subject, TokenSubject.class);
			User user = new User();
			user.setId(tokenSubject.id());
			return user;
		} catch (JwtException | JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
	}


	@Override
	public void logout(String authorizationHeader) {
		// TODO Auto-generated method stub
		
	}

}
