package com.online.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;


import com.online.domain.articlemanager;
import com.online.utils.JDBCUtils;

public class articleManger extends BaseDAO<articlemanager>{
	
	
	public void insert(articlemanager a){

		Connection conn = JDBCUtils.getConn();
		
			
			String sql = "insert into articlemanagement values(?,?,?,?,?,?,?)";
			PreparedStatement pstmt;
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, a.getAdminID());
				pstmt.setInt(2, a.getArticleID());
				pstmt.setDate(3, a.getDate());
				pstmt.setFloat(4, a.getArticleFee());
				pstmt.setString(5, a.getArticleFeeStatus());
				pstmt.setFloat(6, a.getSpaceFee());
				pstmt.setString(7, a.getSpaceFeeStatus());
				
				pstmt.execute();
				pstmt.close();
				conn.close();
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
			 
	
	
	  
	
	
	

}
	 public List<articlemanager> getarticlemanager(int id){
		 String sql = "select adminID,articlemanagement.articleID,date,articleFee,articleFeeStatus,spaceFee,spaceFeeStatus from articlemanagement,article where  articlemanagement.articleID = article.articleID  and spaceFeeStatus='Î´½»' and article.writerID = ? ";
		return queryForList(sql,id);
	 }
	 
	 public void update(int adminID,int articleID){
		 String sql = "update articlemanagement set spaceFeeStatus='ÒÑ½»' where articleID =? and adminID = ?";
			PreparedStatement pstmt;
			Connection conn = JDBCUtils.getConn();
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, articleID);
				pstmt.setInt(2, adminID);
				
				pstmt.execute();
				pstmt.close();
				conn.close();
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
	 }
	
	
	
}
