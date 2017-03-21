<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>

			
				<div style="text-align: left;font-size: 20px; background: #afafaf; width:500px;padding: 5px;"> 稿件分配</div>
				
				
				  <table frame="border" width="60%">
			    	<tr>
			    		<td>文章编号</td>
			    		<td>文章主题</td>
			    		
			    		<td>文章类型</td>
			    		<td>文章长度</td>
			    		<td>上传时间</td>
			    		<td>审稿费</td>
			    		<td>审稿费状态</td>
			    		<td>投稿者qq</td>
			    		<td>审稿人编号</td>
			    		<td>分配稿件</td>
			    	</tr>
    	
				    <c:forEach items="${page.list}" var="ar">
				    		<tr>
					    		<td>${ar.articleID }</td>
					    		<td>${ar.title}</a></td>
					    							    		
					    		<td>${ar.type }</td>
					    		<td>${ar.length }</td>
					    		<td>${ar.time }</td>
					    		<td>${ar.reviewfee }</td>
					    		<td>${ar.reviewfeeStatus }</td>
					    		<td>${ar.writerID }</td>
					    		<td>
					    	  <form action="/OnlineSubmission/servlet/check?articleID=${ar.articleID }" method = "post">
					    		<select name="select" id="select_k1" class="xla_k">
				                  <c:forEach items="${rer }" var = "reviewer">
				                     
                 						 <option value="${ reviewer.reviewerID}">${ reviewer.reviewerID}</option>
     
				                  </c:forEach>
        						 </select>
        					
        						 </td>
        						 <td>
        						  <input type="submit" name="submit" value="分配"> 
        						 </td>
        						 </form>
				    		</tr>
				    	</c:forEach>

    </table>
				
				
				   
					
				
				<br>
				<div>
				    <a href="${pageContext.request.contextPath}/servlet/allocate?page=firstpage&pageNum=1">首页</a>
						&nbsp;
					<c:if test="${page.pageNum>1}">
					 	<a href="${pageContext.request.contextPath}/servlet/allocate?page=last&pageNum=${page.pageNum}">上一页</a>
						&nbsp;
					 </c:if>
					 
					 <c:if test="${page.pageNum<page.totalPageCount}">
					 	<a href="${pageContext.request.contextPath}/servlet/allocate?page=next&pageNum=${page.pageNum}">下一页</a>
						&nbsp;
					 </c:if>
					
					 	<a href="${pageContext.request.contextPath}/servlet/allocate?page=lastpage&pageNum=${ page.totalPageCount }">尾页</a>
						&nbsp;&nbsp;当前第${page.pageNum }页，共${page.totalPageCount }页
					 
					 
					 
					
				</div>
		
		<div>
		
		</div>
	
</body>
</html>