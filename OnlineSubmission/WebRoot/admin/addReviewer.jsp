<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<style type="text/css">
.STYLE6 {font-size: 12px}
.STYLE10 {font-size: 14px; font-weight: bold; }
</style>
<body>
<center>
	<h1 >增加审稿人</h1>
		<form action="${pageContext.request.contextPath}/servlet/ReviewerManagerServlet?operation=1" method="post" >
		<table width="50%" border="1" cellspacing="0" cellpadding="2">
			<TR >
				<td align="center" ><span class="STYLE10">id</span></td>
			  <td align="left" >
			  	<input type="text" name="id" >
			  </td>
			</TR>
			<TR >
				<td align="center" ><span class="STYLE10">password</span></td>
			  <td align="left"><input type="text" name="password"></td>
			</TR>
			
			<TR>
				<td align="center" ><span class="STYLE10">name</span></td>
			  <td align="left"><input type="text" name="name"></td>
			</TR>
			
			<TR>
				<td align="center"><span class="STYLE10">phone</span></td>
			  <td align="left"><input type="text" name="phone"></td>
			</TR>
			
			<TR>
				<td align="center"colspan="3">
					<input type="submit" value="增加审稿人">
					<input type="reset" value="重置">
				</td>
			</TR>
	  </TABLE>
	  
	</form>
	
</center>
</body>
</html>