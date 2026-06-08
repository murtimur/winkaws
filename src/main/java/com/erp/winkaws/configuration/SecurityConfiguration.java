package com.erp.winkaws.configuration;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.servlet.HandlerExceptionResolver;

import com.erp.winkaws.mydb.token.TokenService;

@EnableWebSecurity
@Configuration
@EnableMethodSecurity(prePostEnabled = false)
public class SecurityConfiguration {

	@Bean
	public TokenFilter tokenFilter(TokenService tokenService,
			@Qualifier("handlerExceptionResolver") HandlerExceptionResolver resolver) {
		return new TokenFilter(tokenService, resolver);
	}

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http, TokenFilter tokenFilter) throws Exception {
		return http.csrf(csrf -> csrf.disable())
				.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
				.authorizeHttpRequests(auth -> auth.requestMatchers(HttpMethod.OPTIONS, "/**").permitAll()
						.requestMatchers(SWAGGER_PATHS).permitAll().requestMatchers(PERMIT_PATHS).permitAll()
						.requestMatchers(ADMIN_PATHS).hasRole("ADMIN").anyRequest().hasAnyRole(AUTHORIZATION_NAMES))
				.addFilterBefore(tokenFilter, UsernamePasswordAuthenticationFilter.class).build();
	}

	public static final String[] SWAGGER_PATHS = { "/swagger-ui/**", "/v3/api-docs/**", "/swagger-ui.html" };

	public static final String[] PERMIT_PATHS = { "/api/1.0.1/auth" };
	
	public static final String[] ADMIN_PATHS = { "/api/1.0.1/users/**" };
	
	public static final String[] AUTHORIZATION_NAMES = { "ADMIN", "USER", "MANAGER", "OPERATOR" };

	@Bean
	public FilterRegistrationBean<TokenFilter> tokenFilterRegistration(TokenFilter tokenFilter) {
		FilterRegistrationBean<TokenFilter> registration = new FilterRegistrationBean<>();
		registration.setFilter(tokenFilter);
		registration.setEnabled(false);
		return registration;
	}

}
