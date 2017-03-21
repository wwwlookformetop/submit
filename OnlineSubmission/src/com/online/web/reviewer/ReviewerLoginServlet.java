package com.online.web.reviewer;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.online.dao.ReviewerDAO;
import com.online.domain.Reviewer;

public class ReviewerLoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		int id1 = Integer.parseInt(id);
		System.out.println("��ȡ����id,password");
		ReviewerDAO rd = new ReviewerDAO();
		Reviewer reviewer = rd.Login(id1, password);
		System.out.println("���ݿ��ҵ���");
		if(reviewer != null){
			request.getSession().setAttribute("reviewer", reviewer);
			request.getRequestDispatcher("/reviewer/manager.jsp").forward(request, response);
		}else{
			request.setAttribute("message", "��¼ʧ��");
			request.getRequestDispatcher("/reviewer/massage.jsp").forward(request, response);
			
		}
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request,response);
	}

}
