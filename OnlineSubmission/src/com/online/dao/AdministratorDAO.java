package com.online.dao;

import com.online.domain.Administrator;

public class AdministratorDAO extends BaseDAO<Administrator>{
	public Administrator login(int adminID,String password){
		String sql = "select * from administrator where adminid = ? and password = ?";
		return query(sql,adminID,password);
	}
	
}
