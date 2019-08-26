<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Download_add.jsp' starting page</title>
    
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
            var rename=document.getElementById("rename").value;   
            if(noname==""){  
                alert("小说名不能为空!");  
                document.getElementById("noname").focus();    
                return false;  
                }    
            if(rename==""){  
                alert("读者名不能为空!");  
                 document.getElementById("rename").focus();  
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
     <form action = "Download_add" method = "post" onsubmit = "return validate()">  <!-- onsubmit = "return validate()" -->
    <table width="300" height = "180" border="5" bordercolor="#A0A0A0">  
      <tr>  
        <th>小说名：</th>  
        <td><input type="text" name="noname" value="输入16个字符以内" maxlength = "16" onfocus = "if(this.value == '输入16个字符以内') this.value =''"></td>  
      </tr>  
      <tr>  
        <th>读者名：</th>  
        <td><input type="text" name="rename" value="输入5个字符以内" maxlength = "20" onfocus = "if(this.value == '输入5个字符以内') this.value =''"></td>  
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
