package com.online.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import com.online.domain.Reviewer;
import com.online.utils.JDBCUtils;

public class ReviewerDAO extends BaseDAO<Reviewer>{
	
	/**
	 * 增加投稿人
	 * @param reviewer
	 * @return
	 */
	public boolean createReviewer(Reviewer reviewer){
		boolean flag = false;
		Connection conn = JDBCUtils.getConn();
		try {  
		
			String sql = "insert into reviewer values(?,?,?,?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);  
			pstmt.setInt(1, reviewer.getReviewerID()); 
			pstmt.setString(2, reviewer.getPassword());
			pstmt.setString(3, reviewer.getName());
			pstmt.setString(4, reviewer.getPhone());
			
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
	 * 修改审稿人信息
	 * @param reviewer
	 * @return
	 */
	public boolean updateReviewer(Reviewer reviewer){
		boolean flag = false;
		Connection conn = JDBCUtils.getConn();
		try {  
		
			String sql = "update reviewer set password = ?,name = ?,phone = ? where reviewerid = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);  
			pstmt.setInt(4, reviewer.getReviewerID()); 
			pstmt.setString(1, reviewer.getPassword());
			pstmt.setString(2, reviewer.getName());
			pstmt.setString(3, reviewer.getPhone());
			
			if(pstmt.executeUpdate()>0){
				System.out.println("djfksaljfals   ");
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
	
	public boolean deleteReviewer(int reviewerID){
		boolean flag = false;
		Connection conn = JDBCUtils.getConn();
		try {  
			String sql = "delete from reviewer where reviewerid = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);  
			pstmt.setInt(1, reviewerID); 
			
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
	 * 通过输入审稿人ID，获取审稿人信息
	 * @param reviewerID
	 * @return
	 */
	public Reviewer getReviewerByID(int reviewerID){
		String sql = "select * from reviewer where reviewerID = ?";
		return query(sql,reviewerID);
	}
	public Reviewer Login(int reviewerID,String password){
		String sql = "select * from reviewer where reviewerID = ? and password = ?";
		return query(sql,reviewerID,password);
	}
	
	public List<Reviewer> getAllReviewer(){
		String sql = "select * from reviewer";
		return queryForList(sql);
	}
	
	public List<Reviewer> getList(int size,int pageNum){
		String sql = "{call getreviewerlist(?,?)}";
		return queryForList(sql,size,pageNum);
	}
	
	public int getTotalRecord() {
		String sql = "select count(*) from reviewer";
		return QueryForSingleValue(sql);
	}
	
}
