package com.erp.winkaws.mydb.auth;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.erp.winkaws.mydb.auth.dto.AuthResponse;
import com.erp.winkaws.mydb.auth.dto.Credentials;
import com.erp.winkaws.shared.GenericMessage;

@RequestMapping("/api/1.0.1")
@RestController
public class AuthController {

	private final AuthService authService;

	public AuthController(AuthService authService) {
		super();
		this.authService = authService;
	}

	@PostMapping("/auth")
	public ResponseEntity<AuthResponse> auth(@RequestBody Credentials creds) {
		var authResponse = authService.authenticate(creds);
		var cookie = ResponseCookie.from("winka-desktop-user-token", authResponse.getToken().getToken()).path("/")
				.httpOnly(true).build();
		return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, cookie.toString()).body(authResponse);
	}

	@PostMapping("/logout")
	public ResponseEntity<GenericMessage> logout(@RequestHeader(name = "Authorization", required = false) String auth,
			@CookieValue(name = "winka-desktop-user-token", required = false) String cookie) {
		String token = auth;
		if (token == null && cookie != null) {
			token = "Bearer " + cookie;
		}
		authService.logout(token);
		var clearCookie = ResponseCookie.from("winka-desktop-user-token", "").path("/").maxAge(0).httpOnly(true)
				.build();
		return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, clearCookie.toString())
				.body(new GenericMessage("Logout success"));
	}

}
