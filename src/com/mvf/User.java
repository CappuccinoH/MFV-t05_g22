package com.mvf;

public class User {
	private String account;
	private String password;
	private String status;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(String account, String password, String status) {
		super();
		this.account = account;
		this.password = password;
		this.status = status;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
