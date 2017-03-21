<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理员管理模块</title>
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
			hello,administrator！
			<form action="${pageContext.request.contextPath}/servlet/AdminLogoutServlet" method ="post">
				<input type = "submit" value = "注销">
			</form>
			</td>
			<td colspan="2">
				<div style="font: 30px black;">管理员模块</div>
			</td>
		</tr>
		<tr style="height:700px;" valign="top" >
			<td style="width: 20%; padding: 5px;">
				稿件管理<br/>
				<a target="content_frame" href="${pageContext.request.contextPath}/servlet/allocate">分配稿件任务</a><br /> 
				<a target="content_frame" href="${pageContext.request.contextPath}/admin/searchArticleByWriterID.jsp">查看指定作者的稿件</a><br/> <br/>
				审稿人管理<br/>
				<a target="content_frame" href="${pageContext.request.contextPath}/servlet/GetListServlet?pageNum=1">查看全部，删除与修改</a><br />
				<a target="content_frame" href="${pageContext.request.contextPath}/admin/addReviewer.jsp">增加</a><br />
				<a target="content_frame" href="${pageContext.request.contextPath}/admin/searchReviewer.jsp">查找</a><br />
				<br/>
				版面费稿费管理<br/>
				<a target="content_frame" href="${pageContext.request.contextPath}/servlet/SpaceMoney">版面费收取，稿费发放</a><br /> 
			</td>
			<td style="width: 80%; height:700px;">
				<iframe name="content_frame" style="width: 100%;height: 100%;" src="${pageContext.request.contextPath}/admin/index.jsp"></iframe>
			</td>
		</tr>
	</table>

</body>
</html>