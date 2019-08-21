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
<title>餐馆列表</title>
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 
	<span class="c-gray en">&gt;</span> 餐馆管理 
	<span class="c-gray en">&gt;</span> 餐馆列表 
		<a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" >
			<i class="Hui-iconfont">&#xe68f;</i></a>
</nav>
<div class="page-container">
	<div class="text-c"> 
	<c:choose>
		<c:when test="${sessionScope.rid==null }">
		<form action="${pageContext.request.contextPath }/restaurantInfo/selectByRid" method="post">
			<input type="text" class="input-text" style="width:250px" placeholder="输入餐馆ID" id="" name="rid1">
				<button type="submit" class="btn btn-success radius" id="" name="">
					<i class="Hui-iconfont">&#xe665;</i> 搜餐馆</button>
		</form>
		</c:when>
	</c:choose>
	</div>
	<div class="cl pd-5 bg-1 bk-gray mt-20"> <span class="l">
	<c:choose>
		<c:when test="${sessionScope.rid==null }">
		<a href="javascript:;" onclick="delManyData()" class="btn btn-danger radius">
			<i class="Hui-iconfont">&#xe6e2;</i> 批量删除</a> 
		<a href="../restaurantInfo/jumpToAdd"  class="btn btn-primary radius">
			<i class="Hui-iconfont">&#xe600;</i> 添加餐馆</a>
		<a href="${pageContext.request.contextPath }/restaurantInfo/selectAll" class="btn btn-success radius">
			<i class="Hui-iconfont">&#xe665;</i> 查询所有信息</a> 
		</c:when>
	</c:choose>
	</span> 
	<!-- <span class="r">共有数据：<strong>88</strong> 条</span> --> 
	</div>
	<div class="mt-20">
	<table class="table table-border table-bordered table-hover table-bg table-sort">
		<thead>
			<tr class="text-c">
				<th width="25"><input type="checkbox" name="" value=""></th>
				<th width="40">RID</th>
				<th width="100">餐馆名称</th>
				<th width="100">餐馆图片</th>
				<th width="40">餐馆评分</th>
				<th width="40">起送费</th>
				<th width="40">配送费</th>
				<th width="40">人均消费</th>
				<th width="40">是否到店自取</th>
				<th width="40">销量</th>
				<th width="40">餐馆类型</th>
				<th width="40">送餐准备时间</th>
				<th width="40">送餐速度</th>
				<th width="40">x坐标</th>
				<th width="40">y坐标</th>
				<th width="100">餐馆描述</th>
				<c:choose>
					<c:when test="${sessionScope.rid==null }">
						<th width="40">时间</th>
						<th width="40">距离</th>
					</c:when>
				</c:choose>
				<th width="40">是否推荐</th>
				<c:choose>
					<c:when test="${sessionScope.rid==null }">
						<th width="40">BID</th>
					</c:when>
				</c:choose>	
				<th width="100">操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${riList }" var="ri">
			<tr class="text-c">
				<td><input type="checkbox" value="${ri.rid }" name="check"></td>
				<td>${ri.rid}</td>
				<td>${ri.rname}</td>
				<td>${ri.rphoto}</td>
				<td>${ri.rstar}</td>
				<td>${ri.sending_fee}</td>
				<td>${ri.shipping_fee}</td>
				<td>${ri.cpc}</td>
				<td>${ri.arrival}</td>
				<td>${ri.rsales_volume}</td>
				<td>${ri.rcategory}</td>
				<td>${ri.rprepare_time}</td>
				<td>${ri.rvelocity}</td>
				<td>${ri.rx_coordinate}</td>
				<td>${ri.ry_coordinate}</td>
				<td>${ri.rdescription}</td>
				<c:choose>
					<c:when test="${sessionScope.rid==null }">
						<td>${ri.minute}</td>
						<td>${ri.distance}</td>
					</c:when>
				</c:choose>
				<td>${ri.rrecommendation}</td>
				<c:choose>
					<c:when test="${sessionScope.rid==null }">
						<td>${ri.bid}</td>
					</c:when>
				</c:choose>
				<td class="td-manage"> 
					<a title="修改" href="${pageContext.request.contextPath }/restaurantInfo/jumpToUpdate?rid=${ri.rid}" style="text-decoration:none">
						<i class="Hui-iconfont">&#xe6df;</i></a>
					<c:choose>
						<c:when test="${sessionScope.rid==null }"> 
					<a title="删除" href="${pageContext.request.contextPath }/restaurantInfo/deleteRestaurant?rid=${ri.rid}" class="ml-5" style="text-decoration:none">
						<i class="Hui-iconfont">&#xe6e2;</i></a>
						</c:when>
					</c:choose>
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
	if(${sessionScope.rid==null }){
		$('.table-sort').dataTable({
			"aaSorting": [[ 1, "asc" ]],//默认第几个排序
			"bStateSave": true,//状态保存
			"aoColumnDefs": [
			  //{"bVisible": false, "aTargets": [ 3 ]} //控制列的隐藏显示
			  {"orderable":false,"aTargets":[0,2,3,10,15,20]}// 制定列不参与排序
			]
		});
	}
	else{
		$('.table-sort').dataTable({
			"aaSorting": [[ 1, "asc" ]],//默认第几个排序
			"bStateSave": true,//状态保存
			"aoColumnDefs": [
			  //{"bVisible": false, "aTargets": [ 3 ]} //控制列的隐藏显示
			  {"orderable":false,"aTargets":[0,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17]}// 制定列不参与排序
			]
		});
	}
	
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
	location.href="${pageContext.request.contextPath }/restaurantInfo/deleteManyRestaurant?str="+str;
}
</script>  
</body>
</html>
