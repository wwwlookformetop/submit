package com.online.domain;

public class Writer {
	private int writerID;
	private String password;
	private String name;
	private String phone;
	private String address;
	private String email;
	private String cardID;
	public int getWriterID() {
		return writerID;
	}
	public void setWriterID(int writerID) {
		this.writerID = writerID;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCardID() {
		return cardID;
	}
	public void setCardID(String cardID) {
		this.cardID = cardID;
	}
	public Writer(int writerID, String password, String name, String phone,
			String address, String email, String cardID) {
		super();
		this.writerID = writerID;
		this.password = password;
		this.name = name;
		this.phone = phone;
		this.address = address;
		this.email = email;
		this.cardID = cardID;
	}
	public Writer() {
		super();
	}
	
	
	
}
