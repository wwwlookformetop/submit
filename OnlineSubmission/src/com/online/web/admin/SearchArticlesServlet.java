package com.online.web.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.online.domain.Article;
import com.online.domain.Page;
import com.online.domain.Writer;
import com.online.service.ArticleService;

public class SearchArticlesServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ArticleService articleService = new ArticleService();
	Writer writer = new Writer();
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
		System.out.println(id);
		if(id == null){
			String pageNumString = request.getParameter("pageNum");
			int pageNum = Integer.parseInt(pageNumString);
			
			Page<Article> page = articleService.getTheWriterPage(pageNum, writer.getWriterID());
			request.setAttribute("page", page);
			//String path = (String)request.getAttribute("path");
			//System.out.println(path);
			request.getRequestDispatcher("/admin/searchArticleByWriterID.jsp").forward(request, response);
		}else{
			int id1 = Integer.parseInt(id);
			//request.getSession().setAttribute("id", id);
			writer.setWriterID(id1);
			String pageNumString = request.getParameter("pageNum");
			int pageNum = Integer.parseInt(pageNumString);
			
			Page<Article> page = articleService.getTheWriterPage(pageNum, writer.getWriterID());
			request.setAttribute("page", page);
			request.getRequestDispatcher("/admin/searchArticleByWriterID.jsp").forward(request, response);
		}
		
		//int id1 = Integer.parseInt((String)request.getSession().getAttribute("id"));
		
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
