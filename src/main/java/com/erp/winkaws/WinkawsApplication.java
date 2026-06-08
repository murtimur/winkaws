package com.erp.winkaws;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;

import com.erp.winkaws.mydb.user.UserService;

@SpringBootApplication
public class WinkawsApplication {

	public static void main(String[] args) {
		SpringApplication.run(WinkawsApplication.class, args);
	}
	
	@Order(2)
	@Bean
	CommandLineRunner createAdminUser(UserService userService) {
		return (_) -> {
			userService.createAdminUser();
		};
	}

}
