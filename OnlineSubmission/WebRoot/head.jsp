<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  
  <body>
       
        <c:if test ="${name!=null }">
                当前用户为：${name}&nbsp;&nbsp;
        <a href="/OnlineSubmission/servlet/QuitServlet"><input type="button" name ="注销" value ="注销">
        </c:if>
       
        <c:if test ="${name==null }">
        </a>&nbsp;&nbsp;<a href="/OnlineSubmission/login.jsp"><input type="button" name ="登录" value ="登录"></a>&nbsp;&nbsp;<a href="/OnlineSubmission/register.jsp" ><input type="button" name ="注册" value ="注册"></a>
        </c:if>
       
        </body>
</html>
