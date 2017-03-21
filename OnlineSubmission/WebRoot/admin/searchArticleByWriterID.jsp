<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="com.online.dao.*"%>
<%@ page import="com.online.domain.*"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'searchArticleByWriterID.jsp' starting page</title>
  </head>
  <style type="text/css">
.STYLE6 {font-size: 12px}
.STYLE10 {font-size: 14px; font-weight: bold; }
</style>
  <body>
  <center>
    <h1>查找指定作者的稿件</h1>
   		   <form action="servlet/SearchArticlesServlet?pageNum=1" method="post">
    
				<table width="500px" style="border: 1px;">
					<tr>
						<td>请输入要查找的作者编号：</td>
						<td><input type="text" name="id"  /></td>
					</tr>
				<tr>
					<td colspan="2"><input type="submit" value="查找"></td>
				</tr>
		</table>
	</form>
	
	
	<c:if test="${page!=null}">
				<c:forEach items="${page.list}" var="article">
					<div style="width:500px; height:250px; ">
				   		<div style="width:350px; height:200px; text-align: left;"  >
				   			<br>
				   			稿件编号: <a href="${pageContext.request.contextPath}/client/BookServlet?method=showBook&bookid=${article.getArticleID()}">${article.getArticleID() }</a><br>
				   			标题：${article.getTitle() }<br>
				   			类型: ${article.getType() }<br>
				   			字数: ${article.getLength()}<br>
				   			内容: <a href="servlet/DownloadServlet?name=${article.getArticleID()}.txt">点此查看</a><br>
				   			投稿时间: ${article.getTime()}<br>
				   			审稿费: ${article.getReviewfee()}<br>
				   			审稿费状态: ${article.getReviewfeeStatus()}<br>
				   			作者编号： ${article.getWriterID()}<br>
				   			<c:set var = "articleid" value = "${article.getArticleID()} ">
				   			</c:set>
				   			<%
				   			//String id = (String)"articleid".valueOf("articleid");
				   			//int id1 = Integer.parseInt(id);
				   			String id = (String)pageContext.getAttribute("articleid");
				   			int id1 = Integer.parseInt(id.trim());
				   			Review review = new ReviewDAO().getReviewByArticleID(id1);
				   			request.setAttribute("review", review);
				   			 %>
				   			审阅状态：${review.getReviewStatus()}<br>
				   			是否通过：${review.getPassed()}<br>
				   			审稿人评语：${review.getComments()}<br>
				   		</div>
				   		
			   		</div>
			   		<br><br><br>
				</c:forEach>
				<br>
				<div>
					<c:if test="${page.pageNum>1}">
					 	<a href="${pageContext.request.contextPath}/servlet/SearchArticlesServlet?pageNum=${page.pageNum-1}">上一页</a>
						&nbsp;
					 </c:if>
					 
					 <c:if test="${page.firstPageNum>1}">
					 	<a href="${pageContext.request.contextPath}/servlet/SearchArticlesServlet?pageNum=1">1</a>
						&nbsp;
					 </c:if>
					 
					 <c:if test="${page.firstPageNum>2}">
					 	...
					 </c:if>
					 
					 
					<c:forEach begin="${page.firstPageNum}" end="${page.lastPageNum}" var="num">
						<c:choose>
							<c:when test="${num==page.pageNum}">${num}</c:when>
							<c:otherwise><a href="${pageContext.request.contextPath}/servlet/SearchArticlesServlet?pageNum=${num}">${num}</a></c:otherwise>
						</c:choose>&nbsp;
					</c:forEach>
					
					<c:if test="${page.lastPageNum<page.totalPageCount-1}">
					 	...
					 </c:if>
					
					<c:if test="${page.lastPageNum<page.totalPageCount}">
					 	<a href="${pageContext.request.contextPath}/servlet/SearchArticlesServlet?pageNum=${page.totalPageCount}">${page.totalPageCount}</a>
					 	&nbsp;
					 </c:if>
					 
					 <c:if test="${page.pageNum<page.totalPageCount}">
					 	<a href="${pageContext.request.contextPath}/servlet/SearchArticlesServlet?pageNum=${page.pageNum+1}">下一页</a>
					 	&nbsp;
					 </c:if>
					 
					到第<input type="text" id="toPage" style="width: 30px;text-align: center;" value="${page.pageNum}"/>页
					<br>
					当前第&nbsp;${page.pageNum}&nbsp;页 总共&nbsp;${page.totalPageCount}&nbsp;页 总共 &nbsp;${page.totalRecord}&nbsp;条记录
					
				</div>
			</c:if>
			
		<div>
			<c:if test="${page==null}">
				没有匹配稿件
			</c:if>
		</div>
	</center>
  </body>
</html>
