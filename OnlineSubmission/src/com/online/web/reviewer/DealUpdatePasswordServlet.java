package com.online.web.reviewer;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.online.dao.ReviewerDAO;
import com.online.domain.Reviewer;

public class DealUpdatePasswordServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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
		String oldPassword = request.getParameter("oldpassword");
		String newPassword = request.getParameter("newpassword");
		
		Reviewer reviewer = (Reviewer)request.getSession().getAttribute("reviewer");
		
		if(oldPassword == reviewer.getPassword()){
			reviewer.setPassword(newPassword);
			if((new ReviewerDAO().updateReviewer(reviewer))){
				request.setAttribute("message", "–ﬁ∏ƒ√‹¬Î≥…π¶");
			}else{
				request.setAttribute("message", "–ﬁ∏ƒ√‹¬Î ß∞‹");
			}
		}else{
			request.setAttribute("message", "–ﬁ∏ƒ√‹¬Î ß∞‹");
		}
		request.getRequestDispatcher("/reviewer/massage.jsp").forward(request, response);
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
