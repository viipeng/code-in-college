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
<title>订单</title>
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
	<c:choose>
		<c:when test="${sessionScope.rid!=null }">
			<jsp:include page="restaurant_header.jsp"></jsp:include>
		</c:when>
		<c:when test="${sessionScope.uid!=null }">
			<jsp:include page="header.jsp"></jsp:include>
		</c:when>
	</c:choose>
<!-- //header -->
<!-- breadcrumbs -->
	<div class="breadcrumbs">
		<div class="container">
			<ol class="breadcrumb breadcrumb1 animated wow slideInLeft" data-wow-delay=".5s">
				<c:choose>
					<c:when test="${sessionScope.rid==null }">
						<li><a href="../home/visit"><span class="glyphicon glyphicon-home" aria-hidden="true"></span>主页</a></li>
						<li class="active">订单 </li>
					</c:when>
					<c:when test="${sessionScope.rid!=null }">
						<li style="color:#3399cc"><a href="${pageContext.request.contextPath }/restaurantInfo/visitRestaurantByRid?rid=${restaurant.rid}">
							<span class="glyphicon glyphicon-home" aria-hidden="true"></span>${restaurant.rname }</a></li>
						<li class="active">订单 </li>
					</c:when>
				</c:choose>
			</ol>
		</div>
	</div>
<!-- //breadcrumbs -->
<!-- content -->
	<div class="clearfix"> </div>
	<div class="main">
		<section class="order-menu">
			<div class="order-menu-pos">
				<div class="order-menu-header">
					<span>订单</span>
				</div>
				<div class="splitter"></div>
				<div class="order-menu-body">
					<div class="menu-item">
						<div id="menu-order" class="selected">
							<span class="menu-icon order-icon"></span>
								<a href="../orderInfo/getOrder" class="menu-title order"><span>全部订单</span></a>
						</div>
					</div>
					<!-- <div class="menu-item">
						<div id="menu-favorite" >
							<span class="menu-icon favorite-icon"></span>
							<a href="#" class="menu-title favorite"><span>收藏夹</span></a>
						</div>
					</div> -->
					<div class="menu-item">
						<div id="menu-refund" >
							<span class="menu-icon evaluation-icon"></span>
							<a href="../orderInfo/getEOrder" class="menu-title refund"><span>待评价</span></a>
						</div>
					</div>
					<div class="menu-item">
						<div id="menu-refund" >
							<span class="menu-icon send-icon"></span>
							<a href="../orderInfo/getSOrder" class="menu-title refund"><span>待送达</span></a>
						</div>
					</div>
					<div class="menu-item">
						<div id="menu-refund" >
							<span class="menu-icon payment-icon"></span>
							<a href="../orderInfo/getPOrder" class="menu-title refund"><span>待付款</span></a>
						</div>
					</div>
					<div class="menu-item">
						<div id="menu-refund" >
							<span class="menu-icon refund-icon"></span>
							<a href="../orderInfo/getROrder1" class="menu-title refund"><span>待退款</span></a>
						</div>
					</div>
					<div class="menu-item">
						<div id="menu-refund" >
							<span class="menu-icon refund-icon"></span>
							<a href="../orderInfo/getROrder2" class="menu-title refund"><span>已退款</span></a>
						</div>
					</div>
				</div>
			</div>
		</section>

		<section class="usercenter-detail" id="user-order">
			<div class="summary">
				<h3 class="summary-header">${state }</h3>
				<!-- <div class="summary-info">
					<a class="ft-blk ft-medium" href="../orderInfo/getOrder" data-type="list" data-node="summary-anchor">全部订单</a>
					<span>|</span>
					<a class="ft-blk ft-medium" href="../orderInfo/getEOrder" data-type="uncommented" data-node="summary-anchor">待评价</a>
					<span>|</span>
					<a class="ft-blk ft-medium" href="../orderInfo/getSOrder" data-type="uncommented" data-node="summary-anchor">待送达</a>
					<span>|</span>
					<a class="ft-blk ft-medium" href="../orderInfo/getPOrder" data-type="uncommented" data-node="summary-anchor">待付款</a>
				</div> -->
			</div>
			<div><a class="cms-charlink" data-node="summary-txtLinkExpand"></a></div>
			<div class="order-info" data-node="order-cards">
				<c:choose>
					<c:when test="${size==0 }">
						<div class="no-result">    
							<div class="no-result-image" style="padding:40px 0 20px;">        
								<img src="../img/other/noOrder.png" alt="无结果" style="display:block;margin:auto;">    
							</div>    
							<div class="no-result-notice" style="text-align:center;padding-bottom: 50px;">
								<div class="order-notice">暂无订单, 
									<a href="../home/visit" class="ft-red">马上来一份</a>
								</div>
							</div>
						</div>
					</c:when>
				</c:choose>
				<div class="order-list">
					<c:set var="finish" value="完成" />
					<c:set var="on_way" value="途中" />
					<c:set var="no_pay" value="待付款" />
					<c:set var="no_evaluate" value="待评价" />
					<c:set var="refund1" value="待退款" />
					<c:set var="refund2" value="已退款" />
					<c:forEach items="${oiList }" var="order">
						<div class="order-list-eachLine">
							<!-- <div class="rem1"> -->
								<div class="order-list-img">
									<div class="info">
										<img title=" " alt=" " src="${order.rphoto }">
										<p style="font-size: 15px">${order.rname }</p>
									</div>
								</div>
								<div class="order-list-info">
									<div class="info">
										${order.all_food }
										</br></br>
										<p style="font-size: 16px">¥${order.consumption }&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
											&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
											${order.ostate }&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
											&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
											${order.odate }</p>
									</div>
								</div>
								<div class="order-list-last">
									<div class="info">
										<c:choose>
											<c:when test="${sessionScope.uid!=null }">
											<c:choose>
												<c:when test="${order.ostate== finish }">
													<a href="../orderInfo/orderingAgain?oid=${order.oid }"><input type="button" name="" value="再来一单" class="button" /></a>
													<a href="../orderInfo/inVisibleOrder?oid=${order.oid }"><input type="button" name="" value="删除订单" class="button" /></a>
												</c:when>
												<c:when test="${order.ostate== on_way }">
													<a href="../orderInfo/isSent?oid=${order.oid }"><input type="button" name="" value="确认送达" class="button" /></a>
													<a href="../orderInfo/appealRefund?oid=${order.oid }"><input type="button" name="" value="退款" class="button" /></a>
												</c:when>
												<c:when test="${order.ostate== no_pay }">
													<a href="../orderInfo/payment?oid=${order.oid }"><input type="button" name="" value="付款" class="button" /></a>
													<a href="../orderInfo/cancelOrder?oid=${order.oid }"><input type="button" name="" value="取消订单" class="button" /></a>
												</c:when>
												<c:when test="${order.ostate== no_evaluate }">
													<a href="../evaluation/jumpToEvaluate?oid=${order.oid }"><input type="button" name="" value="去评价" class="button" /></a>
													<a href="../orderInfo/orderingAgain?oid=${order.oid }"><input type="button" name="" value="再来一单" class="button" /></a>
												</c:when>
												<c:when test="${order.ostate== refund1 }"><!-- 待退款 -->
													<a href="../orderInfo/appealRefund?oid=${order.oid }"><input type="button" name="" value="退款" class="button" /></a>
													<a href="../orderInfo/cancelRefund?oid=${order.oid }"><input type="button" name="" value="取消退款" class="button" /></a>
												</c:when>
											</c:choose>
											</c:when>
											<c:when test="${sessionScope.rid!=null && order.ostate== refund1 }"><!-- 待退款 -->
												<a href="../orderInfo/permitRefund?oid=${order.oid }"><input id="permitRefund" type="button" name="" value="同意退款" class="button" /></a>
												<a href="../orderInfo/refuseRefund?oid=${order.oid }"><input type="button" name="" value="拒绝退款" class="button" /></a>
											</c:when>
											<c:when test="${order.ostate== refund2 }"><!-- 已退款 -->
												
											</c:when>
										</c:choose>
									</div>
								</div>
							<!-- </div> -->
						</div>
					</c:forEach>
				</div>
									<nav class="numbering">
										<%-- <c:set var="page" value="1"/> --%>
										<ul class="pagination paging">
											<c:choose>
												<c:when test="${pageId==1 }">
													<li>
														<a href="" aria-label="Previous">
															<span aria-hidden="true">&laquo;</span>
														</a>
													</li>
												</c:when>
												<c:otherwise>
													<c:set var="previous" value="${pageId-1 }" />
													<li>	
														<a href="${pageContext.request.contextPath }/orderInfo/pageOrder?pageId=${previous}&state=${state }" aria-label="Previous">
															<span aria-hidden="true">&laquo;</span>
														</a>
													</li>
												</c:otherwise>
											</c:choose>
											<c:set var="page" value="0" />
											<c:forEach var="i" begin="1" end="${pageNum }">
												<c:set var="page" value="${page+1 }" />
												<c:choose>
													<c:when test="${i==pageId}">
														<li class="active">
														<a href="${pageContext.request.contextPath }/orderInfo/pageOrder?pageId=${page}&state=${state }">${page }<span class="sr-only">(current)</span></a></li>
													</c:when>
													<c:otherwise>
														<li><a href="${pageContext.request.contextPath }/orderInfo/pageOrder?pageId=${page}&state=${state }">${page }</a></li>
													</c:otherwise>
												</c:choose>
											</c:forEach>
											<c:choose>
												<c:when test="${pageId==pageNum }">
													<li>
														<a href="" aria-label="Next">
															<span aria-hidden="true">&raquo;</span>
														</a>
													</li>
												</c:when>
												<c:otherwise>
													<c:set var="next" value="${pageId+1 }" />
													<li>
														<a href="${pageContext.request.contextPath }/orderInfo/pageOrder?pageId=${next}&state=${state }" aria-label="Next">
															<span aria-hidden="true">&raquo;</span>
														</a>
													</li>
												</c:otherwise>
											</c:choose>
										</ul>
									</nav>
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
	
</script>

<!-- Bootstrap Core JavaScript -->
<script src="../jsp/js/bootstrap.min.js"></script>
<!-- top-header and slider -->
<!-- here stars scrolling icon -->
<!-- 自己加的 -->
<script type="text/javascript">
	
</script>
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
