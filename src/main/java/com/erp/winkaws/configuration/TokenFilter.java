package com.erp.winkaws.configuration;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.servlet.HandlerExceptionResolver;

import com.erp.winkaws.mydb.token.TokenService;
import com.erp.winkaws.mydb.user.User;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class TokenFilter extends OncePerRequestFilter {

	private final TokenService tokenService;
	private final HandlerExceptionResolver exceptionResolver;

	public TokenFilter(TokenService tokenService,
			@Qualifier("handlerExceptionResolver") HandlerExceptionResolver exceptionResolver) {
		this.tokenService = tokenService;
		this.exceptionResolver = exceptionResolver;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		try {
			String token = resolveToken(request);
			if (token != null) {
				User user = tokenService.verifyToken("Bearer " + token);
				if (user != null) {
					CurrentUser currentUser = new CurrentUser(user);
					UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(currentUser,
							null, currentUser.getAuthorities());
					auth.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
					SecurityContextHolder.getContext().setAuthentication(auth);
				}
			}
			filterChain.doFilter(request, response);
		} catch (Exception ex) {
			exceptionResolver.resolveException(request, response, null, ex);
		}
	}

	private String resolveToken(HttpServletRequest request) {
		String header = request.getHeader("Authorization");
		if (header != null && header.startsWith("Bearer ")) {
			return header.substring(7);
		}
		if (request.getCookies() != null) {
			for (Cookie c : request.getCookies()) {
				if (c.getName().equals("winka-desktop-user-token")) {
					return c.getValue();
				}
			}
		}
		return null;
	}

}
