<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Novel_add.jsp' starting page</title>
    
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
            var noname=document.getElementById("noname").value;  
            var auname=document.getElementById("auname").value;  
            var start_time=document.getElementById("start_time").value;  
            var finish_time=document.getElementById("finish_time").value;  
            if(noname==""){  
                alert("小说名不能为空!");  
                document.getElementById("noname").focus();    
                return false;  
                }    
             if(start_time==""){  
                alert("开始日期不能为空!");  
                 document.getElementById("start_time").focus();  
                 return false;  
                 }    
            if(finish_time==""){  
                alert("结束日期不能为空!");  
                 document.getElementById("finish_time").focus();  
                 return false;  
                 }  
            if(auname==""){  
                alert("作者名不能为空!");  
                 document.getElementById("auname").focus();  
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
  
  <body><center>
  <form action = "Novel_add" method = "post" onsubmit = "return validate()">  <!-- onsubmit = "return validate()" -->
    <table width="300" height = "180" border="5" bordercolor="#A0A0A0">  
      <tr>  
        <th>小说名：</th>  
        <td><input type="text" name="noname" value="输入16个字符以内" maxlength = "16" onfocus = "if(this.value == '输入16个字符以内') this.value =''"></td>  
      </tr>  
      <tr>  
        <th>开始日期：</th>  
        <td><input type="text" name="start_time" value="格式：2006.1.5" maxlength = "16" onfocus = "if(this.value == '格式：2006.1.5') this.value =''"></td>  
      </tr> 
      <tr>  
        <th>结束日期：</th>  
        <td><input type="text" name="finish_time" value="格式：2007.5.1" maxlength = "16" onfocus = "if(this.value == '格式：2007.5.1') this.value =''"></td>  
      </tr> 
      <tr>  
        <th>作者名：</th>  
        <td><input type="text" name="auname" value="输入5个字符以内" maxlength = "20" onfocus = "if(this.value == '输入5个字符以内') this.value =''"></td>  
      </tr>  
      <tr>  
        <td colspan = "2" align = "center">  
          <input type="submit" value="添    加">  
          <input type = "button" value = "返  回" onclick="window.location.href='bottom.jsp'"/>   
        </td>  
      </tr>  
    </table>  
    </form>
    </center>  
  </body>
</html>
