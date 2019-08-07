<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>
<title>Home</title>
<!-- for-mobile-apps -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false);
		function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- //for-mobile-apps -->
<link href="../jsp/css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
<link href="../jsp/css/style.css" rel="stylesheet" type="text/css" media="all" />
<!-- font-awesome icons -->
<link href="../jsp/css/font-awesome.css" rel="stylesheet"> 
<!-- //font-awesome icons -->
<!-- js -->
<script src="../jsp/js/jquery-1.11.1.min.js"></script>
<!-- //js -->
<link href='http://fonts.googleapis.com/css?family=Raleway:400,100,100italic,200,200italic,300,400italic,500,500italic,600,600italic,700,700italic,800,800italic,900,900italic' rel='stylesheet' type='text/css'>
<link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,300italic,400italic,600,600italic,700,700italic,800,800italic' rel='stylesheet' type='text/css'>
<!-- start-smoth-scrolling -->
<script type="text/javascript" src="../jsp/js/move-top.js"></script>
<script type="text/javascript" src="../jsp/js/easing.js"></script>
<script type="text/javascript">
	jQuery(document).ready(function($) {
		$(".scroll").click(function(event){		
			event.preventDefault();
			$('html,body').animate({scrollTop:$(this.hash).offset().top},1000);
		});
	});
</script>
<!-- start-smoth-scrolling -->
</head>
  
  <body>
    <div class="footer">
		<div class="container">
			<div class="w3_footer_grids">
				<div class="col-md-3 w3_footer_grid">
					<h3>联系</h3>
					
					<ul class="address">
						<li><i class="glyphicon glyphicon-map-marker" aria-hidden="true"></i>华东交通大学 </li>
						<li><i class="glyphicon glyphicon-envelope" aria-hidden="true"></i><a href="mailto:info@example.com">info@example.com</a></li>
						<li><i class="glyphicon glyphicon-earphone" aria-hidden="true"></i>+1234 567 567</li>
					</ul>
				</div>
				<div class="col-md-3 w3_footer_grid">
					<h3>信息</h3>
					<ul class="info"> 
						<li><i class="fa fa-arrow-right" aria-hidden="true"></i><a href="javascript:void(0)">关于我们</a></li>
						<li><i class="fa fa-arrow-right" aria-hidden="true"></i><a href="javascript:void(0)">联系我们</a></li>
						<li><i class="fa fa-arrow-right" aria-hidden="true"></i><a href="javascript:void(0)">常见问题</a></li>
					</ul>
				</div>
				<div class="col-md-3 w3_footer_grid">
					<h3>餐馆</h3>
					<ul class="info"> 
						<li><i class="fa fa-arrow-right" aria-hidden="true"></i><a href="../restaurantInfo/visitRestaurantByRid?rid=1">华莱士（机电店）</a></li>
						<li><i class="fa fa-arrow-right" aria-hidden="true"></i><a href="../restaurantInfo/visitRestaurantByRid?rid=2">绝味鸭脖（南昌财大店）</a></li>
						<li><i class="fa fa-arrow-right" aria-hidden="true"></i><a href="../restaurantInfo/visitRestaurantByRid?rid=3">资溪面包奶茶</a></li>
						<li><i class="fa fa-arrow-right" aria-hidden="true"></i><a href="../restaurantInfo/visitRestaurantByRid?rid=4">旺客基黄焖鸡米饭</a></li>
					</ul>
				</div>
				<div class="col-md-3 w3_footer_grid">
					<h3>简介</h3>
					<ul class="info"> 
						<li><i class="fa fa-arrow-right" aria-hidden="true"></i><a href="../home/bossLogin">管理员登录</a></li>
						<li><i class="fa fa-arrow-right" aria-hidden="true"></i><a href="../home/merchantLogin">商家登录</a></li>
						<li><i class="fa fa-arrow-right" aria-hidden="true"></i><a href="../home/login">登录</a></li>
						<li><i class="fa fa-arrow-right" aria-hidden="true"></i><a href="../home/register">注册</a></li>
					</ul>
				</div>
				<div class="clearfix"> </div>
			</div>
		</div>
		
		<!-- <div class="footer-copy">
			
			<div class="container">
				<p>Copyright &copy; 2017.Company name All rights reserved.More Templates <a href="http://www.cssmoban.com/" target="_blank" title="模板之家">模板之家</a> - Collect from <a href="http://www.cssmoban.com/" title="网页模板" target="_blank">网页模板</a></p>
			</div>
		</div> -->
		
	</div>	
	
  </body>
</html>
