<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Reader_query.jsp' starting page</title>
    
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
  <form action = "Reader_Reader_query" method="post"> 
		
		<p>读者姓名：<input type="text" name="name" maxlength = "10"></p>
        <input type="submit" name="submit" value="查  询 " /><!-- onclick="window.location.href=''" -->  
        <input type = "button" value = "返  回" onclick="window.location.href='../Reader_Function.jsp'"/>

	</form>
	</center>
  </body>
</html>
