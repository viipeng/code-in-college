<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Reader.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  <input type = "button" value = "增加读者信息" onclick="window.location.href='Reader_add.jsp'"/><br />
  <input type = "button" value = "删除读者信息" onclick="window.location.href='Reader_delete.jsp'"/><br />
  <input type = "button" value = "更新读者信息" onclick="window.location.href='Reader_change.jsp'"/><br />
  <input type = "button" value = "查询读者信息" onclick="window.location.href='Reader_query.jsp'"/><br />
  <input type = "button" value = "返  回" onclick="window.location.href='../Function_selection_page.jsp'"/>
  </body>
</html>
