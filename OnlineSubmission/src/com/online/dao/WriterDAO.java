package com.online.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.online.domain.Writer;
import com.online.utils.JDBCUtils;

public class WriterDAO extends BaseDAO<Writer>{
	/**
	 * 创建投稿人
	 * @param writer
	 * @return
	 */
	public boolean createWriter(Writer writer){
		boolean flag = false;
		String sql = "insert into writer values(?,?,?,?,?,?,?)";
		Connection conn= JDBCUtils.getConn();
		try {  
			PreparedStatement pstmt = conn.prepareStatement(sql);  
			pstmt.setInt(1, writer.getWriterID()); 
			pstmt.setString(2, writer.getPassword());
			pstmt.setString(3, writer.getName());
			pstmt.setString(5, writer.getAddress());
			pstmt.setString(4, writer.getPhone());
			pstmt.setString(6, writer.getEmail());
			pstmt.setString(7, writer.getCardID());
			
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
	 * 更新投稿人，可用于修改个人信息，修改密码
	 * @param writer
	 * @return
	 */
	public boolean updateWriter(Writer writer){
		String sql = "update writer set password = ?,name = ?,phone = ?,address = ?,email = ?, cardid = ? where writerid = ?";
		boolean flag = false;
		Connection conn= JDBCUtils.getConn();
		try {  
			PreparedStatement pstmt = conn.prepareStatement(sql);  
			pstmt.setInt(7, writer.getWriterID()); 
			pstmt.setString(1, writer.getPassword());
			pstmt.setString(2, writer.getName());
			pstmt.setString(3, writer.getAddress());
			pstmt.setString(4, writer.getPhone());
			pstmt.setString(5, writer.getEmail());
			pstmt.setString(6, writer.getCardID());
			
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
	 * 通过输入投稿人编号，获取投稿人对象
	 * @param writerID
	 * @return
	 */
	public Writer getWriterByID(int writerID){
		String sql = "select * from writer where writerid = ?";
		return query(sql,writerID);
		
	}
	/**
	 * 获取所有的投稿人对象集合
	 * @return
	 */
	public List<Writer> getAllWriter(){
		String sql = "select * from writer";
		return queryForList(sql);
	}
	
	public Writer LoginWriter(int writerID,String password){
		
		String sql = "select writerID,password from writer where writerid = ? and password = ?";
		 Writer w = new Writer();
		 String pd=null;
		 int writerid=0;
		Connection conn= JDBCUtils.getConn();
	
			PreparedStatement pstmt;
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, writerID); 
				pstmt.setString(2, password);
				ResultSet rs = pstmt.executeQuery();
				if(rs.next()){
					 writerid = rs.getInt("writerID");
					 pd = rs.getString("password");
				}else{
					return null;
				}
				w.setWriterID(writerid);
				w.setPassword(pd);	 
				pstmt.close();
				conn.close();
				return w;
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			
				 
			
			return null;
		
		
	
		
	}
	
}
