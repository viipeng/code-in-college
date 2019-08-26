<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
response.setContentType("text/html;charset=UTF-8");
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  <link href="css/style.css" rel="stylesheet" type="text/css">
  <style type="text/css">
  body{background:url(010.jpg);color:#666; font-family:Verdana, Geneva,sans-serif}
  a{ text-decoration:none; color:#666;}
  a:hover{ color:#F30}
  div,ul,li{margin:0}
  #top{width:100%;height:160px;background:url(010.jpg);nargin:0 auto}
  #logo{width:80px; height:25px; position:relative; left:30px; top:10px;}
  #m1{widtg:900px;height:190px;margin:0 auto;border-bottom:#999 1px dashed}
  #m1-left{width:460px;height:190px;background:#FFF;float:right;line-height:1.5;padding:20px;background:url(010.jpg);}
  .p1{float:left;margin-right:20px;}
  h{color:yellow;}
  .fr{float:right;color:#666}
  #foot{width:100%;height:60px;background:#60f;margin:0auto;color:#FFF;padding:30px 0px;text-align:center;float:left;}
 </style>
 </head>
  
  <body>
  <div id="top">
  <div id="logo"><img src="011.png" width="190" height="130"></div></div>
   <div id="m1">
   <div id="m1-left">
   <embed src="012.mp4" autostart="true" loop="true" width="450" height="190" type="video/mp4"></embed>
   </div>
   <div id="m1-rignt" >
   <img class="p1" src="007.jpg" width="300" height="170"/><h>袁凌写一些被遗忘的，不同于常的人生轨迹。每每落笔，始终与土地紧紧贴合，他的文本直指深渊，似跌入一个不可逆的空间，耳畔不时传来残喘的呼吸，深陷其中，却对这些将死的生命，束手无策。
曾有近两年的时间，袁凌极少进城。他住在北京五环外的天通苑，禁锢的空间，聚集近70万人口，尘土飞扬，乱七八糟。工作日的清晨，人们以此为点，迅速涌进城中的办公区，寻求生计。
这是“北漂”袁凌，所习惯的生存境况。
他可以躲藏其中，静观城市在这里留存下的缩影：人们缄默、悲苦、俭省、奋斗，各自飘零。每一个自地面长出的故事，都撕扯着异乡者分裂的伤痕，与他所写的底层题材，在气质上，默契相合。
   </h></div>
   </div>
   
   <div id="foot">Copyright@2006-2017华东交通大学软件八班6组. All Rights Reserved 赣 ICP 备 10005041 号</div>
   
  </body> 
    
</html>
