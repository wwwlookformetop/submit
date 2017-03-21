package com.online.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.online.domain.Writer;
import com.online.service.bussiness;

public class update extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	       request.setCharacterEncoding("UTF-8");
	   	
			String name =null;
			String userId =null;
			String userphone =null;
			String userpassword =null;
			  name=  request.getParameter("username");
			   System.out.print(name+"!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
			  userpassword = request.getParameter("password");
			  userId = request.getParameter("qq");
			  int userId2 = Integer.parseInt(userId);
			  userphone = request.getParameter("phone");
			  int  password = Integer.parseInt(userpassword);
			  String address = request.getParameter("address");
			  String email = request.getParameter("email");
			  String num = request.getParameter("money");
			  
			  Writer writer = new Writer();
			  writer.setAddress(address);
			  writer.setCardID(num);
			  writer.setEmail(email);
			  writer.setName(name);
			  writer.setPassword(password+"");
			  writer.setWriterID(userId2);
			  writer.setPhone(userphone);
			  bussiness bs = new bussiness();
			
				bs.Update(writer);
			     request.getSession().setAttribute("name", userId);
			    
			    
			     
			     List list = loginServlet.list;
			     list.add(request.getSession());
			     request.setAttribute("message", "更新成功");
				 request.getRequestDispatcher("/message.jsp").forward(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request,response);
	}

}
