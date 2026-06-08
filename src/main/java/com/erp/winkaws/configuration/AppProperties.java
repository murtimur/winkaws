package com.erp.winkaws.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "winka")
public class AppProperties {
	
	private String tokenType;
	
	private String barcodeNumber;

}
