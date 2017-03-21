<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>注册页面</title>
  </head>
  
 <center>
    <form name=form method=post action="${pageContext.request.contextPath }/servlet/update">
        <table>
            <tr>
                <td colspan=2>修改个人信息界面</td>  
            </tr>
              <tr>
                <td>用户qq:</td>
                <td><input type=text  name=qq size=16 value="${name }"></td>
            </tr>
            <tr>
                <td>用户:</td>
                <td><input type=text name=username size=16></td>
            </tr>
            <tr>
                <td>密码:</td>
                <td><input type=password  name=password size=16 value="${password }"></td>
            </tr>
              <tr>
                <td>电话:</td>
                <td><input type=text  name=phone size=16></td>
            </tr>
            <tr>
                <td>地址:</td>
                <td><input type=text  name=address size=16></td>
            </tr>
            <tr>
                <td>支付宝号:</td>
                <td><input type=text  name=money size=16></td>
            </tr>
            <tr>
                <td>email:</td>
                <td><input type=text  name=email size=16></td>
            </tr>
            <tr>
             
                <td colspan=2><input type=submit value="修改"></a></td>
            </tr>
        </table>
    </form>
    </center>
</html>
