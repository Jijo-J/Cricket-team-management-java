package com.canddella.service;

import com.canddella.dao.LoginDAOImpl;
import com.canddella.entity.Login;

public class LoginServiceImpl implements LoginService {
	

	@Override
	public Login loginuser(String username, String password) {
		LoginDAOImpl loginDAOImpl = new LoginDAOImpl();
		 Login login=loginDAOImpl.loginuser( username, password);
		return login;
		
		
	}

}
