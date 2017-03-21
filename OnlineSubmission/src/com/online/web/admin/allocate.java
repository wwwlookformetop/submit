package com.online.web.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.online.dao.Page;
import com.online.service.bussiness;

public class allocate extends HttpServlet {

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
		String page = request.getParameter("page");
		String page3 = request.getParameter("pageNum");
		 bussiness b = new bussiness();
		 request.setAttribute("rer", b.getReviewer());
		 
		 if(page==null){
			 Page page2 = new Page();
				
				Page pagereal = b.getAllatricle(page2);
				
				request.setAttribute("page", pagereal);
				request.getRequestDispatcher("/admin/allocate.jsp").forward(request, response);
				return;
		 }
		if(page.equals("next")){
			Page page2 = new Page();
			page2.setNext(page);
			page2.setPageNum(Integer.parseInt(page3));
			Page pagereal = b.getAllatricle(page2);
			request.setAttribute("page", pagereal);
			request.getRequestDispatcher("/admin/allocate.jsp").forward(request, response);
			return ;
		}
		if(page.equals("last")){
			Page page2 = new Page();
			page2.setLast(page);
			page2.setPageNum(Integer.parseInt(page3));
			Page pagereal = b.getAllatricle(page2);
			request.setAttribute("page", pagereal);
			request.getRequestDispatcher("/admin/allocate.jsp").forward(request, response);
			return ;
		}
		
		if(page.equals("firstpage")){
			Page page2 = new Page();
			page2.setFirstPageNum(page);
			page2.setPageNum(Integer.parseInt(page3));
			Page pagereal = b.getAllatricle(page2);
			request.setAttribute("page", pagereal);
			request.getRequestDispatcher("/admin/allocate.jsp").forward(request, response);
			return ;
		}
		
		if(page.equals("lastpage")){
			Page page2 = new Page();
			page2.setLastPageNum(page);
			page2.setPageNum(Integer.parseInt(page3));
			Page pagereal = b.getAllatricle(page2);
			request.setAttribute("page", pagereal);
			request.getRequestDispatcher("/admin/allocate.jsp").forward(request, response);
			return ;
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

		doGet(request,response);
	}

}
