package com.erp.winkaws.error;

import java.util.stream.Collectors;

import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.erp.winkaws.mydb.auth.exception.AuthenticationException;
import com.erp.winkaws.mydb.user.exception.NotUniqueUsernameException;
import com.erp.winkaws.shared.Messages;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class ErrorHandler {

	@ExceptionHandler({ MethodArgumentNotValidException.class, NotUniqueUsernameException.class,
			AuthenticationException.class, GlobalValidationException.class })
	public ResponseEntity<ApiError> handleError(Exception exception, HttpServletRequest request) {
		ApiError apiError = new ApiError();
		apiError.setPath(request.getRequestURI());
		apiError.setStatus(400);
		if (exception instanceof MethodArgumentNotValidException ex) {
			String message = Messages.getMessageForLocale("winka.error.validation", LocaleContextHolder.getLocale());
			apiError.setMessage(message);
			var validationErrors = ex.getBindingResult().getFieldErrors().stream().collect(
					Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage, (existing, _) -> existing));
			apiError.setValidationErrors(validationErrors);
		} else if (exception instanceof GlobalValidationException ex) {
			String message = Messages.getMessageForLocale("winka.error.validation", LocaleContextHolder.getLocale());
			apiError.setMessage(message);
			apiError.setValidationErrors(ex.getValidationErrors());
		} else if (exception instanceof NotUniqueUsernameException ex) {
			apiError.setMessage(ex.getMessage());
			apiError.setValidationErrors(ex.getValidationErrors());
		} else if (exception instanceof AuthenticationException ex) {
			apiError.setStatus(401);
			apiError.setMessage(ex.getMessage());
		}
		return ResponseEntity.status(apiError.getStatus()).body(apiError);
	}

}
