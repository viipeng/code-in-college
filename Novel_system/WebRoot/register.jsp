<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
response.setContentType("text/html;charset=UTF-8");
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'register.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script>  
        function addCheck(){  
            var username=document.getElementById("username").value;  
            var password=document.getElementById("password").value;  
            var newword=document.getElementById("newword").value;  
            var sex=document.getElementById("sex").value;  
            var age=document.getElementById("age").value;  
            if(username==""){  /* ||sex==""||age==""||password==""||password != newword */
                alert("用户名不能为空!");  
                document.getElementById("username").focus();    
                return false;  
                }    
             if(sex==""||sex!='男'&&sex!='女'){  
                alert("性别不能为空或填写错误!");  
                 document.getElementById("sex").focus();  
                 return false;  
                 }    
            if(age==""){  
                alert("年龄不能为空!");  
                 document.getElementById("age").focus();  
                 return false;  
                 }  
            if(password==""){  
                alert("密码不能为空!");  
                 document.getElementById("password").focus();  
                 return false;  
                 }  
            if(password != newword){  
                alert("两次输入密码不相同!");  
                 document.getElementById("newword").focus();  
                 return false;  
                 }   
        }  
        function validate(){  
            var flag = addCheck();  
            if(flag == false)  

                return false;  
            return true;  
        }  
    </script>  
    <style type="text/css">
	body{background-image:url(010.jpg);}
	</style>   
  </head>
  
  <body>
  <center>  
    <font face="楷体" size="6" color="#000">注册界面</font>  
    <form action = "register" method = "post" onsubmit = "return validate()">  <!-- onsubmit = "return validate()" -->
    <table width="300" height = "180" border="5" bordercolor="#A0A0A0">  
      <tr>  
        <th>用户名：</th>  
        <td><input type="text" name="username" value="输入16个字符以内" maxlength = "16" onfocus = "if(this.value == '输入16个字符以内') this.value =''"></td>  
      </tr>  
      <tr>  
        <th>性别：</th>  
        <td><input type="text" name="sex" value="男或女" maxlength = "16" onfocus = "if(this.value == '男或女') this.value =''"></td>  
      </tr> 
      <tr>  
        <th>年龄：</th>  
        <td><input type="text" name="age" value="输入3个字符以内" maxlength = "16" onfocus = "if(this.value == '输入3个字符以内') this.value =''"></td>  
      </tr> 
      <tr>  
        <th>输入密码：</th>  
        <td><input type="text" name="password" value="输入20个字符以内" maxlength = "20" onfocus = "if(this.value == '输入20个字符以内') this.value =''"></td>  
      </tr>  
      <tr>  
        <th>确认密码：</th>  
        <td><input type="text" name="newword" value="重新输入密码" maxlength = "20" onfocus = "if(this.value == '重新输入密码') this.value =''"></td>  
      </tr>  
      <tr>  
        <td colspan = "2" align = "center">  
          <input type="submit" value="注  册">      
          <input type="reset" value="重  置">  
          <input type="button" value="登  录" onclick="window.location.href='index.jsp'"/>  
        </td>  
      </tr>  
    </table>  
    </form>  
    </center>  
    </body>
</html>
