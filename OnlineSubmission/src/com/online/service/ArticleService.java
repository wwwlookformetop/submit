package com.online.service;

import java.util.List;

import com.online.dao.ArticleDAO;
import com.online.domain.Article;
import com.online.domain.Page;

public class ArticleService {
	/**
	 * 获取指定作者的文章的page
	 * @param pageNum
	 * @param writerid
	 * @return
	 */
	public Page<Article> getTheWriterPage(int pageNum,int writerid){
		//获取所有记录
		int totalRecord =  new ArticleDAO().getOneWriterRecord(writerid);
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
		
		//List<Article> list = new ArticleDAO().getList( Page.PAGE_RECORD,pageNum);
		List<Article> list = new ArticleDAO().getArticleByWriteridList(Page.PAGE_RECORD, pageNum, writerid);
		
		return new Page<Article>(pageNum,list,totalRecord);
	}
	
	/*public Page<Article> getReviewedPage(int pageNum){
		//获取所有记录
		int totalRecord =  new ArticleDAO().getOneWriterRecord();
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
		
		//List<Article> list = new ArticleDAO().getList( Page.PAGE_RECORD,pageNum);
		List<Article> list = new ArticleDAO().getArticleByWriteridList(Page.PAGE_RECORD, pageNum, writerid);
		
		return new Page<Article>(pageNum,list,totalRecord);
	}
	*/
}
