package com.online.domain;

import java.sql.Date;

public class articlemanager {
	public articlemanager(int adminID, int articleID, Date date,
			float articleFee, String articleFeeStatus, float spaceFee,
			String spaceFeeStatus) {
		super();
		this.adminID = adminID;
		this.articleID = articleID;
		this.date = date;
		this.articleFee = articleFee;
		this.articleFeeStatus = articleFeeStatus;
		this.spaceFee = spaceFee;
		this.spaceFeeStatus = spaceFeeStatus;
	}
	public int getAdminID() {
		return adminID;
	}
	public void setAdminID(int adminID) {
		this.adminID = adminID;
	}
	public int getArticleID() {
		return articleID;
	}
	public void setArticleID(int articleID) {
		this.articleID = articleID;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public float getArticleFee() {
		return articleFee;
	}
	public void setArticleFee(float articleFee) {
		this.articleFee = articleFee;
	}
	public String getArticleFeeStatus() {
		return articleFeeStatus;
	}
	public void setArticleFeeStatus(String articleFeeStatus) {
		this.articleFeeStatus = articleFeeStatus;
	}
	public float getSpaceFee() {
		return spaceFee;
	}
	public void setSpaceFee(float spaceFee) {
		this.spaceFee = spaceFee;
	}
	public String getSpaceFeeStatus() {
		return spaceFeeStatus;
	}
	public void setSpaceFeeStatus(String spaceFeeStatus) {
		this.spaceFeeStatus = spaceFeeStatus;
	}
	public articlemanager() {
		super();
		// TODO Auto-generated constructor stub
	}
	int adminID;
	int articleID;
	Date date;
	float articleFee;
	String articleFeeStatus;
	float spaceFee;
	String spaceFeeStatus;

}
