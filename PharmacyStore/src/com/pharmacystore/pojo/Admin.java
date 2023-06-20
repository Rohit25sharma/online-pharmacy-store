package com.pharmacystore.pojo;

public class Admin {

	private String userid;
	private String password;
	
	public Admin(String userid, String password) {
		this.userid = userid;
		this.password = password;
	}

	public Admin() {
		super();
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
