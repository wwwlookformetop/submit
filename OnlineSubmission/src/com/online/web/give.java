package com.online.web;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.online.domain.Article;
import com.online.service.bussiness;

public class give extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	  String path = this.getServletContext().getRealPath("/WEB-INF/down");
	  String money = request.getParameter("money"); 
	  String title = (String) request.getSession().getAttribute("title");
	  String abstrac = (String) request.getSession().getAttribute("abstarct");
	  String select = (String) request.getSession().getAttribute("select");
	  String length = (String) request.getSession().getAttribute("length");
	  String time = (String) request.getSession().getAttribute("time");
	  String qq =  (String) request.getSession().getAttribute("qq");
	  Timestamp  da =  (Timestamp) request.getSession().getAttribute("time1");
	  
	  Article a = new Article();
	  a.setTitle(title);
	  a.setA_abstract(abstrac);
	  a.setType(select);
	  a.setLength(Integer.parseInt(length));
	  a.setTime(time);
	  a.setWriterID(Integer.parseInt(qq));
	  a.setReviewfee(Float.parseFloat(money));
	  a.setReviewfeeStatus("");
	  bussiness n = new bussiness();
	  n.Addatricle(a,da);
	  int id = n.getAtricle(Integer.parseInt(qq), da);
	 
	  File f = new File(path+"\\"+ request.getSession().getAttribute("file"));
	  String filename = (String) request.getSession().getAttribute("file");
	  String filename2=filename.substring(filename.lastIndexOf(".")+1);
	  String filename3 = id+"."+filename2;
	  System.out.print(filename3);
	  File f2 = new File(path+"\\"+filename3);
	  f.renameTo(f2);
	  request.setAttribute("message", "上传成功");
	  request.getRequestDispatcher("/message.jsp").forward(request, response);
	  
			
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request,response);
	}

}
