package com.online.web.reviewer;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.online.dao.ReviewerDAO;
import com.online.domain.Reviewer;

public class DealUpdateServlet extends HttpServlet {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		int id1 = Integer.parseInt(id);
		System.out.println(id);
		System.out.println("到达了servlet");
		Reviewer reviewer = new Reviewer();
		reviewer = new ReviewerDAO().getReviewerByID(id1);
		reviewer.setName(name);
		reviewer.setPhone(phone);
		ReviewerDAO rd = new ReviewerDAO();
		if(rd.updateReviewer(reviewer)){
			System.out.println("修改成功");
			request.setAttribute("message", "修改成功");
		}else{
			request.setAttribute("message", "修改失败");
			System.out.println("修改失败");
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
