<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!--_meta 作为公共模版分离出去-->
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link rel="Bookmark" href="/favicon.ico" >
<link rel="Shortcut Icon" href="/favicon.ico" />
<!--[if lt IE 9]>
<script type="text/javascript" src="lib/html5shiv.js"></script>
<script type="text/javascript" src="lib/respond.min.js"></script>
<![endif]-->
<link rel="stylesheet" type="text/css" href="../houtai/static/h-ui/css/H-ui.min.css" />
<link rel="stylesheet" type="text/css" href="../houtai/static/h-ui.admin/css/H-ui.admin.css" />
<link rel="stylesheet" type="text/css" href="../houtai/lib/Hui-iconfont/1.0.8/iconfont.css" />
<link rel="stylesheet" type="text/css" href="../houtai/static/h-ui.admin/skin/default/skin.css" id="skin" />
<link rel="stylesheet" type="text/css" href="../houtai/static/h-ui.admin/css/style.css" />
<!--[if IE 6]>
<script type="text/javascript" src="lib/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<!--/meta 作为公共模版分离出去-->

<title>修改餐馆 </title>
<meta name="keywords" content="网络订餐平台">
<meta name="description" content="修改餐馆信息">
</head>
<body>
<article class="page-container"> 
	<form action="${pageContext.request.contextPath }/restaurantInfo/updateRestaurant" method="post" class="form form-horizontal" onsubmit="return check()"> <!-- id="form-member-add" -->
		<c:forEach items="${riList }" var="ri">
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>餐馆ID：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="${ri.rid }" placeholder="" id="rid" name="rid" readonly="true" >
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>餐馆名称：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="${ri.rname }" placeholder="" id="rname" name="rname">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>餐馆图片：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="${ri.rphoto }" placeholder="" id="rphoto" name="rphoto">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>餐馆评分：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<c:choose>
					<c:when test="${sessionScope.rid==null }">
						<input type="text" class="input-text" value="${ri.rstar }" placeholder="" id="rstar" name="rstar">
					</c:when>
					<c:when test="${sessionScope.rid!=null }">
						<input type="text" class="input-text" value="${ri.rstar }" placeholder="" id="rstar" name="rstar" readonly="true">
					</c:when>
				</c:choose>
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>起送费：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="${ri.sending_fee }" placeholder="" id="sending_fee" name="sending_fee">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>配送费：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="${ri.shipping_fee }" placeholder="" id="shipping_fee" name="shipping_fee">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>人均消费：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<c:choose>
					<c:when test="${sessionScope.rid==null }">
						<input type="text" class="input-text" value="${ri.cpc }" placeholder="" id="cpc" name="cpc">
					</c:when>
					<c:when test="${sessionScope.rid!=null }">
						<input type="text" class="input-text" value="${ri.cpc }" placeholder="" id="cpc" name="cpc" readonly="true">
					</c:when>
				</c:choose>
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>是否到店自取：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<!-- <input type="text" class="input-text" value="" placeholder="" id="arrival" name="arrival"> -->
				<c:choose>
					<c:when test="${ri.arrival==1}">
						<input type="radio" id="arrival" name="arrival" value="1" checked="true" >是&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="radio" id="arrival" name="arrival" value="0" >否&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					</c:when>
					<c:when test="${ri.arrival==0}">
						<input type="radio" id="arrival" name="arrival" value="1" >是&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="radio" id="arrival" name="arrival" value="0" checked="true" >否&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					</c:when>
				</c:choose>
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>销量：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<c:choose>
					<c:when test="${sessionScope.rid==null }">
						<input type="text" class="input-text" value="${ri.rsales_volume }" placeholder="" id="rsales_volume" name="rsales_volume">
					</c:when>
					<c:when test="${sessionScope.rid!=null }">
						<input type="text" class="input-text" value="${ri.rsales_volume }" placeholder="" id="rsales_volume" name="rsales_volume" readonly="true">
					</c:when>
				</c:choose>
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>餐馆类型：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="${ri.rcategory }" placeholder="" id="rcategory" name="rcategory">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>送餐准备时间：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="${ri.rprepare_time }" placeholder="" id="rprepare_time" name="rprepare_time">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>送餐速度：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="${ri.rvelocity }" placeholder="" id="rvelocity" name="rvelocity">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>x坐标：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="${ri.rx_coordinate }" placeholder="" id="rx_coordinate" name="rx_coordinate">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>y坐标：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="${ri.ry_coordinate }" placeholder="" id="ry_coordinate" name="ry_coordinate">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>餐馆描述：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="${ri.rdescription }" placeholder="" id="rdescription" name="rdescription">
			</div>
		</div>
		<c:choose>
			<c:when test="${sessionScope.rid==null }">
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>时间：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="${ri.minute }" placeholder="不允许输入" id="minute" name="minute" readonly="true" >
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>距离：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="${ri.distance }" placeholder="不允许输入" id="distance" name="distance" readonly="true" >
			</div>
		</div>
			</c:when>
			<c:when test="${sessionScope.rid==null }">
				<input type="hidden" value="${ri.minute }" id="minute" name="minute" >
				<input type="hidden" value="${ri.distance }" id="distance" name="distance" >
			</c:when>
		</c:choose>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>是否推荐：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<!-- <input type="text" class="input-text" value="" placeholder="" id="rrecommendation" name="rrecommendation"> -->
				<c:choose>
					<c:when test="${ri.rrecommendation==1}">
						<input type="radio" id="rrecommendation" name="rrecommendation" value="1" checked="true" >是&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="radio" id="rrecommendation" name="rrecommendation" value="0" >否&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					</c:when>
					<c:when test="${ri.rrecommendation==0}">
						<input type="radio" id="rrecommendation" name="rrecommendation" value="1" >是&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="radio" id="rrecommendation" name="rrecommendation" value="0" checked="true" >否&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					</c:when>
				</c:choose>
			</div>
		</div>
		<c:choose>
			<c:when test="${sessionScope.rid==null }">
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>BID：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="${ri.rid }" placeholder="" id="bid" name="bid">
			</div>
		</div>
			</c:when>
			<c:when test="${sessionScope.rid!=null }">
				<input type="hidden" value="${ri.rid }" id="bid" name="bid">
			</c:when>
		</c:choose>
		<div class="row cl">
			<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-3">
				<input class="btn btn-primary radius" type="submit" value="&nbsp;提&nbsp;&nbsp;交&nbsp;">
			</div>
		</div>
		</c:forEach>
	</form>
</article>

<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="../houtai/lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="../houtai/lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="../houtai/static/h-ui/js/H-ui.min.js"></script> 
<script type="text/javascript" src="../houtai/static/h-ui.admin/js/H-ui.admin.js"></script> <!--/_footer 作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本--> 
<script type="text/javascript" src="../houtai/lib/My97DatePicker/4.8/WdatePicker.js"></script>
<script type="text/javascript" src="../houtai/lib/jquery.validation/1.14.0/jquery.validate.js"></script> 
<script type="text/javascript" src="../houtai/lib/jquery.validation/1.14.0/validate-methods.js"></script> 
<script type="text/javascript" src="../houtai/lib/jquery.validation/1.14.0/messages_zh.js"></script>
<script type="text/javascript">
$(function(){
	$('.skin-minimal input').iCheck({
		checkboxClass: 'icheckbox-blue',
		radioClass: 'iradio-blue',
		increaseArea: '20%'
	});
	
	$("#form-member-add").validate({
		rules:{
			rname:{
				required:true,
				minlength:2,
				maxlength:16
			},
			bid:{
				required:true,
				number:true,
				min:1
			},
		},
		onkeyup:false,
		focusCleanup:true,
		success:"valid",
	});
});
</script> 
<script type="text/javascript">
function check(){
	if(isNaN(document.getElementById('rstar').value)){
		alert('餐馆评分只能输入数字');
		return false;
	}
	else if(isNaN(document.getElementById('sending_fee').value)){
		alert('起送费只能输入数字');
        return false;
    }
	else if(isNaN(document.getElementById('shipping_fee').value)){
		alert('配送费只能输入数字');
        return false;
    }
	else if(isNaN(document.getElementById('cpc').value)){
		alert('人均消费只能输入数字');
        return false;
    }
	else if(isNaN(document.getElementById('rsales_volume').value)){
		alert('销量只能输入数字');
        return false;
    }
	else if(isNaN(document.getElementById('rprepare_time').value)){
		alert('送餐准备时间只能输入数字');
        return false;
    }
	else if(isNaN(document.getElementById('rvelocity').value)){
		alert('送餐速度只能输入数字');
        return false;
    }
	else if(isNaN(document.getElementById('rx_coordinate').value)){
		alert('x坐标只能输入数字');
        return false;
    }
	else if(isNaN(document.getElementById('ry_coordinate').value)){
		alert('y坐标只能输入数字');
        return false;
    }
	else if(isNaN(document.getElementById('bid').value)){
		alert('BID只能输入数字');
        return false;
    }
	else{
		return true;
	}
  }
</script> 
</body>
</html>
