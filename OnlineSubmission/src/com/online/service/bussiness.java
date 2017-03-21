package com.online.service;


import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import com.online.dao.ArticleDAO;
import com.online.dao.Page;
import com.online.dao.ReviewDAO;
import com.online.dao.ReviewerDAO;
import com.online.dao.WriterDAO;
import com.online.dao.articleManger;
import com.online.domain.Article;
import com.online.domain.ArticleManagement;
import com.online.domain.Review;
import com.online.domain.Writer;
import com.online.domain.articlemanager;



public class bussiness {
	WriterDAO writerdao = new WriterDAO();
    ReviewDAO re = new ReviewDAO();
    ArticleDAO a = new ArticleDAO();
    ReviewerDAO rer = new ReviewerDAO();
    articleManger am  = new articleManger();
	public void Register(Writer writer) throws SQLException{
		
		writerdao.createWriter(writer);
		
	}
	public Writer login(int writerId,String password) {
		return writerdao.LoginWriter(writerId,password);
		
	}
	public void Update(Writer writer){
		writerdao.updateWriter(writer);
	}
	public List getAllreview(int id){
		return  re.getAllReview(id);
	}
	public void Addatricle(Article b,Timestamp date){
		a.createArticle(b,date);
		
	}
	public int getAtricle(int writerID,Timestamp  date){
		 return a.getArticle(writerID,date);
		
	}
	public Page getAllatricle(Page page){
		
		int i = a.gettotal();
		int totalpage = (i/(Integer.parseInt(Page.PAGE_RECORD))+1);
		if(page.getPageNum()==0){
		    
			
			
			
			Page page2 = new Page();
			
			
			
			page2.setTotalPageCount(totalpage);
			page2.setPageNum(1);
			List list =a.getAllArticle(Integer.parseInt(Page.PAGE_RECORD), 1);
			page2.setList(list);
			return page2;
			
		}
		
		
		
		
			
		if(page.getLast()!=null){
			
			
			
			Page page2 = new Page();
		
			page2.setTotalPageCount(totalpage);
			page2.setPageNum(page.getPageNum()-1);
			List list =a.getAllArticle(Integer.parseInt(Page.PAGE_RECORD), page.getPageNum()-1);
			page2.setList(list);
			return page2;
		
			
			
			
			
		}
		
		if(page.getNext()!=null){
			
			
			
			Page page2 = new Page();
			
			page2.setTotalPageCount(totalpage);
			page2.setPageNum(page.getPageNum()+1);
			List list =a.getAllArticle(Integer.parseInt(Page.PAGE_RECORD), page.getPageNum()+1);
			page2.setList(list);
			return page2;

			
		}
        if(page.getFirstPageNum()!=null){
			
			
			
			Page page2 = new Page();
	
			page2.setTotalPageCount(totalpage);
			page2.setPageNum(1);
			List list =a.getAllArticle(Integer.parseInt(Page.PAGE_RECORD), 1);
			page2.setList(list);
			return page2;

			
		}
        if(page.getLastPageNum()!=null){
			
			
			
			Page page2 = new Page();
	
			page2.setTotalPageCount(totalpage);
			page2.setPageNum(totalpage);
			List list =a.getAllArticle(Integer.parseInt(Page.PAGE_RECORD), totalpage);
			page2.setList(list);
			return page2;

			
		}
				
     return null;
			
			
		
}
	
	
	public List getReviewer(){
		return rer.getAllReviewer();
		
	}
	
	public void insertintoreview(Review re2){
		 re.createReview(re2);
	}
	
	public void update(int id){
		a.update(id);
	}
	
	public List getPassed(){
		return re.getPassReview();
	}
	public void insertarticlemanger(articlemanager a){
		am.insert(a);
	}
	
	public void updatereview(int articleID,int reviewID){
		re.updatereview(articleID, reviewID);
		
	}
	public List getarticlemanager(int id){
		 return am.getarticlemanager(id);
	}
	
	
	public void updatearticlemanager(int adminID,int articleID){
		am.update(adminID, articleID);
	}
	
}
