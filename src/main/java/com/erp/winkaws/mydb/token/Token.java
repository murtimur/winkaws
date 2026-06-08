package com.erp.winkaws.mydb.token;

import com.erp.winkaws.mydb.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "WinkaErpUserTokens")
public class Token {

	@Id
	private String token;
	
	@Transient
	private String prefix = "Bearer";
	
	@ManyToOne
	@JoinColumn(name = "userId")
	@JsonIgnore
	private User user;

	public Token() {
		super();
	}

	public Token(String prefix, String token) {
		super();
		this.token = token;
		this.prefix = prefix;
	}
	
}
