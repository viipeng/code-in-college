<%@ page language="java" import="java.util.*,javax.swing.JOptionPane" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
response.setContentType("text/html;charset=UTF-8");
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
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
	</style>
  </head>
  
  <body>
  <center>  
    <font face="楷体" size="6" color="#000" >登录界面</font>  
    <%    
    String flag = request.getParameter("errNo");    
    try{  
    if(flag!=null)  
         JOptionPane.showMessageDialog(null, "账号错误或密码错误", "出错啦", JOptionPane.ERROR_MESSAGE);
    }catch(Exception e){  
        e.printStackTrace();  
    }  
   %>  
    <form action = "login" method="post">  
      <table width="300" height = "180" border="5" bordercolor="#A0A0A0">   
        <tr>  
          <th>账  户：</th>  
          <td><input type="text" name="name"  value = "请输入用户名" maxlength = "16" onfocus = "if(this.value == '请输入用户名') this.value =''"></td>  
        </tr>  
        <tr>  
          <th>密  码：</th>  
          <td><input type="password" name="pwd" maxlength = "20"></td>  
        </tr>  
        <tr>  
          <td colspan = "2" align = "center">  
            <input type="submit" name="submit" value="登       录">  
            <input type="button" value="注      册"  
              onclick="window.location.href='register.jsp'"/>  
          </td>  
        </tr>  
      </table>  
    </form>  
  </center>  
  </body>
</html>
