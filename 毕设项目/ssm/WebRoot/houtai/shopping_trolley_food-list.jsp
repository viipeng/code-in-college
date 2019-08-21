<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
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
<title>购物车菜品列表</title>
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 
	<span class="c-gray en">&gt;</span> 购物车菜品管理 
	<span class="c-gray en">&gt;</span> 购物车菜品列表 
		<a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" >
			<i class="Hui-iconfont">&#xe68f;</i></a>
</nav>
<div class="page-container">
	<div class="text-c"> 
		<form action="${pageContext.request.contextPath }/shopping_trolley_food/selectBySfid" method="post">
			<input type="text" class="input-text" style="width:250px" placeholder="输入购物车菜品号" id="" name="sfid1">
				<button type="submit" class="btn btn-success radius" id="" name="">
					<i class="Hui-iconfont">&#xe665;</i> 搜购物车菜品</button>
		</form>
	</div>
	<div class="cl pd-5 bg-1 bk-gray mt-20"> <span class="l">
		<a href="javascript:;" onclick="delManyData()" class="btn btn-danger radius">
			<i class="Hui-iconfont">&#xe6e2;</i> 批量删除</a> 
		<a href="../shopping_trolley_food/jumpToAdd"  class="btn btn-primary radius">
			<i class="Hui-iconfont">&#xe600;</i> 添加购物车菜品</a>
		<a href="${pageContext.request.contextPath }/shopping_trolley_food/selectAll" class="btn btn-success radius">
			<i class="Hui-iconfont">&#xe665;</i> 查询所有信息</a> 
	</span> 
	<!-- <span class="r">共有数据：<strong>88</strong> 条</span> --> 
	</div>
	<div class="mt-20">
	<table class="table table-border table-bordered table-hover table-bg table-sort">
		<thead>
			<tr class="text-c">
				<th width="25"><input type="checkbox" name="" value=""></th>
				<th width="40">SFID</th>
				<th width="40">FID</th>
				<th width="100">菜品名</th>        
				<th width="100">菜品图片</th>
				<th width="40">单价</th>
				<th width="40">数量</th>
				<th width="40">SID</th>
				<th width="100">操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${sfList }" var="sf">
			<tr class="text-c">
				<td><input type="checkbox" value="${sf.sfid }" name="check"></td>
				<td>${sf.sfid}</td>
				<td>${sf.fid}</td>
				<td>${sf.fname}</td>
				<td>${sf.fphoto}</td>
				<td>${sf.fprice}</td>
				<td>${sf.amount}</td>
				<td>${sf.sid}</td>
				<td class="td-manage"> 
					<a title="修改" href="${pageContext.request.contextPath }/shopping_trolley_food/jumpToUpdate?sfid=${sf.sfid}" style="text-decoration:none">
						<i class="Hui-iconfont">&#xe6df;</i></a> 
					<a title="删除" href="${pageContext.request.contextPath }/shopping_trolley_food/deleteShopping_trolley_food?sfid=${sf.sfid}" class="ml-5" style="text-decoration:none">
						<i class="Hui-iconfont">&#xe6e2;</i></a>
				</td>
			</tr>
		    </c:forEach>
		</tbody>
	</table>
	</div>
</div>
<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="../houtai/lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="../houtai/lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="../houtai/static/h-ui/js/H-ui.min.js"></script> 
<script type="text/javascript" src="../houtai/static/h-ui.admin/js/H-ui.admin.js"></script> <!--/_footer 作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="../houtai/lib/My97DatePicker/4.8/WdatePicker.js"></script> 
<script type="text/javascript" src="../houtai/lib/datatables/1.10.0/jquery.dataTables.min.js"></script> 
<script type="text/javascript" src="../houtai/lib/laypage/1.2/laypage.js"></script>
<script type="text/javascript">
$(function(){
	$('.table-sort').dataTable({
		"aaSorting": [[ 1, "asc" ]],//默认第几个排序
		"bStateSave": true,//状态保存
		"aoColumnDefs": [
		  //{"bVisible": false, "aTargets": [ 3 ]} //控制列的隐藏显示
		  {"orderable":false,"aTargets":[0,3,4,8]}// 制定列不参与排序
		]
	});
	
});
/* 删除多组数据 */
function delManyData(){
	if(!confirm("确定要删除这些数据吗？")){
		return;
	}
	var cks= document.getElementsByName("check");
	var str="";
	//拼接所有id
	for(var i=0; i<cks.length; i++){
		if(cks[i].checked){
			str+= "id="+cks[i].value+"|";
/* 			alert(cks[i].value); */
		}
	}
	//去掉字符串末尾的‘|’
	/* alert(str); */
	str= str.substring(0, str.length-1);
	/* alert(str); */
	location.href="${pageContext.request.contextPath }/shopping_trolley_food/deleteManyShopping_trolley_food?str="+str;
}
</script>  
</body>
</html>