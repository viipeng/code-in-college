<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Novel_delete.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
   body{background-image:url(009.jpg);
   </style>  
  </head>
  
  <body><center>
  <form action = "Novel_delete" method="post"> 
  <p>小说名：<input type="text" name="noname" maxlength = "10"></p>
        <input type="submit" name="submit" value="删   除" />
        <input type = "button" value = "返  回" onclick="window.location.href='bottom.jsp'"/>
  </form>
  </center>
  </body>
</html>
