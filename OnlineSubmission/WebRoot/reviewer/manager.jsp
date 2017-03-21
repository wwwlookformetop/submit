<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>在线投稿系统审稿人模块</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/common.css">
<style type="text/css">
table {
	height: 780px;
	width: 100%;
}
</style>
</head>
<body>
		<table>
		<tr style="height: 80px; background:#ffddaa; text-align: center;">
			<td>
			hello,审稿人
			<form action="${pageContext.request.contextPath}/servlet/ReviewerLogoutServlet" method ="post">
				<input type = "submit" value = "注销">
			</form>
			</td>
			<td colspan="2">
				<div style="font: 30px black;">审稿人审理稿件</div>
			</td>
		</tr>
		<tr style="height:700px;" valign="top" >
			<td style="width: 20%; padding: 5px;">
				个人管理<br/>
				<a target="content_frame" href="${pageContext.request.contextPath}/servlet/UpdateAllServlet">修改个人信息</a><br /> 
				<a target="content_frame" href="${pageContext.request.contextPath}/servlet/UpdatePasswordServlet">修改密码</a><br/> <br/>
				稿件管理<br/>
				<a target="content_frame" href="${pageContext.request.contextPath}/servlet/AllArticleServlet">审理稿件</a><br />
				<a target="content_frame" href="${pageContext.request.contextPath}/reviewer/reviewed.jsp">查看已审理</a><br />
				<br/>
			</td>
			<td style="width: 80%; height:700px;">
				<iframe name="content_frame" style="width: 100%;height: 100%;" src="${pageContext.request.contextPath}/reviewer/index.jsp"></iframe>
			</td>
		</tr>
	</table>

</body>
</html>