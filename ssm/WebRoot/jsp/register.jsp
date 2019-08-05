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
<title>注册</title>
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
	<jsp:include page="header.jsp"></jsp:include>
<!-- //header -->
<!-- navigation -->
	<!-- 包括在了header.jsp中 -->
<!-- //navigation -->
<!-- breadcrumbs -->
	<div class="breadcrumbs">
		<div class="container">
			<ol class="breadcrumb breadcrumb1 animated wow slideInLeft" data-wow-delay=".5s">
				<li><a href="../home/visit"><span class="glyphicon glyphicon-home" aria-hidden="true"></span>主页</a></li>
				<li class="active">注册页面</li>
			</ol>
		</div>
	</div>
<!-- //breadcrumbs -->
<!-- register -->
	<div class="register">
		<div class="container">
			<h2>欢迎注册网络订餐平台</h2>
			<div class="login-form-grids">
				<form action="../userInfo/register" method="post" onsubmit="return check()">
					<span>用户名：</span>
					<input type="text" placeholder="请输入用户名" name="username" id="username" required=" " >
					<span>密码：</span>
					<input type="password" placeholder="请输入密码" name="password" id="password" required=" " >
					<span>密码：</span>
					<input type="password" placeholder="请再次输入密码" name="bipassword" id="bipassword" required=" " >
					<span>性别：</span>
					<input type="text" placeholder="请输入1或2（1代表男，2代表女）" name="usex" id="usex" required=" " >
					<span>x坐标：</span>
					<input type="text" placeholder="请输入x坐标（0~10之间的数字）" name="ux_coordinate" id="ux_coordinate" required=" " >
					<span>y坐标：</span>
					<input type="text" placeholder="请输入y坐标（0~10之间的数字）" name="uy_coordinate" id="uy_coordinate" required=" " >
					<div class="register-check-box">
						<div class="check">
							<!-- 这里加一个隐私条款链接 -->
							<label class="checkbox"><input type="checkbox" name="checkbox"><i> </i>我同意用户协议</label>
						</div>
					</div>
					<input type="submit" value=" 注   册 ">
				</form>
			</div>
			<div class="register-home">
				<a href="../home/visit">主页</a>
			</div>
		</div>
	</div>
<!-- //register -->
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
<script type="text/javascript">
  function check(){
  	/* if(document.getElementById('username').value==''){
  		alert('用户名不能为空');
  		return false;
  	}
  	else if(document.getElementById('password').value==''){
  		alert('密码不能为空');
  		return false;
  	} */
  	if(document.getElementById('password').value!=
  			document.getElementById('bipassword').value){
  		alert('两次密码输入不一致');
  		return false;
  	}
  	/* else if(document.getElementById('usex').value==''){
  		alert('性别不能为空');
  		return false;
  	} */
  	else if(document.getElementById('usex').value!='1'
  			&& document.getElementById('usex').value!='2'){
  		alert('性别输入错误，只能1或2，1代表男，2代表女');
  		return false;
  	}
	else if(isNaN(document.getElementById('ux_coordinate').value)){
		alert('x坐标只能输入数字');
        return false;
    }
  	else if(document.getElementById('ux_coordinate').value<0
			|| document.getElementById('ux_coordinate').value>9){
		alert('x坐标输入错误，只能输入0~9之间的数字');
		return false;
	}
	else if(isNaN(document.getElementById('uy_coordinate').value)){
		alert('y坐标只能输入数字');
        return false;
    }
  	else if(document.getElementById('uy_coordinate').value<0
  			|| document.getElementById('uy_coordinate').value>9){
		alert('y坐标输入错误，只能输入0~9之间的数字');
		return false;
	}
  	else{
  		return true;
  	}
  }
  </script>
<!-- //main slider-banner --> 

</body>
</html>