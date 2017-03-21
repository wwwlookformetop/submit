package com.online.domain;

public class Article {
	private int articleID;
	private String title;
	private String A_abstract;
	private String type;
	private int length;
	private String time;
	private float reviewfee;
	private String reviewfeeStatus;
	private int writerID;
	public int getArticleID() {
		return articleID;
	}
	public void setArticleID(int articleID) {
		this.articleID = articleID;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getA_abstract() {
		return A_abstract;
	}
	public void setA_abstract(String a_abstract) {
		A_abstract = a_abstract;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public float getReviewfee() {
		return reviewfee;
	}
	public void setReviewfee(float reviewfee) {
		this.reviewfee = reviewfee;
	}
	public String getReviewfeeStatus() {
		return reviewfeeStatus;
	}
	public void setReviewfeeStatus(String reviewfeeStatus) {
		this.reviewfeeStatus = reviewfeeStatus;
	}
	public int getWriterID() {
		return writerID;
	}
	public void setWriterID(int writerID) {
		this.writerID = writerID;
	}
	public Article(int articleID, String title, String a_abstract, String type,
			int length, String time, float reviewfee, String reviewfeeStatus,
			int writerID) {
		super();
		this.articleID = articleID;
		this.title = title;
		A_abstract = a_abstract;
		this.type = type;
		this.length = length;
		this.time = time;
		this.reviewfee = reviewfee;
		this.reviewfeeStatus = reviewfeeStatus;
		this.writerID = writerID;
	}
	
	public Article(){
		
	}
}
