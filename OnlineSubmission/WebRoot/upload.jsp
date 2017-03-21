<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
 <script type="text/javascript">


 </script>
<center>  
  <body>
   <form name="uploadForm" method="POST" 
        enctype="multipart/form-data" 
        action="/OnlineSubmission/servlet/upload"> 
                文章的标题: <input type="text" name="title" size="30"/><br><br><br>
                文章摘要： <input type="text" name="abstarct" size="30"/><br><br><br>
                文章类型：<select name="select" id="select_k1" class="xla_k">
                  <option value="科学类">科学类</option>
                  <option value="专业类">专业类</option>
				  <option value="科普类">科普类</option>
         </select><br><br>
                文章长度：<input type="text" name="length" size="30" /><br>
                上传时间：<input type="text" name="time" size="30"/><br><br>
              
                 投稿者qq：<input type="text" name="qq" size="30"/><br><br>
                 稿件上传: <input type="file" name="file1" size="30"/><br><br><br>
        <input type="submit" name="submit" value="提交"> 
        <input type="reset" name="reset" value="重置"> 
     </form>
  </body>
  </center>
</html>
