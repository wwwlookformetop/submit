package com.online.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import com.online.domain.Review;
import com.online.utils.JDBCUtils;

public class ReviewDAO extends BaseDAO<Review>{
	
	
	public boolean createReview(Review review){
		boolean flag = false;
		Connection conn = JDBCUtils.getConn();
		try {  
		
			String sql = "insert into review values(?,?,?,?,?,?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);  
			pstmt.setInt(1, review.getReviewerID()); 
			pstmt.setInt(2, review.getArticleID()); 
			pstmt.setString(3, review.getReviewStatus());
			pstmt.setString(4, review.getPassed());
			pstmt.setString(5, review.getComments());
			pstmt.setString(6, "未交");
			
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
	
	
	public boolean updateReview(Review review){
		boolean flag = false;
		Connection conn = JDBCUtils.getConn();
		try {  
		
			String sql = "update  review  set reviewerid = ?,passed= ?,comments = ?, reviewstatus = ? where articleid = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);  
			pstmt.setInt(1, review.getReviewerID()); 
			pstmt.setInt(5, review.getArticleID()); 
			pstmt.setString(4, review.getReviewStatus());
			pstmt.setString(2, review.getPassed());
			pstmt.setString(3, review.getComments());
			
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
	
	public List<Review> getAllReview(){
		String sql = "select * from review";
		return queryForList(sql);
	}
	
	public List<Review> getAllReviewByReviewerID(int reviewerID){
		String sql = "select * from review where reviewerid = ? and reviewStatus = '未审理'";
		return queryForList(sql,reviewerID);
	}
	
	public Review getReviewByArticleID(int articleID){
		String sql = "select * from review where articleid = ?";
		return query(sql,articleID);
	}
	
	public List<Review> getAllReviewedByReviewerID(int reviewerID){
		String sql = "select * from review where reviewerid = ? and reviewStatus = '已审理'";
		return queryForList(sql,reviewerID);
	}
	public List  getPassReview(){
		
		String sql = "select articleID,reviewerID from review where passed='YES'and money='未交'";
		return queryForList(sql);
		
		
	}
	
	public List<Review> getAllReview(int id){
		String sql = "select reviewerID,review.articleID,reviewStatus,passed,comments from review,article where review.articleID=article.articleID and article.writerID=?";
		return queryForList(sql,id);
	}
	
	public void updatereview(int articleID,int reviewID){
		String sql = "update review set money='已交' where reviewerID=? and articleID=?";
		Connection conn = JDBCUtils.getConn();
		try {  
		
			
			PreparedStatement pstmt = conn.prepareStatement(sql);  
			pstmt.setInt(1, reviewID); 
			pstmt.setInt(2, articleID); 
			
			pstmt.execute();
			
			pstmt.close();
			conn.close();
		}  
		catch (Exception e){  
		e.printStackTrace();  
		}
		
	}
}
