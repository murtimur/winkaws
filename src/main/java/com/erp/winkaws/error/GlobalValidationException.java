package com.erp.winkaws.error;

import java.util.Map;

public class GlobalValidationException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private final Map<String, String> validationErrors;

	public GlobalValidationException(Map<String, String> validationErrors) {
		super("Validation failed");
		this.validationErrors = validationErrors;
	}

	public Map<String, String> getValidationErrors() {
		return validationErrors;
	}

}
