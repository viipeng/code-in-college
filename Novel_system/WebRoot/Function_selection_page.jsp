<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Function_selection_page.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link href="css/style.css" rel="stylesheet" type="text/css">
  <style type="text/css"> 
body{ font-family: arial, 宋体, serif; font-size:24px;background:url(003.jpg) no-repeat;
}

#nav{line-height: 40px;  list-style-type: none;margin:0px 100px;} 
 
#nav a{display: block; width: 140px; text-align:center;} 
 
#nav a:link {color:#C00;; text-decoration:none} 
#nav a:visited {color:#C00;;text-decoration:none} 
#nav a:hover {color:#FF0;text-decoration:none;font-weight:bold} 
 
#nav li{float: left; width: 180px; background:#FFFFBB} 
#nav li a:hover{ background:#AAAAAA;color:#FFFFBB} 
#nav li ul{line-height: 40px;  list-style-type: none;text-align:left;left: -999em; width: 180px; position: absolute} 
#nav li ul li{float: left; width: 160px;background:#EEFFBB;color:#FFFFBB} 
 #nav li ul li a{float: left; width: 160px;background:#EEFFBB} 
 
#nav li ul a{display: block; width: 156px;text-align:left;padding-left:50px; overflow:hidden} 
 
#nav li ul a:link {color:#C00; text-decoration:none} 
#nav li ul a:visited {color:#C00;;text-decoration:none} 
#nav li ul a:hover {color:#FF0;text-decoration:none;font-weight:normal;background:#C00} 
 
#nav li:hover ul{left: auto} 
#nav li.sfhover ul{left: auto} 
#content{clear: left} 
</style> 
 
 

<script type=text/javascript> 
 window.onload = function(){
    var obj_select = document.getElementById("test_select");
    var obj_div = document.getElementById("test");
    obj_select.onchange = function(){
        obj_div.style.display = this.value==1? "block" : "none";
    }
}
</script> 
  </head>
  
  <body>
  <div>
<ul id="nav"> 
<li><a>读者</a>
<ul> 
    <li><a href="Reader/Reader_add.jsp?type=all" target="main">增加读者信息</a></li> 
    <li><a href="Reader/Reader_delete.jsp?type=all" target="main">删除读者信息</a></li>
    <li><a href="Reader/Reader_change.jsp?type=all" target="main">修改读者信息</a></li>
    <li><a href="Reader/Reader_query.jsp?type=all" target="main">查询读者信息</a></li> 
    </ul> 
    </li>

<li><a>作者</a>
    <ul> 
    <li><a href="Author/Author_add.jsp?type=all" target="main">增加作者信息</a></li> 
    <li><a href="Author/Author_delete.jsp?type=all" target="main">删除作者信息</a></li>
    <li><a href="Author/Author_change.jsp?type=all" target="main">修改作者信息</a></li>    
	<li><a href="Author/Author_query.jsp?type=all" target="main">查询作者信息</a></li> 
    </ul> 
    </li> 

<li><a>小说</a>
	<ul> 
    <li><a href="Novel/Novel_add.jsp?type=all" target="main">增加小说信息</a></li> 
    <li><a href="Novel/Novel_delete.jsp?type=all" target="main">删除小说信息</a></li>
<!--     <li><a href="alter2.jsp?type=down" target="main">修改小说信息</a></li> -->
    <li><a href="Novel/Novel_query.jsp?type=all" target="main">查询小说信息</a></li> 
    </ul> 
    </li> 
    

<li><a>下载列表</a>
<ul> 
    <li><a href="Download/Download_add.jsp?type=all" target="main">增加下载信息</a></li> 
    <li><a href="Download/Download_delete.jsp?type=all" target="main">删除下载信息</a></li>
<!--     <li><a href="alter1.jsp?type=all" target="main">修改小说</a></li>-->    
	<li><a href="Download/Download_query.jsp?type=all" target="main">查询下载信息</a></li> 
    </ul> 
</li> 
<li><a href="start_download_list.jsp?type=all" target="main">下载排行榜</a></li> 
<li><a href="Analysis/Query.jsp?type=all" target="main">数据分析</a></li>

</li> 
</ul> 
</div>
    </form>
 
 <!--  <input type = "button" value = "读者" onclick="window.location.href='Reader/Reader.jsp'"/><br />
  <input type = "button" value = "作者" onclick="window.location.href='Author/Author.jsp'"/><br />
  <input type = "button" value = "小说"  onclick="window.location.href='Novel/Novel.jsp'"/><br />
  <input type = "button" value = "下载列表"  onclick="window.location.href='Download/Download.jsp'"/><br />
  <input type = "button" value = "数据分析"  onclick="window.location.href='Analysis/Query.jsp'"/><br /> 
  <input type = "submit" value = "下载排行榜"/><br />
  <input type = "button" value = "返回登录页面" onclick="window.location.href='index.jsp'"/>-->

  </body>
  </noframes>
</html>
