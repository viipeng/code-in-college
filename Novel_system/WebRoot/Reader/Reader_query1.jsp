<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Reader_query1.jsp' starting page</title>
    
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
  
  <form action = "Reader_query" method="post">  
   <%  
  String rename = (String)request.getAttribute("rename");
  String sex = (String)request.getAttribute("sex"); 
  String age = (String)request.getAttribute("age"); 
  String password = (String)request.getAttribute("password"); 
%>
		<ul>
		<li><%=rename %></li>
		<li><%=sex %></li>
		<li><%=age %></li>
		<li><%=password %></li>
		</ul>
		<input type = "button" value = "返  回" onclick="window.location.href='Reader/Reader_query.jsp'"/>
		</form>
		</center>
  </body>
</html>
