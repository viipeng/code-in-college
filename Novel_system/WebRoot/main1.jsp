<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>主界面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
    <frameset rows="170,*">
    <frame src="Reader_Function.jsp" scrolling="no"/>
    <frameset cols="200,*">
    <frame src="left.jsp" name="left" scrolling="no"/>
    <frame src="bottom.jsp" name="main1" scrolling="no">
    </frameset>
    </frameset>
    </frameset>
    <noframes>
    <body> 
    <a href="index.jsp" >返回登录页面</a>
    </body>
    </noframes>
</html>

