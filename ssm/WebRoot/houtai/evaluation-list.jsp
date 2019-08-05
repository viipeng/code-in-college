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
<title>评论列表</title>
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 
	<span class="c-gray en">&gt;</span> 评论管理 
	<span class="c-gray en">&gt;</span> 评论列表 
		<a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" >
			<i class="Hui-iconfont">&#xe68f;</i></a>
</nav>
<div class="page-container">
	<div class="text-c"> 
		<form action="${pageContext.request.contextPath }/evaluation/selectByEid" method="post">
			<input type="text" class="input-text" style="width:250px" placeholder="输入评论ID" id="" name="eid1">
				<button type="submit" class="btn btn-success radius" id="" name="">
					<i class="Hui-iconfont">&#xe665;</i> 搜评论</button>
		</form>
	</div>
	<div class="cl pd-5 bg-1 bk-gray mt-20"> <span class="l">
	<c:choose>
		<c:when test="${sessionScope.rid==null }">
		<a href="javascript:;" onclick="delManyData()" class="btn btn-danger radius">
			<i class="Hui-iconfont">&#xe6e2;</i> 批量删除</a> 
		<a href="../evaluation/jumpToAdd"  class="btn btn-primary radius">
			<i class="Hui-iconfont">&#xe600;</i> 添加评论</a>
		</c:when>
	</c:choose>
		<a href="${pageContext.request.contextPath }/evaluation/selectAll" class="btn btn-success radius">
			<i class="Hui-iconfont">&#xe665;</i> 查询所有信息</a>
	</span>
	<!-- <span class="r">共有数据：<strong>88</strong> 条</span> --> 
	</div>
	<div class="mt-20">
	<table class="table table-border table-bordered table-hover table-bg table-sort">
		<thead>
			<tr class="text-c">
				<th width="25"><input type="checkbox" name="" value=""></th>
				<th width="40">EID</th>
				<th width="40">用户名</th>
				<th width="40">是否匿名</th>
				<th width="40">星级</th>
				<th width="100">日期</th>
				<th width="100">评论内容</th>
				<th width="40">是否推荐</th>
				<th width="100">推荐的菜品</th>
				<th width="40">OID</th>
				<c:choose>
					<c:when test="${sessionScope.rid==null }">
						<th width="40">UID</th>
						<th width="40">RID</th>
					</c:when>
				</c:choose>
				<th width="100">操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${evaluationList }" var="en">
			<tr class="text-c">
				<td><input type="checkbox" value="${en.eid }" name="check"></td>
				<td>${en.eid}</td>
				<td>${en.username}</td>
				<td>${en.anonymous}</td>
				<td>${en.estar}</td>
				<td>${en.edate}</td>
				<td>${en.content}</td>
				<td>${en.is_recommend}</td>
				<td>${en.all_food}</td>
				<td>${en.oid}</td>
				<c:choose>
					<c:when test="${sessionScope.rid==null }">
						<td>${en.uid}</td>
						<td>${en.rid}</td>
					</c:when>
				</c:choose>
				<td class="td-manage"> 
				<c:choose>
					<c:when test="${sessionScope.rid==null }">
					<a title="修改" href="${pageContext.request.contextPath }/evaluation/jumpToUpdate?eid=${en.eid}" style="text-decoration:none">
						<i class="Hui-iconfont">&#xe6df;</i></a>
					<a title="删除" href="${pageContext.request.contextPath }/evaluation/deleteEvaluation?eid=${en.eid}" class="ml-5" style="text-decoration:none">
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
			  {"orderable":false,"aTargets":[0,2,6,8,12]}// 制定列不参与排序
			]
		});
	}
	else{
		$('.table-sort').dataTable({
			"aaSorting": [[ 1, "asc" ]],//默认第几个排序
			"bStateSave": true,//状态保存
			"aoColumnDefs": [
			  //{"bVisible": false, "aTargets": [ 3 ]} //控制列的隐藏显示
			  {"orderable":false,"aTargets":[0,2,6,8,10]}// 制定列不参与排序
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
	location.href="${pageContext.request.contextPath }/evaluation/deleteManyEvaluation?str="+str;
}
</script>  
</body>
</html>
