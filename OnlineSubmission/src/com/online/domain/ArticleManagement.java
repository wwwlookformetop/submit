package com.online.domain;

public class ArticleManagement {
	private int adminID;
	private int articleID;
	private String date;
	private float articlefee;
	private String articlefeeStatus;
	private float spacefee;
	private String spacefeeStatus;
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
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public float getArticlefee() {
		return articlefee;
	}
	public void setArticlefee(float articlefee) {
		this.articlefee = articlefee;
	}
	public String getArticlefeeStatus() {
		return articlefeeStatus;
	}
	public void setArticlefeeStatus(String articlefeeStatus) {
		this.articlefeeStatus = articlefeeStatus;
	}
	public float getSpacefee() {
		return spacefee;
	}
	public void setSpacefee(float spacefee) {
		this.spacefee = spacefee;
	}
	public String getSpacefeeStatus() {
		return spacefeeStatus;
	}
	public void setSpacefeeStatus(String spacefeeStatus) {
		this.spacefeeStatus = spacefeeStatus;
	}
	public ArticleManagement(int adminID, int articleID, String date,
			float articlefee, String articlefeeStatus, float spacefee,
			String spacefeeStatus) {
		super();
		this.adminID = adminID;
		this.articleID = articleID;
		this.date = date;
		this.articlefee = articlefee;
		this.articlefeeStatus = articlefeeStatus;
		this.spacefee = spacefee;
		this.spacefeeStatus = spacefeeStatus;
	}
	public ArticleManagement() {
		super();
	}
	
	
		
}
