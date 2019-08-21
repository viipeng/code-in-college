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
<!-- <link href="Bootstrap Core JavaScript -->
<script src="js/bootstrap.min.js"></script>

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
<script src="js/minicart.min.js"></script>
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
<script src="js/skdslider.min.js"></script>
<link href="css/skdslider.css" rel="stylesheet">
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
	<jsp:include page="header.jsp"></jsp:include>
<!-- //header -->

	<!-- main-slider -->
		<ul id="demo1">
			<li>
				<img src="../jsp/images/11.jpg" alt="" />
				<!--Slider Description example-->
				<div class="slide-desc">
					<h3>Online Ordering Platform</h3>
				</div>
			</li>
			<li>
				<img src="../jsp/images/22.jpg" alt="" />
				  <div class="slide-desc">
					<h3>Online Ordering Platform</h3>
				</div>
			</li>
			
			<li>
				<img src="../jsp/images/44.jpg" alt="" />
				<div class="slide-desc">
					<h3>Online Ordering Platform</h3>
				</div>
			</li>
		</ul>
	<!-- //main-slider -->
	<!-- //top-header and slider -->
	<!-- top-brands -->
	<div class="top-brands">
		<div class="container">
		<!-- <h2>Top selling offers</h2> -->
			<div class="grid_3 grid_5">
				<div class="bs-example bs-example-tabs" role="tabpanel" data-example-id="togglable-tabs">
					<ul id="myTab" class="nav nav-tabs" role="tablist">
						<li role="presentation" class="active">
							<c:choose>
								<c:when test="${isSearch==1 }">
									<a href="#expeditions" id="expeditions-tab" role="tab" data-toggle="tab" aria-controls="expeditions" aria-expanded="true">附近商家</a>
								</c:when>
								<c:when test="${isSearch==2 }">
									<a href="#expeditions" id="expeditions-tab" role="tab" data-toggle="tab" aria-controls="expeditions" aria-expanded="true">附近商家的搜索结果</a>
								</c:when>
							</c:choose>
						</li>
					</ul>
					<div id="myTabContent" class="tab-content">
						<div role="tabpanel" class="tab-pane fade in active" id="expeditions" aria-labelledby="expeditions-tab">
							<div class="collapse navbar-collapse" id="bs-megadropdown-tabs">
								<ul class="nav navbar-nav">
									<c:choose>
									<c:when test="${isSearch==1 }">
									<li><a href="../home/visit">默认排序</a></li>
									<li><a href="../home/selectByStar">评分最高</a></li>
									<li><a href="../home/selectBySending_fee">起送价最低</a></li>
									<li><a href="../home/selectByShipping_fee">配送费最低</a></li>
									<li><a href="../home/selectByCpc">人均高到低</a></li>
									<li><a href="../home/selectByCpc1">人均低到高</a></li>
									<li><a href="../home/selectBySales_volume">销量</a></li>
									<c:choose>
										<c:when test="${sessionScope.uid!=null }">
											<li><a href="../home/selectByMinute">速度最快</a></li>
											<li><a href="../home/selectByDistance">距离</a></li>
										</c:when>
									</c:choose>
									</c:when>
									</c:choose>
								</ul>
							</div>
							<div id="restaurant_list" class="agile_top_brands_grids">
							 <c:set var="time" value="0" />
								<c:forEach items="${restaurantList }" var="restaurant">
								<c:set var="time" value="${time+1 }"/>
								<div class="col-md-4 top_brand_left">
									<div class="hover14 column">
										<div class="agile_top_brand_left_grid">
											<div class="agile_top_brand_left_grid_pos">
												<img src="../jsp/images/offer.png" alt=" " class="img-responsive" />
											</div>
											<div class="agile_top_brand_left_grid1">
												<figure>
													<div class="snipcart-item block" >
														<div class="snipcart-thumb">
															<a href="${pageContext.request.contextPath }/restaurantInfo/visitRestaurantByRid?rid=${restaurant.rid}">
																<img title=" " alt=" " src="${restaurant.rphoto}" /><!-- ../jsp/img/hualaishi/hualaishi.png -->
																<p>${restaurant.rname}</p><!-- 华莱士 -->
																<div class="stars">
																	<i class="fa fa-star blue-star" aria-hidden="true">${restaurant.rstar}</i>
																</div>
																<c:choose>
																	<c:when test="${sessionScope.uid!=null }">
																		<p>${restaurant.minute}分钟&nbsp;&nbsp;&nbsp;&nbsp;${restaurant.distance}km</p>
																	</c:when>
																</c:choose>
																	<p>月售${restaurant.rsales_volume}
																		<c:choose>
																			<c:when test="${restaurant.rcategory!=null }">
																				&nbsp;&nbsp;&nbsp;&nbsp;${restaurant.rcategory}
																			</c:when>
																		</c:choose>
																		<c:choose>
																			<c:when test="${restaurant.arrival==1 }">
																				&nbsp;&nbsp;&nbsp;&nbsp;支持自取
																			</c:when>
																		</c:choose>
																	</p>
																	<p>起送价${restaurant.sending_fee}&nbsp;&nbsp;&nbsp;&nbsp;
																		<c:choose>
																			<c:when test="${restaurant.shipping_fee==0 }">
																				免配送费&nbsp;&nbsp;&nbsp;&nbsp;
																			</c:when>
																			<c:otherwise>
																				配送费${restaurant.shipping_fee}&nbsp;&nbsp;&nbsp;&nbsp;
																			</c:otherwise>
																		</c:choose>
																		<c:choose>
																			<c:when test="${restaurant.cpc!=0 }">
																				人均${restaurant.cpc}
																			</c:when>
																		</c:choose>
																	</p>
																<div class="snipcart-details top_brand_home_details">
																	<input type="submit" name="submit" value="进入餐馆" class="button" />
																</div>
															</a>
														</div>
													</div>
												</figure>
											</div>
										</div>
									</div>
								</div>
								<c:choose>
									<c:when test="${time%3==0 }">
										<div class="clearfix"> </div>
										</br></br>
									</c:when>
								</c:choose>
								</c:forEach>
								<div class="clearfix"> </div>
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
														<a href="${pageContext.request.contextPath }/home/pageRestaurant?pageId=${previous}" aria-label="Previous">
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
														<a href="${pageContext.request.contextPath }/home/pageRestaurant?pageId=${page}">${page }<span class="sr-only">(current)</span></a></li>
													</c:when>
													<c:otherwise>
														<li><a href="${pageContext.request.contextPath }/home/pageRestaurant?pageId=${page}">${page }</a></li>
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
														<a href="${pageContext.request.contextPath }/home/pageRestaurant?pageId=${next}" aria-label="Next">
															<span aria-hidden="true">&raquo;</span>
														</a>
													</li>
												</c:otherwise>
											</c:choose>
										</ul>
									</nav>
							
							</div>
						</div>
						<!-- 到店自取 -->
						
					</div>
				</div>
			</div>
		</div>
	</div>
<!-- //top-brands -->
 
<!-- new -->
	<div class="brands">
		<div class="container">
			<h3>甄选推荐</h3>
				<div class="agile_top_brands_grids">
					<c:forEach items="${rrestaurantList }" var="rrestaurant">
					<div class="col-md-3 top_brand_left-1">
						<div class="hover14 column">
							<div class="agile_top_brand_left_grid">
								<div class="agile_top_brand_left_grid_pos">
									<img src="../jsp/images/offer.png" alt=" " class="img-responsive">
								</div>
								<div class="agile_top_brand_left_grid1">
									<figure>
										<div class="snipcart-item block">
											<div class="snipcart-thumb">
															<a href="${pageContext.request.contextPath }/restaurantInfo/visitRestaurantByRid?rid=${rrestaurant.rid}">
																<img title=" " alt=" " src="${rrestaurant.rphoto}" /><!-- ../jsp/img/hualaishi/hualaishi.png -->
																<p>${rrestaurant.rname}</p><!-- 华莱士 -->
																<div class="stars">
																	<i class="fa fa-star blue-star" aria-hidden="true">${rrestaurant.rstar}</i>
																</div>
																<c:choose>
																	<c:when test="${sessionScope.uid!=null }">
																		<p>${rrestaurant.minute}分钟&nbsp;&nbsp;&nbsp;&nbsp;${rrestaurant.distance}km</p>
																	</c:when>
																</c:choose>
																	<p>月售${rrestaurant.rsales_volume}
																		<c:choose>
																			<c:when test="${rrestaurant.rcategory!=null }">
																				&nbsp;&nbsp;&nbsp;&nbsp;${rrestaurant.rcategory}
																			</c:when>
																		</c:choose>
																		<c:choose>
																			<c:when test="${rrestaurant.arrival==1 }">
																				&nbsp;&nbsp;&nbsp;&nbsp;支持自取
																			</c:when>
																		</c:choose>
																	</p>
																	<p>起送价${rrestaurant.sending_fee}&nbsp;&nbsp;&nbsp;&nbsp;
																		<c:choose>
																			<c:when test="${rrestaurant.shipping_fee==0 }">
																				免配送费&nbsp;&nbsp;&nbsp;&nbsp;
																			</c:when>
																			<c:otherwise>
																				配送费${rrestaurant.shipping_fee}&nbsp;&nbsp;&nbsp;&nbsp;
																			</c:otherwise>
																		</c:choose>
																		<c:choose>
																			<c:when test="${rrestaurant.cpc!=0 }">
																				人均${rrestaurant.cpc}
																			</c:when>
																		</c:choose>
																	</p>
																<div class="snipcart-details top_brand_home_details">
																	<input type="submit" name="submit" value="进入餐馆" class="button" />
																</div>
															</a>
														</div>
										</div>
									</figure>
								</div>
							</div>
						</div>
					</div>
					</c:forEach>
					<div class="clearfix"> </div>
				</div>
		</div>
	</div>
<!-- //new -->
<!-- footer -->
	<jsp:include page="footer.jsp"></jsp:include>
<!-- //footer -->	
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