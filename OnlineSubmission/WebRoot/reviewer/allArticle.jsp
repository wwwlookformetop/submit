<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'allArticle.jsp' starting page</title>
    
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
  <center>
  <h1>待审理稿件</h1>
    				<c:forEach items="${list}" var="article">
					<div style="width:500px; height:170px; ">
				   		<div style="width:350px; height:150px; text-align: left;"  >
				   			<br>
				   			标题：${article.getTitle() }<br>
				   			内容: <a href="servlet/DownloadServlet?name=${article.getArticleID()}.txt">点此查看</a><br>
				   			类型: ${article.getType() }<br>
				   			投稿时间: ${article.getTime() }<br>
				   			稿件字数: ${article.getLength()}<br><br>
				   			<a href = " ${pageContext.request.contextPath}/servlet/OneArticleServlet?articleid=${ article.getArticleID()} ">点击进行审理</a>
				   		</div>
				   		
			   		</div>
				</c:forEach>
	</center>
  </body>
</html>
