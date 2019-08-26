<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Author_add.jsp' starting page</title>
    
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
            var auname=document.getElementById("auname").value;  
            var sex=document.getElementById("sex").value;  
            var age=document.getElementById("age").value;  
            if(auname==""){  
                alert("作者名不能为空!");  
                document.getElementById("auname").focus();    
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
        }  
        function validate(){  
            var flag = addCheck();  
            if(flag == false)  

                return false;  
            return true;  
        }  
    </script>
    <style type="text/css">
   body{background-image:url(009.jpg);
   </style>   
  </head>
  
  <body>
    <form action = "Author_add" method = "post" onsubmit = "return validate()">  <!-- onsubmit = "return validate()" -->
    <center><table width="300" height = "180" border="5" bordercolor="#A0A0A0">  
      <tr>  
        <th>作者名：</th>  
        <td><input type="text" name="auname" value="输入16个字符以内" maxlength = "16" onfocus = "if(this.value == '输入16个字符以内') this.value =''"></td>  
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
        <td colspan = "2" align = "center">  
          <input type="submit" value="添    加">  
          <input type = "button" value = "返  回" onclick="window.location.href='bottom.jsp'"/>   
        </td>  
      </tr>  
    </table>
    </center>  
    </form>  
  </body>
</html>
