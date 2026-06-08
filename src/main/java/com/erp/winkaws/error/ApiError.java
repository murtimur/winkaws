package com.erp.winkaws.error;

import java.util.Date;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApiError {
	
	private Integer status;
	
	private String path;
	
	private String message;
	
	private Long timestamp = new Date().getTime();
	
	private Map<String, String> validationErrors = null;

}
