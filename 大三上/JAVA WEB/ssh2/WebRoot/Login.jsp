<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>SSH用户登录</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
  </head>
  
  <body>
    <center>
     <h3>用户登录</h3>
     <form action="userinfo/login">
       <table>
          <tr>
           <td>用户名</td>
           <td><input name="userName"/></td>
          </tr>
           <tr>
           <td>密 码</td>
           <td><input name="password"/></td>
          </tr>
          <tr>
           <td><input type="submit" value=" 登 录 " /></td>
          </tr>
       </table>
     </form>
    </center>
  </body>
</html>
