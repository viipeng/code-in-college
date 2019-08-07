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

<title>修改订单 </title>
<meta name="keywords" content="网络订餐平台">
<meta name="description" content="修改订单信息">
</head>
<body>
<article class="page-container"> 
	<form action="${pageContext.request.contextPath }/orderInfo/updateOrderInfo" method="post" class="form form-horizontal" onsubmit="return check()"><!--  id="form-member-add" -->
		<c:forEach items="${oiList }" var="oi">
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>OID：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="${oi.oid }" placeholder="" id="oid" name="oid" readonly="true" >
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>餐馆名称：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="${oi.rname }" placeholder="" id="rname" name="rname">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>餐馆图片：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="${oi.rphoto }" placeholder="" id="rphoto" name="rphoto">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>所有的菜品：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="${oi.all_food }" placeholder="" id="all_food" name="all_food">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>消费：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="${oi.consumption }" placeholder="" id="consumption" name="consumption">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>订单状态：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<%-- <input type="text" class="input-text" value="${oi.ostate }" placeholder="" id="ostate" name="ostate"> --%>
				<c:choose>
					<c:when test="${oi.ostate=='待付款'}">
						<input type="radio" id="ostate" name="ostate" value="待付款" checked="true" >待付款&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="radio" id="ostate" name="ostate" value="途中" >途中&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="radio" id="ostate" name="ostate" value="待评价" >待评价&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="radio" id="ostate" name="ostate" value="完成" >完成&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="radio" id="ostate" name="ostate" value="待退款" >待退款&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="radio" id="ostate" name="ostate" value="已退款" >已退款&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					</c:when>
					<c:when test="${oi.ostate=='途中'}">
						<input type="radio" id="ostate" name="ostate" value="待付款" >待付款&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="radio" id="ostate" name="ostate" value="途中" checked="true" >途中&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="radio" id="ostate" name="ostate" value="待评价" >待评价&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="radio" id="ostate" name="ostate" value="完成" >完成&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="radio" id="ostate" name="ostate" value="待退款" >待退款&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="radio" id="ostate" name="ostate" value="已退款" >已退款&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					</c:when>
					<c:when test="${oi.ostate=='待评价'}">
						<input type="radio" id="ostate" name="ostate" value="待付款" >待付款&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="radio" id="ostate" name="ostate" value="途中" >途中&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="radio" id="ostate" name="ostate" value="待评价" checked="true" >待评价&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="radio" id="ostate" name="ostate" value="完成" >完成&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="radio" id="ostate" name="ostate" value="待退款" >待退款&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="radio" id="ostate" name="ostate" value="已退款" >已退款&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					</c:when>
					<c:when test="${oi.ostate=='完成'}">
						<input type="radio" id="ostate" name="ostate" value="待付款" >待付款&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="radio" id="ostate" name="ostate" value="途中" >途中&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="radio" id="ostate" name="ostate" value="待评价" >待评价&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="radio" id="ostate" name="ostate" value="完成" checked="true" >完成&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="radio" id="ostate" name="ostate" value="待退款" >待退款&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="radio" id="ostate" name="ostate" value="已退款" >已退款&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					</c:when>
					<c:when test="${oi.ostate=='待退款'}">
						<input type="radio" id="ostate" name="ostate" value="待付款" >待付款&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="radio" id="ostate" name="ostate" value="途中" >途中&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="radio" id="ostate" name="ostate" value="待评价" >待评价&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="radio" id="ostate" name="ostate" value="完成" >完成&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="radio" id="ostate" name="ostate" value="待退款" checked="true" >待退款&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="radio" id="ostate" name="ostate" value="已退款" >已退款&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					</c:when>
					<c:when test="${oi.ostate=='已退款'}">
						<input type="radio" id="ostate" name="ostate" value="待付款" >待付款&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="radio" id="ostate" name="ostate" value="途中" >途中&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="radio" id="ostate" name="ostate" value="待评价" >待评价&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="radio" id="ostate" name="ostate" value="完成" >完成&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="radio" id="ostate" name="ostate" value="待退款" >待退款&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="radio" id="ostate" name="ostate" value="已退款" checked="true" >已退款&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					</c:when>
				</c:choose>
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>下单日期：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="${oi.odate }" placeholder="" id="odate" name="odate">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>是否可见：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<%-- <input type="text" class="input-text" value="${oi.visible }" placeholder="" id="visible" name="visible"> --%>
				<c:choose>
					<c:when test="${oi.visible==1}">
						<input type="radio" id="visible" name="visible" value="1" checked="true" >是&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="radio" id="visible" name="visible" value="0" >否&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					</c:when>
					<c:when test="${oi.visible==0}">
						<input type="radio" id="visible" name="visible" value="1" >是&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="radio" id="visible" name="visible" value="0" checked="true" >否&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					</c:when>
				</c:choose>
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>UID：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="${oi.uid }" placeholder="" id="uid" name="uid">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>RID：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="${oi.rid }" placeholder="" id="rid" name="rid">
			</div>
		</div>
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
			ostate:{
				required:true,
				minlength:2,
				maxlength:2
			},
			odate:{
				required:true,
			},
			oevaluation:{
				required:true,
				number:true,
				range:[1,5]
			},
			uid:{
				required:true,
				number:true,
				min:1
			},
			did:{
				required:true,
				number:true,
				min:1
			},
			rid:{
				required:true,
				number:true,
				min:1
			},
			mid:{
				required:true,
				number:true,
				min:1
			},
			fid:{
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
	if(isNaN(document.getElementById('consumption').value)){
		alert('消费只能输入数字');
		return false;
	}
	else if(isNaN(document.getElementById('uid').value)){
		alert('UID只能输入数字');
        return false;
    }
	else if(isNaN(document.getElementById('rid').value)){
		alert('RID只能输入数字');
        return false;
    }
	else{
		return true;
	}
  }
</script> 
</body>
</html>
