package com.erp.winkaws.mydb.user.exception;

import java.util.Collections;
import java.util.Map;

import org.springframework.context.i18n.LocaleContextHolder;

import com.erp.winkaws.shared.Messages;

public class NotUniqueUsernameException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public NotUniqueUsernameException() {
		super(Messages.getMessageForLocale("winka.error.validation", LocaleContextHolder.getLocale()));
	}

	public Map<String, String> getValidationErrors() {
		return Collections.singletonMap("username",
				Messages.getMessageForLocale("winka.constraint.username.notunique", LocaleContextHolder.getLocale()));
	}
}
