package com.online.web.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.online.dao.ReviewerDAO;
import com.online.domain.Reviewer;

public class ReviewerManagerServlet extends HttpServlet {

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
		String operation = request.getParameter("operation");
		if(operation.equals("1")){
			String id = request.getParameter("id");
			String password = request.getParameter("password");
			String name = request.getParameter("name");
			String phone = request.getParameter("phone");
			int id1 = Integer.parseInt(id);
			Reviewer reviewer = new Reviewer();
			reviewer.setReviewerID(id1);
			reviewer.setPassword(password);
			reviewer.setName(name);
			reviewer.setPhone(phone);
			if(new ReviewerDAO().createReviewer(reviewer)){
				request.setAttribute("message", "增加成功！");
			}else{
				request.setAttribute("message", "增加失败！可能是id冲突");
			}
			request.getRequestDispatcher("/message.jsp").forward(request, response);
		}
		
		if(operation.equals("2")){
			String id = request.getParameter("id");
			int id1 = Integer.parseInt(id);
			if(new ReviewerDAO().deleteReviewer(id1)){
				request.setAttribute("message", "删除成功！");
			}else{
				request.setAttribute("message", "删除失败！");
			}
			request.getRequestDispatcher("/message.jsp").forward(request, response);
		}
		
		if(operation.equals("3")){
			String id = request.getParameter("id");
			String password = request.getParameter("password");
			String name = request.getParameter("name");
			String phone = request.getParameter("phone");
			int id1 = Integer.parseInt(id);
			Reviewer reviewer = new Reviewer();
			reviewer.setReviewerID(id1);
			reviewer.setPassword(password);
			reviewer.setName(name);
			reviewer.setPhone(phone);
			if(new ReviewerDAO().updateReviewer(reviewer)){
				request.setAttribute("message", "修改成功！");
			}else{
				request.setAttribute("message", "修改失败！");
			}
			request.getRequestDispatcher("/message.jsp").forward(request, response);
		}
		
		if(operation.equals("4")){
			String id = request.getParameter("id");
			int id1 = Integer.parseInt(id);
			Reviewer reviewer = new Reviewer();
			reviewer = new ReviewerDAO().getReviewerByID(id1);
			if(reviewer != null){
				request.setAttribute("reviewer", reviewer);
				request.getRequestDispatcher("/admin/searchReviewer.jsp").forward(request, response);
			}else{
				request.setAttribute("message", "没有查找到该审稿人！");
				request.getRequestDispatcher("/message.jsp").forward(request, response);
			}
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
