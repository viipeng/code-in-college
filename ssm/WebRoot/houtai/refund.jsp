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
<title>退款请求</title>
</head>
<body>
<div class="page-container">
	<p class="f-20 text-success">今天共有 <span class="f-14" style="font-size: 19px">${todayRequestSum }</span>个请求</p>
	<p>待处理请求数：${noProcessSum } </p>
	<!-- <p>上次登录IP：222.35.131.79.1  上次登录时间：2014-6-14 11:19:55</p> -->
	<table class="table table-border table-bordered table-bg table-sort">
		<thead>
			<tr>
				<th colspan="8" scope="col">请求列表</th>
			</tr>
			<tr class="text-c">
				<th width="40">OID</th>
				<th width="40">状态</th><!-- 0表示未处理，1表示已处理 -->
				<th width="100">餐馆名称</th>
				<th width="100">所有的菜品</th>
				<th width="40">消费</th>
				<th width="100">下单日期</th>
				<th width="100">操作</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${requestList }" var="rl">
			<tr class="text-c">
				<td>${rl.oid }</td>
				<c:choose>
					<c:when test="${rl.ostate=='已退款' }">
						<td>同意</td>
					</c:when>
					<%-- <c:when test="${rl.ostate=="" }">
						<td>拒绝</td>
					</c:when> --%>
					<c:when test="${rl.ostate=='待退款' }">
						<td>未处理</td>
					</c:when>
				</c:choose>
				<td>${rl.rname }</td>
				<td>${rl.all_food }</td>
				<td>${rl.consumption }</td>
				<td>${rl.odate }</td>
				<c:choose>
					<c:when test="${rl.ostate=='待退款' }">
				<td class="td-manage"> 
					<a title="同意" href="${pageContext.request.contextPath }/orderInfo/permitRefund?oid=${rl.oid }" style="text-decoration:none">
						<i class="Hui-iconfont">&#xe6e1;</i></a> 
					<a title="不同意" href="${pageContext.request.contextPath }/orderInfo/refuseRefund?oid=${rl.oid }" class="ml-5" style="text-decoration:none">
						<i class="Hui-iconfont">&#xe6dd;</i></a>
				</td>
					</c:when>
					<c:when test="${rl.ostate=='已退款' }">
						<td class="td-manage"></td>
					</c:when>
				</c:choose>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	
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
		{"orderable":false,"aTargets":[2,3,6]}// 制定列不参与排序
		]
	});
	
});
</script> 

</body>
</html>