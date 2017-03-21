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
			    		<td>文章编号</td>
			    		
			    		
			    		<td>发表时间</td>
			    		<td>稿费</td>
			    		<td>版面费</td>
			    		<td>缴纳版面费</td>
			    		
			    		
			    	</tr>
    	
				    <c:forEach items="${list}" var="ar">
				    		<tr>
				    		<form action="/OnlineSubmission/servlet/givespace?adminID=${ar.adminID }&articleID=${ar.articleID}&spaceFee=${ar.spaceFee}" method="post" >
					    		
					    		<td><a href = "/OnlineSubmission/servlet/download?name=${ar.articleID}.txt" >${ar.articleID}</a></td>
					    		<td>${ar.date}</a></td>					    		
					    		<td>${ar.articleFee}</td>
					    		<td>${ar.spaceFee}</td>
					    	
					    		<td><input type="submit" value="缴纳版面费"></td>
					    		
					        </form>
					    	 
				    		</tr>
				    	</c:forEach>

    </table>
  </body>
</html>
