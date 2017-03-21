package com.online.domain;

import java.util.List;

public class Page<T> {
	// ��ǰҳ��ҳ��
		private int pageNum;
		// ���ݶ���ļ���
		private List<T> list;
		// �ܼ�¼��
		private int totalRecord;

		// ��ҳ��
		private int totalPageCount;
		// ��ʾ�ĵ�һ��ҳ��
		private int firstPageNum;
		// ��ʾ�����һ��ҳ��
		private int lastPageNum;

		// һҳ��ʾ�ļ�¼��
		public static final int PAGE_RECORD = 3;
		// ��ʾ��ҳ����
		public static final int DISPLAY_PAGE_COUNT = 5; // ����
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
