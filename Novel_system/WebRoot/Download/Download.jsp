<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Download.jsp' starting page</title>
    
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
 <input type = "button" value = "增加下载列表信息" onclick="window.location.href='Download_add.jsp'"/><br />
  <input type = "button" value = "删除下载列表信息" onclick="window.location.href='Download_delete.jsp'"/><br />
  <input type = "button" value = "查询下载列表信息" onclick="window.location.href='Download_query.jsp'"/><br />
  <input type = "button" value = "返  回" onclick="window.location.href='../Function_selection_page.jsp'"/> 
  </center>
   </body>
</html>
