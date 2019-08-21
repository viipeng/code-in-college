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
<!-- <title>Home</title> -->
<!-- for-mobile-apps -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false);
		function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- //for-mobile-apps -->
<link href="../jsp/css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
<link href="../jsp/css/style.css" rel="stylesheet" type="text/css" media="all" />
<link href="../jsp/css/addition.css" rel="stylesheet" type="text/css" media="all" />
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
	$(function(){
	});
	/*用户信息*/
	/* function myselfinfo(){
		layer.open({
			type: 1,
			area: ['300px','200px'],
			fix: false, //不固定
			maxmin: true,
			shade:0.4,
			title: '查看用户信息',
			content: '<div ><table class="table table-border table-bordered table-hover table-bg table-sort"> <tr class="text-c"><td width="70">姓名</td><td width="50">性别</td><td width="60">账户余额</td></tr> <tr class="text-c"><td width="70">${user.username }</td><td width="50">${user.usex }</td><td width="60">${user.account_balance }</td></tr> </table> </div>'
		});
	} */
</script>
<!-- start-smoth-scrolling -->
</head>
  
  <body>
    <!-- header -->
	<div class="agileits_header">
		<div class="container">
			<div class="w3l_offers">
				<p>WELCOME TO "KNOW TASTE". </p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<c:choose>
					<c:when test="${sessionScope.uid==null && sessionScope.rid==null }">
						<a href="../home/bossLogin" class="act">管理员登录</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<a href="../home/merchantLogin" class="act">商家登录</a>
					</c:when>
				</c:choose>
			</div>
			<div class="header-right" >
				<ul>
					<c:choose>
						<c:when test="${sessionScope.uid!=null }">
							<li class="active">
								<a href="../orderInfo/getOrder" class="act">我的订单</a>
								<div class="user_info" style="1px solid blue;">
									<div class="login_user_info" style="">
										<ul class="login_info">
											<li class="uname mn-lk-w">
												<a class="mn-lk" href="javascript:;">欢迎登录！</a>
												<div class="mn-tip">
													<div class="top-arrow"></div>
													<ul class="mn">
														<li><a class="my-info" href="../userInfo/jumpToAddMoney">充值</a></li>
														<li><a id="queryAccount-user" class="my-info" href="javascript:void(0)">账户余额</a></li>
														<li><a class="my-info" href="../userInfo/jumpToChangePassword">修改密码</a></li>
														<li><a class="logout" href="../home/logout">退出</a></li>
													</ul>
												</div>
											</li>
										</ul>
									</div>
								</div>
							</li>
						</c:when>
						<%-- <c:when test="${sessionScope.rid!=null }">
							<li class="active">
								<a href="#" class="act">收益</a>
								<div class="user_info" style="1px solid blue;">
									<div class="login_user_info" style="">
										<ul class="login_info">
											<li class="uname mn-lk-w">
												<a class="mn-lk" href="javascript:;">欢迎登录！</a>
												<div class="mn-tip">
													<div class="top-arrow"></div>
													<ul class="mn">
														<li><a class="my-info" href="#">修改密码</a></li>
														<li><a class="logout" href="../home/merchantLogout">退出</a></li>
													</ul>
												</div>
											</li>
										</ul>
									</div>
								</div>
							</li>
						</c:when> --%>
						<c:otherwise>
							<li class="active"><a href="../home/login" class="act">我的订单</a></li>
							<li><a href="../home/register"> 注   册 </a></li>
							<li><a href="../home/login"> 登录 </a></li>
						</c:otherwise>
					</c:choose>
				</ul>
			</div>
		</div>
				<%-- <div class="product_list_header">  
				<c:choose>
					<c:when test="${sessionScope.uid!=null }">
						<form action="../shopping_trolleyInfoAdd/getShopping_trolleyInfo" method="post" class="last"> 
							<!-- <input type="hidden" name="cmd" value="_cart">
							<input type="hidden" name="display" value="1"> -->
							<!-- <a href="../shopping_trolleyInfoAdd/getShopping_trolleyInfo"> -->
							<button class="w3view-cart" type="submit" name="submit" value="">
								<i class="fa fa-cart-arrow-down" aria-hidden="true"></i></button><!-- </a> -->
						</form>
					</c:when>
					<c:otherwise>
						<a href="../home/login"><button class="w3view-cart" type="submit" name="submit" value="">
								<i class="fa fa-cart-arrow-down" aria-hidden="true"></i></button></a>
					</c:otherwise>
				</c:choose>
				</div> --%>
			<div class="clearfix"> </div>
		</div>

	<div class="logo_products">
		<div class="container">
		<div class="w3ls_logo_products_left1">
				<ul class="phone_email">
					<li><i class="fa fa-phone" aria-hidden="true"></i>Order online or call us : (+0123) 234 567</li>
					
				</ul>
			</div>
			<div class="w3ls_logo_products_left">
				<h1><a href="../home/visit">知味</a></h1>
			</div>
		<div class="w3l_search">
			<form action="../home/searchRestaurant" method="post">
				<input type="search" name="name" placeholder="请输入商家或商家名称" required="required">
				<button type="submit" class="btn btn-default search" aria-label="Left Align">
					<i class="fa fa-search" aria-hidden="true"> </i>
				</button>
				<div class="clearfix"></div>
			</form>
		</div>
			
			<div class="clearfix"> </div>
		</div>
	</div>
<!-- //header -->
<!-- navigation -->
	<div class="navigation-agileits">
		<div class="container">
			<nav class="navbar navbar-default">
							<!-- Brand and toggle get grouped for better mobile display -->
							<div class="navbar-header nav_2">
								<button type="button" class="navbar-toggle collapsed navbar-toggle1" data-toggle="collapse" data-target="#bs-megadropdown-tabs">
									<span class="sr-only">Toggle navigation</span>
									<span class="icon-bar"></span>
									<span class="icon-bar"></span>
									<span class="icon-bar"></span>
								</button>
							</div> 
							<div class="collapse navbar-collapse" id="bs-megadropdown-tabs">
								<ul class="nav navbar-nav">
									<li class="active"><a href="../home/visit" class="act">主页</a></li>
									<%-- <c:choose>
										<c:when test="${sessionScope.uid!=null }">
											<li class="active"><a href="../orderInfo/getOrder" class="act">我的订单</a></li>	
										</c:when>
										<c:otherwise>
											<li class="active"><a href="../home/login" class="act">我的订单</a></li>	
										</c:otherwise>
									</c:choose> --%>
									<!-- Mega Menu -->
									<!-- <li class="dropdown">
										<a href="#" class="dropdown-toggle" data-toggle="dropdown">Household<b class="caret"></b></a>
										<ul class="dropdown-menu multi-column columns-3">
											<div class="row">
												<div class="multi-gd-img">
													<ul class="multi-column-dropdown">
														<h6>All Household</h6>
														<li><a href="household.html">Cookware</a></li>
														<li><a href="household.html">Dust Pans</a></li>
														<li><a href="household.html">Scrubbers</a></li>
														<li><a href="household.html">Dust Cloth</a></li>
														<li><a href="household.html"> Mops </a></li>
														<li><a href="household.html">Kitchenware</a></li>
													</ul>
												</div>
											</div>
										</ul>
									</li> -->
									<!-- <li><a href="gourmet.html">Gourmet</a></li>
									<li><a href="offers.html">Offers</a></li>
									<li><a href="contact.html">Contact</a></li> -->
								</ul>
							</div>
							</nav>
			</div>
		</div>
		
<!-- //navigation -->
<script>
	$("#queryAccount-user").click(function(){
		$.get("../userInfo/queryAccount", function(data, status){
			alert("账户余额为："+data+"元");
		});
	});
</script>
  </body>
</html>
