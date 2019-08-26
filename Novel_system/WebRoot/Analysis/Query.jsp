<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Query.jsp' starting page</title>
    
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
  
  <body>
   <form action = "Analysis" method="post"><center>
		<p>你希望看见的属性:</p>
		<p>属性一：<input type="text" name="result1" maxlength = "20"></p>
		<p>属性二：<input type="text" name="result2" maxlength = "20"></p>
		<p>属性三：<input type="text" name="result3" maxlength = "20"></p>
		<p>属性四：<input type="text" name="result4" maxlength = "20"></p>
		<p>条件一：<input type="text" name="condition1" maxlength = "20"></p>
		<p>条件二：<input type="text" name="condition2" maxlength = "20"></p>
		<p>条件三：<input type="text" name="condition3" maxlength = "20"></p>
		<p>条件四：<input type="text" name="condition4" maxlength = "20"></p>
		<p>条件五：<input type="text" name="condition5" maxlength = "20"></p>
		<p>条件六：<input type="text" name="condition6" maxlength = "20"></p>
        <input type="submit" name="submit" value="查   询" /><!-- onclick="window.location.href=''" -->  
        <input type = "button" value = "返   回" onclick="window.location.href='bottom.jsp'"/>
        </center>
	</form>
  </body>
</html>
