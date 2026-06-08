package com.erp.winkaws.mydb.role.seeder;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.erp.winkaws.mydb.role.Role;
import com.erp.winkaws.mydb.role.RoleRepository;

@Order(1)
@Component
public class RoleSeeder implements CommandLineRunner {
	
	private final RoleRepository roleRepository;

	public RoleSeeder(RoleRepository roleRepository) {
		super();
		this.roleRepository = roleRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		createRole("ROLE_ADMIN");
		createRole("ROLE_USER");
		createRole("ROLE_MANAGER");
		createRole("ROLE_OPERATOR");
	}

	private void createRole(String name) {
		roleRepository.findByName(name).orElseGet(() -> {
			Role role = new Role();
			role.setName(name);
			return roleRepository.save(role);
		});
	}

}
