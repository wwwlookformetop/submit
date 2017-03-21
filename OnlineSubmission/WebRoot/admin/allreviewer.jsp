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
	<h1 >管理审稿人</h1>
		
	
	<br>
	
			<c:if test="${page!=null}">
				<TABLE BORDER="1" cellpadding="5" cellspacing="0" width="100%">
				<TR>
						<td align="center" valign="middle"><span class="STYLE10">账户</span></td>
						<td align="center" valign="middle"><span class="STYLE10">密码</span></td>
						<td align="center" valign="middle"><span class="STYLE10">姓名</span></td>
						<td align="center" valign="middle"><span class="STYLE10">电话</span></td>
						<td align="center" valign="middle" colspan="2"><span class="STYLE10">操作</span></td>
				</TR>
				
					
					
				<c:forEach items="${page.list}" var="reviewer">
						<form action="${pageContext.request.contextPath}/servlet/ReviewerManagerServlet?operation=3" method="post">
						<TR>
							<td align="center" valign="middle"><span class="STYLE6"><input type="text" name="id" value="${reviewer.getReviewerID() }"></span></td>
							<td align="center" valign="middle"><span class="STYLE6"><input type="text" name="password" value="${reviewer.getPassword() }"></span></td>
							<td align="center" valign="middle"><span class="STYLE6"><input type="text" name="name" value="${reviewer.getName() }"></span></td>
							<td align="center" valign="middle"><span class="STYLE6"><input type="text" name="phone" value="${reviewer.getPhone() }"></span></td>
							<td align="center" valign="middle"><span class="STYLE6"><input type="submit" value="修改">
							</span></td>
							<td align="center" valign="middle"><span class="STYLE6">
								<a href="${pageContext.request.contextPath}/servlet/ReviewerManagerServlet?operation=2&id=${reviewer.getReviewerID() }">删除</a>
							</span></td>
						</TR>
						</form>
					
					
				</c:forEach>
				
				</TABLE>
				<br>
				<div>
					<c:if test="${page.pageNum>1}">
					 	<a href="${pageContext.request.contextPath}/servlet/GetListServlet?pageNum=${page.pageNum-1}">上一页</a>
						&nbsp;
					 </c:if>
					 
					 <c:if test="${page.firstPageNum>1}">
					 	<a href="${pageContext.request.contextPath}/servlet/GetListServlet?pageNum=1">1</a>
						&nbsp;
					 </c:if>
					 
					 <c:if test="${page.firstPageNum>2}">
					 	...
					 </c:if>
					 
					 
					<c:forEach begin="${page.firstPageNum}" end="${page.lastPageNum}" var="num">
						<c:choose>
							<c:when test="${num==page.pageNum}">${num}</c:when>
							<c:otherwise><a href="${pageContext.request.contextPath}/servlet/GetListServlet?pageNum=${num}">${num}</a></c:otherwise>
						</c:choose>&nbsp;
					</c:forEach>
					
					<c:if test="${page.lastPageNum<page.totalPageCount-1}">
					 	...
					 </c:if>
					
					<c:if test="${page.lastPageNum<page.totalPageCount}">
					 	<a href="${pageContext.request.contextPath}/servlet/GetListServlet?pageNum=${page.totalPageCount}">${page.totalPageCount}</a>
					 	&nbsp;
					 </c:if>
					 
					 <c:if test="${page.pageNum<page.totalPageCount}">
					 	<a href="${pageContext.request.contextPath}/servlet/GetListServlet?pageNum=${page.pageNum+1}">下一页</a>
					 	&nbsp;
					 </c:if>
					 
				
					<br>
					当前第&nbsp;${page.pageNum}&nbsp;页 总共&nbsp;${page.totalPageCount}&nbsp;页 总共 &nbsp;${page.totalRecord}&nbsp;条记录
					
				</div>
			</c:if>
			
		<div>
			<c:if test="${page==null}">
				没有审稿人记录
			</c:if>
		</div>
</center>
</body>
</html>