package com.online.web.reviewer;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.online.dao.ReviewDAO;
import com.online.domain.Review;

public class DealArticleServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//String articleid = (String)request.getAttribute("articleid");
		String articleid = (String)request.getSession().getAttribute("articleid");
		int articleid1 = Integer.parseInt(articleid);
		Review review = new ReviewDAO().getReviewByArticleID(articleid1);
		System.out.println(articleid);
		String passed = request.getParameter("passed");
		String comments = request.getParameter("comments");
		System.out.println(passed);
		System.out.println(comments);
		review.setPassed(passed);
		review.setComments(comments);
		review.setReviewStatus("已审理");
		
		if(new ReviewDAO().updateReview(review)){
			request.setAttribute("message", "审理成功");
		}
		else{
			request.setAttribute("message", "审理失败");
		}
		
		request.getRequestDispatcher("/reviewer/massage.jsp").forward(request, response);
		
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}

}
