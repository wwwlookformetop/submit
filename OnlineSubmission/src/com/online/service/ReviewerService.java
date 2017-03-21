package com.online.service;

import java.util.List;

import com.online.dao.ReviewerDAO;
import com.online.domain.Page;
import com.online.domain.Reviewer;

public class ReviewerService {
	public Page<Reviewer> getPage(int pageNum){
		//获取所有记录
		int totalRecord =  new ReviewerDAO().getTotalRecord();
		if(totalRecord==0) {
			return null;
		}
		//总页数
		int totalPageCount = (totalRecord+Page.PAGE_RECORD-1)/Page.PAGE_RECORD;
		
		if(pageNum>totalPageCount) {
			pageNum = totalPageCount;
		} else if(pageNum<1){
				pageNum = 1;
		}
		
		List<Reviewer> list = new ReviewerDAO().getList( Page.PAGE_RECORD,pageNum);
		
		
		return new Page<Reviewer>(pageNum,list,totalRecord);
	}
}
