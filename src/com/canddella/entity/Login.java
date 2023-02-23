package com.canddella.entity;

public class Login {
		private int loginid;
	 private String username;
	 private String password;
	public Login() {
		super();
	}
	
	public int getLoginid() {
		return loginid;
	}

	public void setLoginid(int loginid) {
		this.loginid = loginid;
	}

	public Login(int loginid, String username, String password) {
		super();
		this.loginid = loginid;
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	 

}
