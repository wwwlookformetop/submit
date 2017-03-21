<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ page  import = "com.online.dao.*" %>
<%@ page  import = "com.online.domain.*" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'detail.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <%
    	String articleid = request.getParameter("articleid");
    	int articleid1 = Integer.parseInt(articleid);
    	Article article =  new ArticleDAO().getArticleByID(articleid1);
    	request.setAttribute("article", article);
    %>
    <table>
    <tr>
    <td>
    		标题：${article.getTitle() }<br>
			内容: <a href="servlet/DownloadServlet?name=${article.getArticleID()}.txt">点此查看</a><br>
			类型: ${article.getType() }<br>
			投稿时间: ${article.getTime() }<br>
			稿件字数: ${article.getLength()}<br>
	</td>
	</tr>
    </table>
  </body>
</html>
