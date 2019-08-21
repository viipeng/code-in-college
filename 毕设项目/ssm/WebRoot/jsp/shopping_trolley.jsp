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
<title>购物车</title>
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
<!-- header -->
	<jsp:include page="restaurant_header.jsp"></jsp:include>
<!-- //header -->
<!-- breadcrumbs -->
	<div class="breadcrumbs">
		<div class="container">
			<ol class="breadcrumb breadcrumb1 animated wow slideInLeft" data-wow-delay=".5s">
				<li><a href="../home/visit"><span class="glyphicon glyphicon-home" aria-hidden="true"></span>主页</a></li>
				<li><a href="${pageContext.request.contextPath }/restaurantInfo/visitRestaurantByRid?rid=${restaurant.rid}">
					${restaurant.rname }</a></li>
				<li class="active">购物车 </li>
			</ol>
		</div>
	</div>
<!-- //breadcrumbs -->
<!-- content -->
	<div class="checkout">
		<div class="container">
			<h2>你的购物车里共有<span> ${sti.foodSum } </span>件商品</h2>
			<div class="checkout-right">
				<table class="timetable_sub">
					<thead>
						<tr>
							<th>商品编号</th>	
							<th>图片</th>
							<th>名称</th>
							<th>单价</th>
							<th>数量</th>
							<th>删除</th>
						</tr>
					</thead>
					<c:set var="time" value="0" />
					<c:forEach items="${stfList }" var="food">
					<c:set var="time" value="${time+1 }"/>
					<tr class="rem1">
						<td class="invert">${time }</td>
						<td class="invert-image">
							<img title=" " alt=" " src="${food.fphoto }">
							<%-- <div class="snipcart-img">
								<img title=" " alt=" " src="${food.fphoto }">
								<div class="snipcart-img-hide">
									<div class="hidden_info">
										${food.fdescription}
									</div>
								</div>
							</div>	 --%>
						</td>
						<td class="invert">${food.fname }</td>
						<td class="invert">¥${food.fprice }</td>
						<td class="invert">
							 <div class="quantity"> 
								<div class="quantity-select">                           
									<a href="../shopping_trolleyInfo/SubAmountOfSTFood?sfid=${food.sfid }&rid=${restaurant.rid }"><div class="entry value-minus">&nbsp;</div></a>
									<div class="entry value"><span>${food.amount }</span></div>
									<a href="../shopping_trolleyInfo/AddAmountOfSTFood?sfid=${food.sfid }&rid=${restaurant.rid }"><div class="entry value-plus active">&nbsp;</div></a>
								</div>
							</div>
						</td>
						<%-- <td class="invert">${food.amount }</td> --%>
						<td class="invert">
							<a href="../shopping_trolleyInfo/DeleteSTFoodBySfid?sfid=${food.sfid }&rid=${restaurant.rid }" >
								<div class="rem">
									<div class="close1"> </div>
								</div>
							</a>
						</td>
					</tr>
					</c:forEach>
				</table>
			</div>
			<div class="checkout-left">	
				<div class="checkout-left-basket">
					<h4>账&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;单</h4>
					<ul>
						<c:forEach items="${stfList }" var="food">
							<li>${food.fname } <i>-</i> <span>¥<fmt:formatNumber type="numbesr" value="${food.fprice*food.amount }" pattern="#.0" /></span></li>
						</c:forEach>
						<li>配送费 <i>-</i> <span>¥${sti.shipping_fee } </span></li>
						<li class="checkout-left-basket_lastLine">总计 <i>-</i> <span>¥
			<fmt:formatNumber type="number" value="${sti.total+sti.shipping_fee }" pattern="#.0" /></span></li>
					</ul>
				</div>
				<div class="checkout-right-basket">
					<a href="${pageContext.request.contextPath }/restaurantInfo/visitRestaurantByRid?rid=${restaurant.rid}">
						<span class="glyphicon glyphicon-menu-left" aria-hidden="true"></span>继续购物</a>
					<a href="../orderInfo/ordering?sid=${sti.sid }">
						<span class="glyphicon glyphicon-menu-left" aria-hidden="true"></span>确认下单</a>
				</div>
				<div class="clearfix"> </div>
			</div>
		</div>
	</div>
<!-- //content -->
<!-- //footer -->
	<jsp:include page="footer.jsp"></jsp:include>
<!-- //footer -->
<!-- 自己写的script -->
<script>
	
</script>

<!-- Bootstrap Core JavaScript -->
<script src="../jsp/js/bootstrap.min.js"></script>
<!-- top-header and slider -->
<!-- here stars scrolling icon -->
	<script type="text/javascript">
		$(document).ready(function() {
			/*
				var defaults = {
				containerID: 'toTop', // fading element id
				containerHoverID: 'toTopHover', // fading element hover id
				scrollSpeed: 1200,
				easingType: 'linear' 
				};
			*/
								
			$().UItoTop({ easingType: 'easeOutQuart' });
								
			});
	</script>
<!-- //here ends scrolling icon -->
<script src="../jsp/js/minicart.min.js"></script>
<script>
	// Mini Cart
	paypal.minicart.render({
		action: '#'
	});

	if (~window.location.search.indexOf('reset=true')) {
		paypal.minicart.reset();
	}
</script>
<!-- main slider-banner -->
<script src="../jsp/js/skdslider.min.js"></script>
<link href="../jsp/css/skdslider.css" rel="stylesheet">
<script type="text/javascript">
		jQuery(document).ready(function(){
			jQuery('#demo1').skdslider({'delay':5000, 'animationSpeed': 2000,'showNextPrev':true,'showPlayButton':true,'autoSlide':true,'animationType':'fading'});
						
			jQuery('#responsive').change(function(){
			  $('#responsive_wrapper').width(jQuery(this).val());
			});
			
		});
</script>	
<!-- //main slider-banner --> 

  </body>
</html>
