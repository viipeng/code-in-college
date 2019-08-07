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

<title>新增菜品 </title>
<meta name="keywords" content="网络订餐系统">
<meta name="description" content="修改菜品信息">
</head>
<body>
<article class="page-container"> 
	<form action="${pageContext.request.contextPath }/shopping_trolleyInfo/updateSTInfo" method="post" class="form form-horizontal" onsubmit="return check()"><!-- id="form-member-add" --> 
		<c:forEach items="${stiList }" var="sti">
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>SID：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="${sti.sid }" placeholder="" id="sid" name="sid" readonly="true" >
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>总价钱：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="${sti.total }" placeholder="" id="total" name="total">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>菜品数量：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="${sti.foodSum }" placeholder="" id="foodSum" name="foodSum">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>配送费：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="${sti.shipping_fee }" placeholder="" id="shipping_fee" name="shipping_fee">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>UID：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="${sti.uid }" placeholder="" id="uid" name="uid">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>RID：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="${sti.rid }" placeholder="" id="rid" name="rid">
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
			fname:{
				required:true,
				minlength:2,
				maxlength:16
			},
			fphoto:{
				required:true,
			},
			fprice:{
				required:true,
				number:true,
			},
			fevaluation:{
				required:true,
				number:true,
				range:[1,5]
			},
			score:{
				required:true,
				number:true,
				min:1
			},
			mid:{
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
	if(isNaN(document.getElementById('total').value)){
		alert('总价钱只能输入数字');
		return false;
	}
	else if(isNaN(document.getElementById('foodSum').value)){
		alert('菜品数量只能输入数字');
        return false;
    }
	else if(isNaN(document.getElementById('shipping_fee').value)){
		alert('配送费只能输入数字');
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
