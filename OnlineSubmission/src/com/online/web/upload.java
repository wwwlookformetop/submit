package com.online.web;

import java.io.File;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import java.sql.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class upload extends HttpServlet {

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

		 String path = this.getServletContext().getRealPath("/WEB-INF/down");
		   
		    DiskFileItemFactory dis  =  new DiskFileItemFactory();
		    dis.setRepository(new File(this.getServletContext().getRealPath("/WEB-INF/temp")));
		    ServletFileUpload upload = new ServletFileUpload(dis);
		    upload.setHeaderEncoding("UTF-8"); 
		    List<FileItem> list = null;
			try {
				list = upload.parseRequest(request);
			} catch (FileUploadException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    for(FileItem item : list){
				
				if(item.isFormField()){
					//fileitem中封装的是普通输入项的数据
					String name = item.getFieldName();
					String value = item.getString("UTF-8");
					if(name.equals("time")){
						long  i = System.currentTimeMillis();
					    Date d = new Date(i);
					    java.sql.Timestamp st = new java.sql.Timestamp(d.getTime());
					    
					    request.getSession(false).setAttribute(name+"1", st);
					}
					request.getSession().setAttribute(name, value);
					
					//value = new String(value.getBytes("iso8859-1"),"UTF-8");
					System.out.println(name + "=" + value);
				}else{
					//fileitem中封装的是上传文件
					String filename = item.getName();  //不同的浏览器提交的文件是不一样  c:\a\b\1.txt   1.txt
					System.out.println(filename);
					if(filename==null || filename.trim().equals("")){
						continue;
					}
					    
					   long  i = System.currentTimeMillis();
					filename = i+""+filename.substring(filename.lastIndexOf("\\")+1);
				
					
					request.getSession().setAttribute("file", filename);
					InputStream in = item.getInputStream();
					//得到文件保存的名称
					//得到文件的保存目录
					FileOutputStream out = new FileOutputStream(path + "\\" + filename);
					System.out.print(path + "\\" + filename);
					byte buffer[] = new byte[1024];
					int len = 0;
					while((len=in.read(buffer))>0){
						out.write(buffer, 0, len);
			      }
					in.close();
					out.close();
					item.delete();  //删除临时文件
					}
		    }
		    String length2 = (String) request.getSession().getAttribute("length");
		    String money = Integer.parseInt(length2)/100+"";
		    request.setAttribute("message", money);
   			request.getRequestDispatcher("/give.jsp").forward(request, response);
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
