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
<title>收益</title>
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
				<li style="color:#3399cc"><a href="${pageContext.request.contextPath }/restaurantInfo/visitRestaurantByRid?rid=${restaurant.rid}">
					<span class="glyphicon glyphicon-home" aria-hidden="true"></span>${restaurant.rname }</a></li>
				<li class="active">收益 </li>
			</ol>
		</div>
	</div>
<!-- //breadcrumbs -->
<!-- content -->
	<div class="clearfix"> </div>
	<div class="main">
	<section class="income-detail" id="user-order">
			<div class="summary">
				<div class="sorting">
					<select id="selectYear" name="selectYear" class="frm-field required sect">
						<c:forEach var="i" begin="1999" end="${year }">
						<c:choose>
							<c:when test="${i==1999 }">
								<option value="null">请选择年份</option>
							</c:when>
							<c:otherwise>
								<option value="${i }">${i }年</option>
							</c:otherwise>
						</c:choose>
						</c:forEach>			
					</select>
				</div>
				<div class="sorting">
					<select id="selectMonth" name="selectMonth" class="frm-field required sect">
						<option value="null">请选择月份</option>
					</select>
				</div>
				<div class="sorting">
					<select id="selectDay" name="selectDay" class="frm-field required sect">
						<option value="null">请选择日子</option>
					</select>
				</div>
				<div class="searchIncome">
					<a id="oneDayIncome" href="javascript:void(0)" >搜索</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<a id="todayIncome" href="javascript:void(0)" >今日收益</a>
					<a id="yesterdayIncome" href="javascript:void(0)" >昨日收益</a>
					<a id="monthIncome" href="javascript:void(0)" >本月收益</a>
					<!-- <a id="yearIncome" href="javascript:void(0)" >今年收益</a> -->
				</div>
			</div>
			<div><a class="cms-charlink" data-node="summary-txtLinkExpand"></a></div>
			<div class="order-info" data-node="order-cards">
				
				<div class="order-list">
						<div id="showIncome" class="order-list-eachLine">
							<p>今日收益：${finishSum }元</p>
							<p>待付款的订单总额为：${noPaySum }元</p>
							<p>待送达的订单总额为：${on_waySum }元</p>
							<p>待退款的订单总额为：${noRefundSum }元</p>
							<p>已退款的订单总额为：${hasRefundSum }元</p>
						</div>
				</div>
				</div>
		</section>
		<div class="clearfix" style="_height:0px;_overflow:hidden;"></div>
	</div>
<!-- //content -->
<!-- //footer -->
	<jsp:include page="footer.jsp"></jsp:include>
<!-- //footer -->
<!-- 自己写的script -->
<script>
	$("#selectYear").change(function(){
		$("#selectMonth").html("<option value="+null+">请选择月份</option>");
		$("#selectDay").html("<option value="+null+">请选择日子</option>");
		$.get("../merchant/getMonth", function(data,status){
			/* alert("传到了,共有"+data+"个月"); */
			for(var i=0; i<data; i++){
				var month= i+1;
				$("#selectMonth").append("<option value="+month+">"+month+"月</option>");
			}
		});
	});
	$("#selectMonth").change(function(){
		$("#selectDay").html("<option value="+null+">请选择日子</option>");
		var year= $("#selectYear").val();
		var month= $(this).val();
		$.post("../merchant/getDay", {year:year, month:month}, function(data,status){
			/* alert("年份是"+year+",月份是"+month+",日子是"+data); */
			for(var i=0; i<data; i++){
				var day= i+1;
				$("#selectDay").append("<option value="+day+">"+day+"号</option>");
			}
		});
	});
	$("#oneDayIncome").click(function(){
		/* alert("今日收益"); */
		var year= $("#selectYear").val();
		var month= $("#selectMonth").val();
		var day= $("#selectDay").val();
		$.post("../merchant/oneDayIncome", {year:year, month:month, day:day}, function(data,status){
			$("#showIncome").html("<p>"+year+"年"+month+"月"+day+"号全天的收益："+data+"元</p>");
		});
	});
	$("#todayIncome").click(function(){
		/* alert("今日收益"); */
		/* $.get("../merchant/todayIncome", function(data,status){
			$("#showIncome").html("<p>今日收益："+data+"元</p>");
		}); */
		$.ajax({
			type: "get",
			url: "../merchant/todayIncome",
			dataType: "json",
			contentType: "application/json",
			success: function(data){
				$("#showIncome").html(null);
				$(data).each(function(index, c) {
					/* alert("第"+index+"次"); */
					$("#showIncome").append("<p>"+c+"</p>");
				});
			},
			error: function(){
				alert("传递失败！");
			}
		});
	});
	/* $("#yesterdayIncome").click(function(){
		$.get("../merchant/yesterdayIncome", function(data,status){
			$("#showIncome").html("<p>昨日收益："+data+"元</p>");
		});
	}); */
	$("#yesterdayIncome").click(function(){
		$.ajax({
			type: "get",
			url: "../merchant/yesterdayIncome",
			dataType: "json",
			success: function(data){
				$("#showIncome").html("<p>昨日收益："+data+"元</p>");
			}
		});
	});
	$("#monthIncome").click(function(){
		/* alert("本月收益"); */
		$.get("../merchant/monthIncome", function(data,status){
			$("#showIncome").html("<p>本月收益："+data+"元</p>");
		});
	});
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
