package com.erp.winkaws.mydb.user;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.erp.winkaws.mydb.authority.Authority;
import com.erp.winkaws.mydb.role.Role;
import com.erp.winkaws.mydb.token.Token;
import com.erp.winkaws.mydb.usersettings.UserSettings;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "WinkaErpUsers")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private Boolean status;

	private String username;

	private String password;

	private String image;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "WinkaErpJoinUserRole", joinColumns = @JoinColumn(name = "userId"), inverseJoinColumns = @JoinColumn(name = "roleId"))
	private Set<Role> roles = new HashSet<Role>();
	
	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	private UserSettings settings;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Authority> authorities = new HashSet<Authority>();
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
	private List<Token> tokens;

}
