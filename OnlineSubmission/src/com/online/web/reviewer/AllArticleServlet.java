package com.online.web.reviewer;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.online.dao.ArticleDAO;
import com.online.domain.Article;
import com.online.domain.Reviewer;

public class AllArticleServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Reviewer reviewer = (Reviewer)request.getSession().getAttribute("reviewer");
		ArticleDAO ad = new ArticleDAO();
		List<Article> list = ad.getAllArticleByReviewerID(reviewer.getReviewerID());
		if(list != null){
			request.setAttribute("list", list);
			request.getRequestDispatcher("/reviewer/allArticle.jsp").forward(request, response);
		}else{
			request.setAttribute("message", "没有要审理的稿件");
			request.getRequestDispatcher("/reviewer/massage.jsp").forward(request, response);
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
