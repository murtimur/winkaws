package com.erp.winkaws.mydb.user.validation;

import com.erp.winkaws.mydb.user.User;
import com.erp.winkaws.mydb.user.UserService;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UniqueUsernameValidator implements ConstraintValidator<UniqueUsername, String> {

	private final UserService userService;

	@Override
	public boolean isValid(String username, ConstraintValidatorContext context) {
		User inDB = userService.getUser(username);
		return inDB == null;
	}

}
