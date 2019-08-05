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
						<c:when test="${sessionScope.rid!=null }">
							<li class="active">
								<div class="user_info" style="1px solid blue;">
									<div class="login_user_info" style="">
										<ul class="login_info">
											<li class="uname mn-lk-w">
												<a class="mn-lk" href="javascript:;">欢迎登录！</a>
												<div class="mn-tip">
													<div class="top-arrow"></div>
													<ul class="mn">
														<li><a class="my-info" href="../merchant/jumpToAddMoney">充值</a></li>
														<li><a id="queryAccount-merchant" class="my-info" href="javascript:void(0)">账户余额</a></li>
														<li><a class="my-info" href="../merchant/jumpToChangePassword">修改密码</a></li>
														<li><a class="logout" href="../home/merchantLogout">退出</a></li>
													</ul>
												</div>
											</li>
										</ul>
									</div>
								</div>
							</li>
						</c:when>
						<c:otherwise>
							<li class="active"><a href="../home/login" class="act">我的订单</a></li>
							<li><a href="../home/register"> 注   册 </a></li>
							<li><a href="../home/login"> 登录 </a></li>
						</c:otherwise>
					</c:choose>
				</ul>
			</div>
			<%-- <div class="agile-login" >
				<ul>
					<c:choose>
						<c:when test="${sessionScope.uid!=null }">
							<li class="active"><a href="../orderInfo/getOrder" class="act">我的订单</a></li>
							<li><a href="${pageContext.request.contextPath }/home/logout?pageId=${pageId }"> 退出登录 </a></li>
						</c:when>
						<c:otherwise>
							<li class="active"><a href="../home/login" class="act">我的订单</a></li>
							<li><a href="../home/register"> 注   册 </a></li>
							<li><a href="../home/login"> 登   录 </a></li>
						</c:otherwise>
					</c:choose>
					<!-- <li><a href="#"> 帮   助 </a></li> -->
				</ul>
			</div> --%>
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
	</div>

	<div class="logo_products">
		<div class="container">
		<div class="w3ls_logo_products_left1"><!--  onmouseover="showInfo();" onmouseout="recede();" -->
				<ul class="phone_email">
					<!--<li><i class="fa fa-phone" aria-hidden="true"></i>Order online or call us : (+0123) 234 567</li> -->
					<li><img title=" " alt=" " src="${restaurant.rphoto}" /></li>
					<li><h4>${restaurant.rname}</h4>
					</br>
					<div class="stars" text-align="left">
						<c:forEach var="i" begin="1" end="${star}">
							<i class="fa fa-star blue-star" aria-hidden="true"></i>
						</c:forEach>
						<c:forEach var="i" begin="1" end="${5-star}">
							<i class="fa fa-star gray-star" aria-hidden="true"></i>
						</c:forEach>
						${restaurant.rstar}
					</div>
					</li>
					<%-- <li>${restaurant.rdescription}</li> --%>
					<%-- <li><h4>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;月售${restaurant.rsales_volume}</h4></li> --%>
				</ul>
				<div class="w3ls_logo_products_left1_hide">
					<div class="hidden_info">
						${restaurant.rdescription}
					</div>
					<div class="hidden_info">
						<c:choose>
							<c:when test="${restaurant.arrival==0 }">
								本店不支持到店自取
							</c:when>
							<c:when test="${restaurant.arrival==1 }">
								本店支持到店自取
							</c:when>
						</c:choose>
					</div>
				</div>
			</div>
			<div class="w3ls_logo_products_left">
				</br>
				<table>
					<tr>
						<c:choose>
							<c:when test="${sessionScope.uid!=null }">
				   				<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;平均送达时间</td>
				   			 	<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;起送价</td>
								<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;配送费</td>
				   			</c:when>
				   			<c:otherwise>
				   				<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;起送价</td>
								<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;配送费</td>
				   			</c:otherwise>
				   		</c:choose>
					</tr>
					<tr>
					<c:choose>
						<c:when test="${sessionScope.uid!=null }">
				   			<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${restaurant.minute}分钟</td>
				    		<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;¥${restaurant.sending_fee}</td>
							<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;¥${restaurant.shipping_fee}</td>
				   		</c:when>
				   		<c:otherwise>
				   			<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;¥${restaurant.sending_fee}</td>
							<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;¥${restaurant.shipping_fee}</td>
				   		</c:otherwise>
				   	</c:choose>
				   	</tr>
				</table>
			</div>
		<div class="w3l_search">
			<form action="../restaurantInfo/searchFood" method="post">
				<input type="hidden" name="rid" value=${restaurant.rid }>
				<input type="search" name="name" placeholder="请输入商品名" required="required">
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
					<c:choose>
						<c:when test="${sessionScope.rid==null }">
							<li><a href="../home/visit" class="act">主页</a></li>
							<li class="active"><a href="${pageContext.request.contextPath }/restaurantInfo/visitRestaurantByRid?rid=${restaurant.rid}" class="act">餐馆主页</a></li>	
							<li><a href="../evaluation/visitEvaluation?rid=${restaurant.rid }" class="act">评价</a></li>
							<c:choose>
								<c:when test="${sessionScope.uid!=null }">
									<li class="active"><a href="../shopping_trolleyInfoAdd/visitShopping_trolley?rid=${restaurant.rid }" class="act">购物车</a></li>	
								</c:when>
								<c:otherwise>
									<li class="active"><a href="../home/login" class="act">购物车</a></li>	
								</c:otherwise>
							</c:choose>
						</c:when>
						<c:when test="${sessionScope.rid!=null }">
							<li><a href="../merchant/jumpToHoutai" class="act">后台管理系统</a></li>
							<li class="active"><a href="${pageContext.request.contextPath }/restaurantInfo/visitRestaurantByRid?rid=${restaurant.rid}" class="act">餐馆主页</a></li>
							<li><a href="../merchant/income" class="act">收益</a></li>	
							<li><a href="../evaluation/visitEvaluation?rid=${restaurant.rid }" class="act">评价</a></li>
							<li><a href="../orderInfo/getOrder" class="act">订单</a></li>
						</c:when>
					</c:choose>
						
					</ul>
				</div>
			</nav>
		</div>
	</div>
		
<!-- //navigation -->

<script>
	$("#queryAccount-merchant").click(function(){
		$.get("../merchant/queryAccount", function(data, status){
			alert("账户余额为："+data+"元");
		});
	});
	$("#queryAccount-user").click(function(){
		$.get("../userInfo/queryAccount", function(data, status){
			alert("账户余额为："+data+"元");
		});
	});
</script>
  </body>
  
</html>
