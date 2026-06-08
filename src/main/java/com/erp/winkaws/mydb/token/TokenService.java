package com.erp.winkaws.mydb.token;

import com.erp.winkaws.mydb.auth.dto.Credentials;
import com.erp.winkaws.mydb.user.User;

public interface TokenService {

	public Token createToken(User user, Credentials creds);

	public User verifyToken(String authorizationHeader);

	public void logout(String authorizationHeader);

}
