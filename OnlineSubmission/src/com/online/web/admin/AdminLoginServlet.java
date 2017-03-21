package com.online.web.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.online.dao.AdministratorDAO;
import com.online.domain.Administrator;

public class AdminLoginServlet extends HttpServlet {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		int id1 = Integer.parseInt(id);
		System.out.println("��ȡ����id,password");
		AdministratorDAO ad = new AdministratorDAO();
		Administrator admin = ad.login(id1, password);
		System.out.println("����Ա��¼�����ҵ���");
		if(admin != null){
			request.getSession().setAttribute("admin", admin);
			request.getRequestDispatcher("/admin/manager.jsp").forward(request, response);
		}else{
			request.setAttribute("message", "��¼ʧ��");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
			
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
