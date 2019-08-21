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
<title>评论</title>
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
				<c:choose>
					<c:when test="${sessionScope.rid==null }">
						<li><a href="../home/visit"><span class="glyphicon glyphicon-home" aria-hidden="true"></span>主页</a></li>
						<li><a href="${pageContext.request.contextPath }/restaurantInfo/visitRestaurantByRid?rid=${restaurant.rid}">
							${restaurant.rname }</a></li>
						<li class="active">评论 </li>
					</c:when>
					<c:when test="${sessionScope.rid!=null }">
						<li style="color:#3399cc"><a href="${pageContext.request.contextPath }/restaurantInfo/visitRestaurantByRid?rid=${restaurant.rid}">
							<span class="glyphicon glyphicon-home" aria-hidden="true"></span>${restaurant.rname }</a></li>
						<li class="active">评论 </li>
					</c:when>
				</c:choose>
				
			</ol>
		</div>
	</div>
<!-- //breadcrumbs -->
<!-- content -->
	<div class="main">
		<div class="main-l">
			<!-- <div class="commentfilter">
				<a class="commentfilter-item ng-binding ng-scope active" >全部(252)</a>
				<a class="commentfilter-item ng-binding ng-scope" >满意(225)</a>
				<a class="commentfilter-item ng-binding ng-scope" >不满意(12)</a>
				<a class="commentfilter-item ng-binding ng-scope" >有图(12)</a>
			</div> -->
			<section class="comment-list" id="comment-list">
				<div class="comment-con" data-node="commCon">
					<c:forEach items="${evaluationList }" var="evaluation">
						<div class="list clearfix">
							<div class="top-section">
								<span class="user-name">${evaluation.username }</span>                
								<span class="rate">                    
									<span class="rate-inner">
										<c:forEach var="i" begin="1" end="${evaluation.estar }">
											<i class="fa fa-star blue-star" aria-hidden="true"></i>
										</c:forEach>
										<c:forEach var="i" begin="1" end="${5-evaluation.estar}">
											<i class="fa fa-star gray-star" aria-hidden="true"></i>
										</c:forEach>
									</span>
								</span>                
								${evaluation.estar }分               
								<!-- <span class="delivery-time">                    
									送餐时间：36分钟                
								</span>   -->              
								<span class="fr">${evaluation.edate }</span>        
							</div>        
							<div class="mid-section">            
								<p>${evaluation.content }</p>        
							</div>                    
							<div class="btm-section">
								<c:choose>
									<c:when test="${evaluation.is_recommend==1 }">
										推荐商品：                               
										<span class="rec-dish">${evaluation.all_food }</span>
									</c:when>
								</c:choose>                    
							</div>            
						</div>
					</c:forEach>
				</div>
				<!-- <div class="more-comment" data-node="moreCom" style="display:none;">
					正在加载请稍候</div> -->
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
														<a href="${pageContext.request.contextPath }/evaluation/pageEvaluation?pageId=${previous}&rid=${restaurant.rid}" aria-label="Previous">
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
														<a href="${pageContext.request.contextPath }/evaluation/pageEvaluation?pageId=${page}&rid=${restaurant.rid}">${page }<span class="sr-only">(current)</span></a></li>
													</c:when>
													<c:otherwise>
														<li><a href="${pageContext.request.contextPath }/evaluation/pageEvaluation?pageId=${page}&rid=${restaurant.rid}">${page }</a></li>
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
														<a href="${pageContext.request.contextPath }/evaluation/pageEvaluation?pageId=${next}&rid=${restaurant.rid}" aria-label="Next">
															<span aria-hidden="true">&raquo;</span>
														</a>
													</li>
												</c:otherwise>
											</c:choose>
										</ul>
									</nav>					
			</section>
		</div>
		<div class="side">
			<section class="comside">
				<div class="overall">
					<h3 class="title">总体评分</h3>
					<div class="rate-info">
						<div class="rate-num">${restaurant.rstar }</div>
							<p class="pos">
								<span class="rate">                    
									<span class="rate-inner">
										<c:forEach var="i" begin="1" end="${star }">
											<i class="fa fa-star blue-star" aria-hidden="true"></i>
										</c:forEach>
										<c:forEach var="i" begin="1" end="${5-star}">
											<i class="fa fa-star gray-star" aria-hidden="true"></i>
										</c:forEach>
									</span>
								</span> 
							</p>
							<p>
								<span>共${evaluationNum.sum }条评价</span>
							</p>
					</div>
					<table class="rate-table">
						<tbody>
							<tr>
								<td width="30px">5分</td>
								<td width="150px">
									<span class="pnum">
										<span class="pnum-inner" style="width:117.41935483871px"></span>
									</span>
								</td>
								<td>${evaluationNum.five }人</td>
							</tr>
							<tr>
								<td>4分</td>
								<td>
									<span class="pnum">
										<span class="pnum-inner" style="width:13.548387096774px"></span>
									</span>
								</td>
								<td>${evaluationNum.four }人</td>
							</tr>
							<tr>
								<td>3分</td>
								<td>
									<span class="pnum">
										<span class="pnum-inner" style="width:6.0215053763441px"></span>
									</span>
								</td>
								<td>${evaluationNum.three }人</td>
							</tr>
							<tr>
								<td>2分</td>
								<td>
									<span class="pnum">
										<span class="pnum-inner" style="width:0.90322580645161px"></span>
									</span>
								</td>
								<td>${evaluationNum.two }人</td>
							</tr>
							<tr>
								<td>1分</td>
								<td>
									<span class="pnum">
										<span class="pnum-inner" style="width:2.1075268817204px"></span>
									</span>
								</td>
								<td>${evaluationNum.one }人</td>
							</tr>
						</tbody>
					</table>
				</div>
			</section>
		</div>
	</div>
	</br>
	<div class="clearfix"> </div>
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
