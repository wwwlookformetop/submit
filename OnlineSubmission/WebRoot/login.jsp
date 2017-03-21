<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>注册页面</title>
  </head>
  
 <center>
    <form name=form method=post action="${pageContext.request.contextPath }/servlet/loginServlet">
        <table>
            <tr>
                <td colspan=2>登录界面</td>  
            </tr>
            <tr>
                <td>用户qq:</td>
                <td><input type=text name=id size=16></td>
            </tr>
            <tr>
                <td>密码:</td>
                <td><input type=password  name=password size=16></td>
            </tr>
            <tr>
             
                <td colspan=2><input type=submit value="登录"></a></td>
            </tr>
        </table>
    </form>
    </center>
</html>
