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
<title>充值</title>
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
	<c:choose>
		<c:when test="${sessionScope.rid!=null }">
			<jsp:include page="restaurant_header.jsp"></jsp:include>
		</c:when>
		<c:when test="${sessionScope.uid!=null }">
			<jsp:include page="header.jsp"></jsp:include>
		</c:when>
	</c:choose>
<!-- //header -->
<!-- navigation -->
	<!-- 包括在了header.jsp中 -->
<!-- //navigation -->
<!-- breadcrumbs -->
	<div class="breadcrumbs">
		<div class="container">
			<ol class="breadcrumb breadcrumb1 animated wow slideInLeft" data-wow-delay=".5s">
			<c:choose>
				<c:when test="${sessionScope.rid!=null }">
					<li style="color:#3399cc"><a href="${pageContext.request.contextPath }/restaurantInfo/visitRestaurantByRid?rid=${restaurant.rid}">
						<span class="glyphicon glyphicon-home" aria-hidden="true"></span>${restaurant.rname }</a></li>
				</c:when>
				<c:when test="${sessionScope.uid!=null }">
					<li><a href="../home/visit"><span class="glyphicon glyphicon-home" aria-hidden="true"></span>主页</a></li>
				</c:when>
			</c:choose>
				<li class="active">充值</li>
			</ol>
		</div>
	</div>
<!-- //breadcrumbs -->
<!-- login -->
	<div class="login">
		<div class="container">
			<h2>充值</h2>
			<div class="login-form-grids animated wow slideInUp" data-wow-delay=".5s">
			<c:choose>
				<c:when test="${sessionScope.rid!=null }">
					<form  action="../merchant/addMoney" onsubmit="return check()">
						<span>金额：</span>
						<input type="text" id="money" name="money" placeholder="请输入金额" required=" " >
						<input type="submit" value="充	值">
					</form>
				</c:when>
				<c:when test="${sessionScope.uid!=null }">
					<form  action="../userInfo/addMoney" onsubmit="return check()">
						<span>金额：</span>
						<input type="text" id="money" name="money" placeholder="请输入金额" required=" " >
						<input type="submit" value="充	值">
					</form>
				</c:when>
			</c:choose>
			</div>
		</div>
	</div>
<!-- //login -->
<!-- footer -->
	<jsp:include page="footer.jsp"></jsp:include>
<!-- //footer -->	
<!-- Bootstrap Core JavaScript -->
<script src="../jsp/js/bootstrap.min.js"></script>
<!-- top-header and slider -->
<!-- 自己加的 -->
<script type="text/javascript">
	function check(){
		if(isNaN(document.getElementById('money').value)){
			alert('金额只能输入数字');
			return false;
		}
	}
	/* function check_user(){
		if(isNaN(document.getElementById('money-user').value)){
			alert('金额只能输入数字');
			return false;
		}
	} */
</script>
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