package com.online.dao;

import java.util.List;

public class Page<T> {


	private int  pageNum=0;
	// ���ݶ���ļ���
	private List<T> list;
	// �ܼ�¼��
	private String next;
	private String last;
	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	public String getNext() {
		return next;
	}

	public void setNext(String next) {
		this.next = next;
	}

	public String getLast() {
		return last;
	}

	public void setLast(String last) {
		this.last = last;
	}

	public String getTotalRecord() {
		return totalRecord;
	}

	public void setTotalRecord(String totalRecord) {
		this.totalRecord = totalRecord;
	}

	public int getTotalPageCount() {
		return totalPageCount;
	}

	public void setTotalPageCount(int totalPageCount) {
		this.totalPageCount = totalPageCount;
	}

	public String getFirstPageNum() {
		return firstPageNum;
	}

	public void setFirstPageNum(String firstPageNum) {
		this.firstPageNum = firstPageNum;
	}

	public String getLastPageNum() {
		return lastPageNum;
	}

	public void setLastPageNum(String lastPageNum) {
		this.lastPageNum = lastPageNum;
	}

	public static String getPAGE_RECORD() {
		return PAGE_RECORD;
	}

	public static void setPAGE_RECORD(String pAGE_RECORD) {
		PAGE_RECORD = pAGE_RECORD;
	}

	public Page(int pageNum, List<T> list, String next, String last,
			String totalRecord, int totalPageCount, String firstPageNum,
			String lastPageNum) {
		super();
		this.pageNum = pageNum;
		this.list = list;
		this.next = next;
		this.last = last;
		this.totalRecord = totalRecord;
		this.totalPageCount = totalPageCount;
		this.firstPageNum = firstPageNum;
		this.lastPageNum = lastPageNum;
	}

	public Page() {
		super();
		// TODO Auto-generated constructor stub
	}

	private String  totalRecord;

	// ��ҳ��
	private int  totalPageCount;
	// ��ʾ�ĵ�һ��ҳ��
	private String  firstPageNum;
	// ��ʾ�����һ��ҳ��
	private String  lastPageNum;

	// һҳ��ʾ�ļ�¼��
	public static  String PAGE_RECORD = "4";

	
	

}
