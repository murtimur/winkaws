package com.erp.winkaws.configuration;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.erp.winkaws.mydb.user.User;
import com.erp.winkaws.mydb.user.UserService;

@Service
public class AppUserDetailsService implements UserDetailsService {

	private final UserService userService;

	public AppUserDetailsService(UserService userService) {
		super();
		this.userService = userService;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User inDB = userService.getUser(username);
		if (inDB == null)
			throw new UsernameNotFoundException(username + " is not found");
		return new CurrentUser(inDB);
	}

}
