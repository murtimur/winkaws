package com.erp.winkaws.mydb.auth.exception;

import org.springframework.context.i18n.LocaleContextHolder;

import com.erp.winkaws.shared.Messages;

public class AuthenticationException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public AuthenticationException() {
		super(Messages.getMessageForLocale("winka.auth.invalid.credentials", LocaleContextHolder.getLocale()));
	}

}
