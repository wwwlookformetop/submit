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
    
    <title>My JSP 'searchReviewer.jsp' starting page</title>

  </head>
  
  <body>
   <center>
   		<h1>查找审稿人</h1>
   		   <form action="servlet/ReviewerManagerServlet?operation=4" method="post">
    
				<table width="500px" style="border: 1px;">
					<tr>
						<td>请输入要查找的审稿人编号：</td>
						<td><input type="text" name="id"  /></td>
					</tr>
				<tr>
					<td colspan="2"><input type="submit" value="查找"></td>
				</tr>
		</table>
	</form>
   		<c:choose>
   			<c:when test="${reviewer!=null }">
   			<table width="500px" style="border: 1px;">
					<tr>
						<td>审稿人编号：</td>
						<td>${reviewer.getReviewerID()}</td>
					</tr>
					<tr>
						<td>审稿人密码：</td>
						<td>${reviewer.getPassword()}</td>
					</tr>
					<tr>
						<td>审稿人姓名：</td>
						<td>${reviewer.getName()}</td>
					</tr>
					<tr>
						<td>审稿人电话：</td>
						<td>${reviewer.getPhone()}</td>
					</tr>
   			</table>
   			</c:when>
   			<c:otherwise>
   			</c:otherwise>
   		</c:choose>
   </center>
  </body>
</html>
