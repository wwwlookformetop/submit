package com.online.domain;

import java.util.List;

public class Page<T> {
	// 当前页的页码
		private int pageNum;
		// 数据对象的集合
		private List<T> list;
		// 总记录数
		private int totalRecord;

		// 总页数
		private int totalPageCount;
		// 显示的第一个页码
		private int firstPageNum;
		// 显示的最后一个页码
		private int lastPageNum;

		// 一页显示的记录数
		public static final int PAGE_RECORD = 3;
		// 显示的页码数
		public static final int DISPLAY_PAGE_COUNT = 5; // 奇数
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
		public int getTotalRecord() {
			return totalRecord;
		}
		public void setTotalRecord(int totalRecord) {
			this.totalRecord = totalRecord;
		}
		public int getTotalPageCount() {
			return totalPageCount;
		}
		public void setTotalPageCount(int totalPageCount) {
			this.totalPageCount = totalPageCount;
		}
		public int getFirstPageNum() {
			return firstPageNum;
		}
		public void setFirstPageNum(int firstPageNum) {
			this.firstPageNum = firstPageNum;
		}
		public int getLastPageNum() {
			return lastPageNum;
		}
		public void setLastPageNum(int lastPageNum) {
			this.lastPageNum = lastPageNum;
		}
		public  int getPageRecord() {
			return PAGE_RECORD;
		}
		public  int getDisplayPageCount() {
			return DISPLAY_PAGE_COUNT;
		}
		public Page(int pageNum, List<T> list, int totalRecord) {
			super();
			this.pageNum = pageNum;
			this.list = list;
			this.totalRecord = totalRecord;
			this.totalPageCount = (totalRecord+PAGE_RECORD-1)/PAGE_RECORD;

			if(totalPageCount<DISPLAY_PAGE_COUNT) {
				firstPageNum = 1;
				lastPageNum = totalPageCount;
			} else {
				
				firstPageNum = pageNum-DISPLAY_PAGE_COUNT/2;
				lastPageNum = pageNum+DISPLAY_PAGE_COUNT/2;
				
				if(firstPageNum<1) {
					firstPageNum = 1;
					lastPageNum = DISPLAY_PAGE_COUNT;
				}
				
				if(lastPageNum>totalPageCount) {
					lastPageNum = totalPageCount;
					firstPageNum = totalPageCount-DISPLAY_PAGE_COUNT+1;
				}
			}
		}
		
		
		
}
