<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'oneArticle.jsp' starting page</title>
    
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
    <h4>请审阅</h4>
    <form action="${pageContext.request.contextPath}/servlet/DealArticleServlet" method="post">
    
		<table width="500px" style="border: 1px;">
			<tr>
				<td>是否通过</td>
				<td><input type="radio" name="passed" value="YES" />是 </td>
				<td><input type="radio" name="passed" value="NO" />否 </td>
			</tr>
			<tr>
				<td>评语</td>
			</tr>
			<tr>
				<td><textarea name = "comments" rows="20" cols="50">
					</textarea>
				</td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="提交"></td>
			</tr>
		</table>
	</form>
    </center>
  </body>
</html>
