package com.online.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.online.domain.User;
import com.online.domain.Writer;
import com.online.service.bussiness;

public class loginServlet extends HttpServlet {

	
	
	static List list = new ArrayList();
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
		
		try {
			String id = request.getParameter("id");
			int id2 = Integer.parseInt(id);
			
			String userpassword = request.getParameter("password");

			
			bussiness buss = new bussiness();
			Writer user = buss.login(id2, userpassword);
			if (user == null) {
				request.setAttribute("message", "用户名或密码不对！！");
				request.getRequestDispatcher("/message.jsp").forward(request,
						response);
				return;
			}
		
			
			request.getSession().setAttribute("name", id);
			request.getSession().setAttribute("password",userpassword);
			list.add(request.getSession());
			
		    
			 request.getRequestDispatcher("/head.jsp").forward(request, response);  
			 
		} catch (Exception e) {
			request.setAttribute("message", "用户名或密码不对！！");
			request.getRequestDispatcher("/message.jsp").forward(request,
					response);
		}

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

		doGet(request, response);
	}

}
