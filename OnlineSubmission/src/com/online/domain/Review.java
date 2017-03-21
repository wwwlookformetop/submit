package com.online.domain;

public class Review {
	private int reviewerID;
	private int articleID;
	private String reviewStatus;
	private String passed;
	private String comments;
	public int getReviewerID() {
		return reviewerID;
	}
	public void setReviewerID(int reviewerID) {
		this.reviewerID = reviewerID;
	}
	public int getArticleID() {
		return articleID;
	}
	public void setArticleID(int articleID) {
		this.articleID = articleID;
	}
	public String getReviewStatus() {
		return reviewStatus;
	}
	public void setReviewStatus(String reviewStatus) {
		this.reviewStatus = reviewStatus;
	}
	public String getPassed() {
		return passed;
	}
	public void setPassed(String passed) {
		this.passed = passed;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public Review(int reviewerID, int articleID, String reviewStatus,
			String passed, String comments) {
		super();
		this.reviewerID = reviewerID;
		this.articleID = articleID;
		this.reviewStatus = reviewStatus;
		this.passed = passed;
		this.comments = comments;
	}
	public Review() {
		super();
	}
	
	
}
