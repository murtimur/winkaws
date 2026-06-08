package com.erp.winkaws.error;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;

@Aspect
@Component
public class GlobalValidationConfig {

	private final Validator validator;

	public GlobalValidationConfig(Validator validator) {
		this.validator = validator;
	}

	@Before("within(@org.springframework.web.bind.annotation.RestController *) || within(@org.springframework.stereotype.Controller *)")
	public void validateMethodArgs(JoinPoint joinPoint) {
		for (Object arg : joinPoint.getArgs()) {
			if (arg == null || isSimpleType(arg.getClass()))
				continue;
			Set<ConstraintViolation<Object>> violations = validator.validate(arg);
			if (!violations.isEmpty()) {
				Map<String, String> errors = new HashMap<>();
				for (ConstraintViolation<?> v : violations) {
					String field = v.getPropertyPath().toString();
					if (field.contains(".")) {
						field = field.substring(field.lastIndexOf('.') + 1);
					}
					errors.put(field, v.getMessage());
				}
				throw new GlobalValidationException(errors);
			}
		}
	}

	private boolean isSimpleType(Class<?> clazz) {
		return clazz.isPrimitive() || clazz.equals(String.class) || Number.class.isAssignableFrom(clazz)
				|| clazz.equals(Boolean.class) || clazz.equals(Character.class);
	}
	
}
