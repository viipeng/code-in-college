<%@ page language="java" import="java.util.*"  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Download_list.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
	body{background-image:url(009.jpg);}
	h1{font-family:楷体;font-size:30px;color:black;}
	</style>
  </head>
  
  <body>
  <form action = "Download_list" method="post">  
  
  <div style="width: 800px;height:670px;background:
#CCEEFF; filter:alpha(opacity:30); opacity:0.85;  -moz-opacity:0.3;-khtml-opacity: 0.3">
   <table width="600" border="1" cellspacing="0" align="center" cellpadding="5px" cellspacing="5px" bordercolor="#E8CCFF">
   <caption><h1>小说排行榜</h1></caption>
  <tr>
  <td>小说</td>
  <td>作者</td>
  <td>下载量</td>
  </tr>
   <c:forEach items="${list }" var="cs">
            <tr>
                <td>${cs.noname }</td>
                <td>${cs.auname }</td>
                <td>${cs.amount }</td>
            </tr>
        </c:forEach>
  </table>
</form>
  </body>
</html>
