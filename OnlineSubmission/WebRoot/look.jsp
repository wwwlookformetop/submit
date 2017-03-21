<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  
  <body>
    <table frame="border" width="60%">
    	<tr>
    		<td>审稿人编号</td>
    		<td>文章编号</td>
    		<td>审稿状态</td>
    		<td>是否通过/td>
    		<td>评论</td>
    		
    	</tr>
    	
    	<c:forEach var="re" items="${review}">
    		<tr>
	    		<td>${re.reviewerID }</td>
	    		<td><a href = "/OnlineSubmission/servlet/download?name=${re.articleID}.txt" >${re.articleID}</a></td>
	    		<td>${re.reviewStatus }</td>
	    		
	    		<td>${re.passed }</td>
	    		<td>${re.comments }</td>
	    			
	    		
    		</tr>
    	</c:forEach>
    </table>
  </body>
</html>