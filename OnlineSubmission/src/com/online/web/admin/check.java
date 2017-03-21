package com.online.web.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.online.domain.Review;
import com.online.service.bussiness;

public class check extends HttpServlet {

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

		String reviewID = request.getParameter("select");
		String articleID = request.getParameter("articleID");
		Review re = new Review();
		re.setArticleID(Integer.parseInt(articleID));
		re.setReviewerID(Integer.parseInt(reviewID));
		re.setComments("暂无");
	    re.setPassed("未通过");
	    re.setReviewStatus("未审理");
	    bussiness b = new  bussiness();
	    b.insertintoreview(re);
	    b.update(Integer.parseInt(articleID));
	    request.getRequestDispatcher("/servlet/allocate").forward(request, response);
	    
	    
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
