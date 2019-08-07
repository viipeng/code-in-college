<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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

<title>新增用户 </title>
<meta name="keywords" content="网络订餐平台">
<meta name="description" content="添加用户">
</head>
<body>
<article class="page-container"> 
	<form action="${pageContext.request.contextPath }/userInfo/addUser" method="post" class="form form-horizontal" onsubmit="return check()"><!-- id="form-member-add" --> 
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>用户名：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="" placeholder="" id="username" name="username" required=" " >
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>密码：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="" placeholder="" id="password" name="password" required=" " >
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>性别：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<!-- <input type="text" class="input-text" value="" placeholder="" id="usex" name="usex"> -->
				<input type="radio" id="usex" name="usex" value="1" >男&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="radio" id="usex" name="usex" value="2" >女&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>账户余额：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="" placeholder="" id="account_balance" name="account_balance" >
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>x坐标：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="" placeholder="" id="ux_coordinate" name="ux_coordinate" required=" " >
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>y坐标：</label>
			<div class="formControls col-xs-8 col-sm-9">
				<input type="text" class="input-text" value="" placeholder="" id="uy_coordinate" name="uy_coordinate" required=" " >
			</div>
		</div>

		<div class="row cl">
			<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-3">
				<input class="btn btn-primary radius" type="submit" value="&nbsp;提&nbsp;&nbsp;交&nbsp;">
			</div>
		</div>
	</form>
</article>

<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="static/h-ui/js/H-ui.min.js"></script> 
<script type="text/javascript" src="static/h-ui.admin/js/H-ui.admin.js"></script> <!--/_footer 作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本--> 
<script type="text/javascript" src="lib/My97DatePicker/4.8/WdatePicker.js"></script>
<script type="text/javascript" src="lib/jquery.validation/1.14.0/jquery.validate.js"></script> 
<script type="text/javascript" src="lib/jquery.validation/1.14.0/validate-methods.js"></script> 
<script type="text/javascript" src="lib/jquery.validation/1.14.0/messages_zh.js" charset="utf-8"></script>
<script type="text/javascript">
$(function(){
	$('.skin-minimal input').iCheck({
		checkboxClass: 'icheckbox-blue',
		radioClass: 'iradio-blue',
		increaseArea: '20%'
	});
	
	$("#form-member-add").validate({
		rules:{
			username:{
				required:true,
				minlength:2,
				maxlength:16
			},
			password:{
				required:true,
				minlength:2,
				maxlength:16
			},
			usex:{
				required:true,
				number:true
			},
			account_balance:{
				number:true,
			},
			ux_coordinate:{
				required:true,
				number:true,
				max:9,
				min:0
			},
			uy_coordinate:{
				required:true,
				number:true,
				max:9,
				min:0
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
	if(isNaN(document.getElementById('account_balance').value)){
		alert('账户余额只能输入数字');
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
</body>
</html>
