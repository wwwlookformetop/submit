<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  

  </head>
  
  <body>
    <table frame="border" width="60%">
			    	<tr>
			    		<td>管理员编号</td>
			    		<td>文章编号</td>
			    		
			    		<td>发表时间</td>
			    		<td>稿费</td>
			    		<td>版面费</td>
			    		<td>提交</td>
			    		
			    		
			    	</tr>
    	
				    <c:forEach items="${list}" var="ar">
				    		<tr>
				    		<form action="/OnlineSubmission/servlet/ArticleMange?reviewerid=${ar.reviewerID }&id=${id }&articleID=${ar.articleID}" method="post" >
					    		<td>${id }</td>
					    		<td>${ar.articleID}</a></td>
					    							    		
					    		<td><input type="text" name="date"></td>
					    		<td><input type="text" name="money"></td>
					    		<td><input type="text" name="space"></td>
					    		<td><input type="submit" value="提交"></td>
					    		
					        </form>
					    	 
				    		</tr>
				    	</c:forEach>

    </table>
  </body>
</html>
