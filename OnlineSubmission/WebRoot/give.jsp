<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

  <center>
  <body>
       支付页面
  <form name="uploadForm" method="POST" 
       
        action="/OnlineSubmission/servlet/give"> 
       支付宝号： <input type="text" name="title" size="30"/><br><br><br>
       稿费： <input type="text" name="money" size="30" value="${message }"/><br><br><br>
       支付密码： <input type="text" name="title" size="30"/><br><br><br>
        <input type="submit" name="submit" value="提交"> 
       </form>
  </body>
  </center>
</html>
