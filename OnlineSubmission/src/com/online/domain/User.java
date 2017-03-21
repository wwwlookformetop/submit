package com.online.domain;

public class User {
	public int adminID;
	public String password;
	public String name;
	public String phone;
	public int getAdminID() {
		return adminID;
	}
	public void setAdminID(int adminID) {
		this.adminID = adminID;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public User(int adminID, String password, String name, String phone) {
		super();
		this.adminID = adminID;
		this.password = password;
		this.name = name;
		this.phone = phone;
	}
	
	
	public User(){
		
	}
}
