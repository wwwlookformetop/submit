package com.online.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;



import com.online.domain.Article;
import com.online.utils.JDBCUtils;

public class ArticleDAO extends BaseDAO<Article>{
	public boolean createArticle(Article article){
		boolean flag = false;
		SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date date1;
		
		Connection conn = JDBCUtils.getConn();
		try {  
			date1 = sf.parse(article.getTime());
			String sql = "insert into article values(?,?,?,?,?,?,?,?,?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);  
			pstmt.setInt(1, article.getArticleID()); 
			pstmt.setString(2, article.getTitle());
			pstmt.setString(3, article.getA_abstract());
			pstmt.setString(4, article.getType());
			pstmt.setInt(5, article.getLength());
			pstmt.setDate(6, new java.sql.Date(date1.getTime()));
			pstmt.setFloat(7, article.getReviewfee());
			pstmt.setString(8, article.getReviewfeeStatus());
			pstmt.setInt(9, article.getWriterID());
			if(pstmt.executeUpdate()>0){
				flag = true;
			}
			pstmt.close();
			conn.close();
		}  
		catch (Exception e){  
		e.printStackTrace();  
		}
		return flag;
	}
	
	/**
	 * 根据稿件的编号获取稿件信息
	 * @param articleID
	 * @return
	 */
	public Article getArticleByID(int articleID){
		String sql = "select * from article where articleid = ?";
		return query(sql,articleID);
	}
	/**
	 * 根据投稿人编号获取其所有的稿件信息
	 * @param writerID
	 * @return
	 */
	public List<Article> getAllArticleByWriterID(int writerID){
		String sql = "select * from article where writerid = ?";
		return queryForList(sql, writerID);
	}
	
	
	public List<Article> getAllArticle(){
		String sql = "select * from article";
		return queryForList(sql);
	}
	
	public List<Article> getAllArticleByReviewerID(int reviewerID){
		String sql = "{call getAllArticleByReviewerID(?)}";
		return queryForList(sql,reviewerID);
	}
	
	public int getOneWriterRecord(int writerid) {
		String sql = "select count(*) from article where writerid = ?";
		return QueryForSingleValue(sql,writerid);
	}
	
	public int getReviewedRecord() {
		String sql = "select count(*) from article,review where article.articleId= review.articleID and review.reviewStatus = '已审理'";
		return QueryForSingleValue(sql);
	}
	public List<Article> getArticleByWriteridList(int size,int pageNum,int writerid){
		String sql = "{call getArticleBywriterIDPage(?,?,?)}";
		return queryForList(sql,size,pageNum,writerid);
	}
	
	public List<Article> getReviewedList(int size,int pageNum){
		String sql = "{call getReviewedPage(?,?)}";
		return queryForList(sql,size,pageNum);
	}
	
	public  int getArticle(int writerID,Timestamp da){
		   int id =0;
		   System.out.print(da.toString()+"sadfasfsafdsafsafsafsa");
		try {
			Connection conn = JDBCUtils.getConn();
			String sql = "select articleID from article where writerid = "+writerID+"and time= '"+da.toString()+"'";
			 
			Statement st = conn.createStatement();
			
			ResultSet rs = st.executeQuery(sql);
			if(rs.next()){
			   id = rs.getInt("articleID");
			   return id;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return id;
	}
	public List<Article> getAllArticle(int size,int pageNum){
		String sql = "{call getArticlePage3(?,?)}";
		return queryForList(sql,size,pageNum);

	}
	public int gettotal(){
		
		int i=0;
		
		
		Connection conn = JDBCUtils.getConn();
		try {  
			
			String sql = "select count(*) as total from article where fenpei = '未分配' ";
        Statement st = conn.createStatement();
			
			ResultSet rs = st.executeQuery(sql);
			if(rs.next()){
				i= rs.getInt(1);
				   return i;
				}
			
			
			
			conn.close();
		}  
		catch (Exception e){  
		e.printStackTrace();  
		}
		return i;
			
			//return QueryForSingleValue(sql);
	}
	
	
	public void update(int id ){
		
		String sql = "update article set fenpei = '已分配' where articleID = ?";
		
		Connection conn = JDBCUtils.getConn();
		
		PreparedStatement st;
		try {
			st = conn.prepareStatement(sql);
			st.setInt(1, id);
			st.execute();
			st.close();
			conn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean createArticle(Article article,Timestamp a){
		 System.out.print(a.toString()+"aaaaaaaaaaaaaa");
		boolean flag = false;
		
		
		Connection conn = JDBCUtils.getConn();
		try {  
			
			String sql = "insert into article(title,abstract,type,length,time,reviewfee,reviewfeeStatus,writerid) values(?,?,?,?,?,?,?,?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);  
			 
			pstmt.setString(1, article.getTitle());
			pstmt.setString(2, article.getA_abstract());
			pstmt.setString(3, article.getType());
			pstmt.setInt(4, article.getLength());
			pstmt.setTimestamp(5, a);
			pstmt.setFloat(6, article.getReviewfee());
			pstmt.setString(7, article.getReviewfeeStatus());
			pstmt.setInt(8, article.getWriterID());
			if(pstmt.executeUpdate()>0){
				flag = true;
			}
			pstmt.close();
			conn.close();
		}  
		catch (Exception e){  
		e.printStackTrace();  
		}
		return flag;
	}
}
