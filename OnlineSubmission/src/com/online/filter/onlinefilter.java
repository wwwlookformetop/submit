package com.online.filter;

import java.io.IOException;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class onlinefilter implements Filter {
	public static Set set = new HashSet(); ;  
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) arg0;
		HttpServletResponse response = (HttpServletResponse) arg1;
		System.out.print("nihoa"+"8888888888888888888888888888");
		if(request.getSession().getAttribute("name")==null){
			request.setAttribute("message", "ÇëµÇÂ¼");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
		}else{
			arg2.doFilter(request, response);
		}
		
		
	}

	
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
