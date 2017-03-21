<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page  import = "com.online.dao.*" %>
<%@ page  import = "com.online.domain.*" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'reviewed.jsp' starting page</title>
    
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
  		Reviewer reviewer = (Reviewer)request.getSession().getAttribute("reviewer");
  		List<Review> review = new ReviewDAO().getAllReviewedByReviewerID(reviewer.getReviewerID());
  		request.setAttribute("reviewed", review);
   %>
    <center>
    	 <h1>已审理</h1>
    	 <c:choose>
    	 	<c:when test="${reviewed!=null }">
   <table width="500px" style="border: 1px;">
    	<tr>
    	<td>稿件编号</td>
    	<td>稿件详情</td>
    	<td>是否通过</td>
    	<td>稿件评语</td>
    	</tr>
    	
    	
    	
    	 <c:forEach items="${reviewed}" var="review"> 
    	  <tr>
    	 <td>
		${review.getArticleID() }
		</td>
		
		<td>
		<a href="${pageContext.request.contextPath}/reviewer/detail.jsp?articleid=${review.getArticleID() } ">稿件详情</a><br>
		</td>
		
		<td>
		${review.getPassed() }<br>
		</td>
		
		<td>
		${review.getComments() }<br>
		</td>
		</tr>
		<br>
		</c:forEach>
		
		
	</table>
	</c:when>	
	
	<c:otherwise>
	已审理的稿件为空！
	</c:otherwise>
	</c:choose>
    </center>
  </body>
</html>
