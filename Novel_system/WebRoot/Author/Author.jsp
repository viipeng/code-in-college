<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Author.jsp' starting page</title>
    
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
    <input type = "button" value = "增加作者信息" onclick="window.location.href='Author_add.jsp'"/><br />
  <input type = "button" value = "删除作者信息" onclick="window.location.href='Author_delete.jsp'"/><br />
  <input type = "button" value = "更新作者信息" onclick="window.location.href='Author_change.jsp'"/><br />
  <input type = "button" value = "查询作者信息" onclick="window.location.href='Author_query.jsp'"/><br />
  <input type = "button" value = "返  回" onclick="window.location.href='../Function_selection_page.jsp'"/>
  </center>
  </body>
</html>
