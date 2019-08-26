<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Novel_query1.jsp' starting page</title>
    
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
  <form action = "Novel_query" method="post"> 
    <%  
  String noname = (String)request.getAttribute("noname");
  String start_time = (String)request.getAttribute("start_time"); 
  String finish_time = (String)request.getAttribute("finish_time"); 
  String auname = (String)request.getAttribute("auname"); 
%>
		<ul>
		<li><%=noname %></li>
		<li><%=start_time %></li>
		<li><%=finish_time %></li>
		<li><%=auname %></li>
		</ul>
		<input type = "button" value = "返  回" onclick="window.location.href='Novel/Novel_query.jsp'"/>
		</form>
		</center>
  </body>
</html>
