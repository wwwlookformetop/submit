package com.online.web.admin;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.online.domain.articlemanager;
import com.online.service.bussiness;

public class ArticleMange extends HttpServlet {

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
			String id = request.getParameter("id");
			String article = request.getParameter("articleID");
			String date = request.getParameter("date");
			String money = request.getParameter("money");
			String spacemoney = request.getParameter("space");
			SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");
			String reviewId = request.getParameter("reviewerid");
			System.out.print(reviewId);
			bussiness b = new bussiness();
			java.sql.Date  date2=null;
			     try {
					Date date3 = sim.parse(date);
					date2 = new java.sql.Date(date3.getTime());
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    articlemanager a = new articlemanager(Integer.parseInt(id),Integer.parseInt(article),date2,Float.parseFloat(money),"ÒÑ¸ø",Float.parseFloat(spacemoney),"Î´½»");
		    b.insertarticlemanger(a);
		    b.updatereview(Integer.parseInt(article), Integer.parseInt(reviewId));
		    request.getRequestDispatcher("/servlet/SpaceMoney").forward(request, response);
			     
			     
		
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
