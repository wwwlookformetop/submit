<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Login.jsp' starting page</title>
    
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
    <h4>修改个人信息</h4>
    <form action="servlet/DealUpdateServlet" method="post">
    
		<table width="500px" style="border: 1px;">
			<tr>
				<td>ID</td>
				<td><input type="text" name="id" value = ${ reviewer.getReviewerID() } /></td>
			</tr>
			<tr>
				<td>名字</td>
				<td><input type="text" name="name" value = ${ reviewer.getName()} />
				</td>
			</tr>
			<tr>
				<td>phone</td>
				<td><input type="text" name="phone"  value =${ reviewer.getPhone()} /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="修改"></td>
			</tr>
		</table>
	</form>
    </center>
  </body>
</html>
