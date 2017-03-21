package com.online.domain;

public class Reviewer {
	private int reviewerID;
	private String password;
	private String name;
	private String phone;
	public int getReviewerID() {
		return reviewerID;
	}
	public void setReviewerID(int reviewerID) {
		this.reviewerID = reviewerID;
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
	public Reviewer(int reviewerID, String password, String name, String phone) {
		super();
		this.reviewerID = reviewerID;
		this.password = password;
		this.name = name;
		this.phone = phone;
	}
	public Reviewer() {
		super();
	}
	
	
}
