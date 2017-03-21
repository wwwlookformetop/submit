package com.online.web.down;

import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DownloadServlet extends HttpServlet {

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
		String name =  request.getParameter("name");
        
        System.out.print(name);
        response.setContentType("application/x-msdownload");
        String path = this.getServletContext().getRealPath("/WEB-INF/down/"+name);
      
        String str = "attachment;filename="+java.net.URLEncoder.encode(name,"UTF-8");
        response.setHeader("Content-Disposition",str);
        FileInputStream in = new FileInputStream(path);
       
        ServletOutputStream out =response.getOutputStream();
        byte buffer[] = new byte[2048];
        int len;
        while((len=in.read(buffer))>0){
      	  out.write(buffer);
        }
        in.close();
        out.close();

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
