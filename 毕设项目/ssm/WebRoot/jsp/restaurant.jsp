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
<title>${restaurant.rname }</title>
<!-- for-mobile-apps -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false);
		function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- //for-mobile-apps -->
<link href="../jsp/css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
<link href="../jsp/css/style.css" rel="stylesheet" type="text/css" media="all" />
<link rel="stylesheet" type="text/css" href="../jsp/css/jquery-ui-1.css">
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
<!-- navigation -->
<!-- //navigation -->
<!-- breadcrumbs -->
	<div class="breadcrumbs">
		<div class="container">
			<ol class="breadcrumb breadcrumb1 animated wow slideInLeft" data-wow-delay=".5s">
				<c:choose>
					<c:when test="${sessionScope.rid==null }">
						<li><a href="../home/visit"><span class="glyphicon glyphicon-home" aria-hidden="true"></span>主页</a></li>
						<li class="active">${restaurant.rname }</li>
					</c:when>
					<c:when test="${sessionScope.rid!=null }">
						<li style="color:#3399cc"><a href="${pageContext.request.contextPath }/restaurantInfo/visitRestaurantByRid?rid=${restaurant.rid}">
							<span class="glyphicon glyphicon-home" aria-hidden="true"></span>${restaurant.rname }</a></li>
					</c:when>
				</c:choose>
				
			</ol>
		</div>
	</div>
<!-- //breadcrumbs -->
<!--- products --->
	<div class="products">
		<div class="container">
			<div class="col-md-4 products-left">
				<div class="categories">
					<h2>特色分类</h2>
					<ul class="cate">
						<!-- <form action="../restaurantInfo/visitRestaurantByRid"> -->
							<c:forEach items="${meauInfoList }" var="meau">
								<li><a href="${pageContext.request.contextPath }/restaurantInfo/selectByMid?mid=${meau.mid}">
									<i class="fa fa-arrow-right" aria-hidden="true"></i>${meau.mname}</a></li>
							</c:forEach>
						<!-- </form> -->
					</ul>
				</div>																																												
			</div>
			<div class="col-md-8 products-right">
				<div class="products-right-grid">
					<div class="products-right-grids">
					<c:choose>
						<c:when test="${isSearchFood==0 }">
							<div class="sorting">
								<select id="country" onchange="window.location=this.value" class="frm-field required sect">
									<option value="null"><i class="fa fa-arrow-right" aria-hidden="true"></i>请选择分类</option>
									<option value="${pageContext.request.contextPath }/restaurantInfo/selectByMid?mid=${mid}"><i class="fa fa-arrow-right" aria-hidden="true"></i>默认排序</option>
									<option value="${pageContext.request.contextPath }/restaurantInfo/selectBySales_volume?mid=${mid}"><i class="fa fa-arrow-right" aria-hidden="true"></i>销量</option> 
									<option value="${pageContext.request.contextPath }/restaurantInfo/selectByPrice?mid=${mid}"><i class="fa fa-arrow-right" aria-hidden="true"></i>价格低到高</option>					
									<option value="${pageContext.request.contextPath }/restaurantInfo/selectByPrice1?mid=${mid}"><i class="fa fa-arrow-right" aria-hidden="true"></i>价格高到低</option>								
								</select>
							</div>
						</c:when>
						<%-- <c:when test="${isSearchFood==1 }">
							
						</c:when> --%>
					</c:choose>
						<div class="sorting-left">
							<select id="country1" onchange="window.location=this.value" class="frm-field required sect">
								<option value="null"><i class="fa fa-arrow-right" aria-hidden="true"></i>请选择页数</option>
								<c:set var="page" value="0" />
								<c:forEach var="i" begin="1" end="${pageNum }">
									<c:set var="page" value="${page+1 }" />
										<%-- <a href="${pageContext.request.contextPath }/restaurantInfo/pageFood?pageId=${page}&mid=${mid}"> --%>
											<option value="${pageContext.request.contextPath }/restaurantInfo/pageFood?pageId=${page}&mid=${mid}">
												<i class="fa fa-arrow-right" aria-hidden="true"></i>第${page }页</option><!-- </a> -->
								</c:forEach>
								 
							</select>
						</div>
						<div class="clearfix"> </div>
					</div>
				</div>
				<c:set var="time" value="0" />
				<div class="agile_top_brands_grids">
					<c:forEach items="${foodInfoList }" var="food">
					<c:set var="time" value="${time+1 }"/>
					<div class="col-md-4 top_brand_left">
						<div class="hover14 column">
							<div class="agile_top_brand_left_grid">
								<div class="agile_top_brand_left_grid_pos">
									<img src="../jsp/images/offer.png" alt=" " class="img-responsive">
								</div>
								<div class="agile_top_brand_left_grid1">
									<figure>
										<div class="snipcart-item block">
											<div class="snipcart-thumb">
												<div class="snipcart-img">
													<img title=" " alt=" " src="${food.fphoto }">
													<div class="snipcart-img-hide">
														<div class="hidden_info">
															${food.fdescription}
														</div>
													</div>
												</div>	
												<p>${food.fname }</p>
												<h4>¥${food.fprice }</h4><!-- <span>$55.00</span> -->
												<p>月售${food.fsales_volume }&nbsp;&nbsp;&nbsp;&nbsp;${food.great }人推荐</p>
												<!-- <div class="quantity"> 
													<div class="quantity-select">                           
														<div class="entry value-minus">&nbsp;</div>
														<div class="entry value"><span>1</span></div>
														<div class="entry value-plus active">&nbsp;</div>
													</div>
												</div> -->
												<div class="snipcart-details top_brand_home_details">
													<%-- <form action="#" method="post">
														<fieldset>
															<input type="hidden" name="cmd" value="_cart">
															<input type="hidden" name="add" value="1">
															<input type="hidden" name="business" value=" ">
															<input type="hidden" name="fid" value="${food.fid }">
															<input type="hidden" name="item_name" value="${food.fname }">
															<input type="hidden" name="amount" value="${food.fprice }">
															<input type="hidden" name="discount_amount" value="0">
															<input type="hidden" name="currency_code" value="USD">
															<input type="hidden" name="return" value=" ">
															<input type="hidden" name="cancel_return" value=" "> --%>
															<a href="../shopping_trolleyInfo/AddFoodToShopping_trolley?fid=${food.fid }&rid=${restaurant.rid }">
																<input type="submit" name="submit" value="添加进购物车" class="button"></a>
														<!-- </fieldset>
													</form> -->
												</div>
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
														<a href="${pageContext.request.contextPath }/restaurantInfo/pageFood?pageId=${previous}&mid=${mid}" aria-label="Previous">
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
														<a href="${pageContext.request.contextPath }/restaurantInfo/pageFood?pageId=${page}&mid=${mid}">${page }<span class="sr-only">(current)</span></a></li>
													</c:when>
													<c:otherwise>
														<li><a href="${pageContext.request.contextPath }/restaurantInfo/pageFood?pageId=${page}&mid=${mid}">${page }</a></li>
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
														<a href="${pageContext.request.contextPath }/restaurantInfo/pageFood?pageId=${next}&mid=${mid}" aria-label="Next">
															<span aria-hidden="true">&raquo;</span>
														</a>
													</li>
												</c:otherwise>
											</c:choose>
										</ul>
									</nav>
								<!-- <div class="clearfix"> </div> -->
							</div>
			</div>
			<div class="clearfix"> </div>
		</div>
	</div>
<!--- products --->
<!-- //footer -->
	<jsp:include page="footer.jsp"></jsp:include>
<!-- //footer -->	
<!-- 自己写的script -->
<script>
	
</script>

<!-- 加的script -->
<!-- <script>$(document).ready(function(c) {
	$('.close1').on('click', function(c){
	$('.rem1').fadeOut('slow', function(c){
	$('.rem1').remove();
		});
	});
});
</script> -->
<!--quantity-->
<!-- <script>
	$('.value-plus').on('click', function(){
		var divUpd = $(this).parent().find('.value'), newVal = parseInt(divUpd.text(), 10)+1;
		divUpd.text(newVal);
	});

	$('.value-minus').on('click', function(){
		var divUpd = $(this).parent().find('.value'), newVal = parseInt(divUpd.text(), 10)-1;
		if(newVal>=1) divUpd.text(newVal);
	});
</script> -->
<!--quantity-->

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