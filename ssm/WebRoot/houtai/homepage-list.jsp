<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%-- <base href="<%=basePath%>>"> --%>

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
<title>后台管理系统</title>
<meta name="keywords" content="网络订餐平台">
<meta name="description" content="后台首页">
</head>
<body>
<header class="navbar-wrapper">
	<div class="navbar navbar-fixed-top">
		<div class="container-fluid cl">
			<span class="logo navbar-slogan f-l mr-10 hidden-xs"><font size="4">后台管理系统</font></span> 
			<a aria-hidden="false" class="nav-toggle Hui-iconfont visible-xs" href="javascript:;">&#xe667;</a>
		<nav id="Hui-userbar" class="nav navbar-nav navbar-userbar hidden-xs">
			<ul class="cl">
				<c:choose>
					<c:when test="${sessionScope.rid!=null}">
					
					</c:when>
					<c:when test="${sessionScope.rid==null}">
						<li>超级管理员</li>
					</c:when>
				</c:choose>
				<li class="dropDown dropDown_hover">
					<c:choose>
						<c:when test="${sessionScope.rid!=null}">
							<a href="#" class="dropDown_A">${restaurant.rname }店主 <i class="Hui-iconfont">&#xe6d5;</i></a>
						</c:when>
						<c:when test="${sessionScope.rid==null}">
							<a href="#" class="dropDown_A">${bi.busername } <i class="Hui-iconfont">&#xe6d5;</i></a>
						</c:when>
					</c:choose>
					<ul class="dropDown-menu menu radius box-shadow">
						<c:choose>
							<c:when test="${sessionScope.rid!=null}">
								<li><a href="../restaurantInfo/visitRestaurantByRid?rid=${sessionScope.rid }">退出</a></li>
							</c:when>
							<c:when test="${sessionScope.rid==null}">
								<li><a href="${pageContext.request.contextPath }/home/visit">注销</a></li>
							</c:when>
						</c:choose>
				</ul>
			</li>
				<li id="Hui-skin" class="dropDown right dropDown_hover"> 
					<a href="javascript:;" class="dropDown_A" title="换肤"><i class="Hui-iconfont" style="font-size:18px">&#xe62a;</i></a>
					<ul class="dropDown-menu menu radius box-shadow">
						<li><a href="javascript:;" data-val="default" title="默认（黑色）">默认（黑色）</a></li>
						<li><a href="javascript:;" data-val="blue" title="蓝色">蓝色</a></li>
						<li><a href="javascript:;" data-val="green" title="绿色">绿色</a></li>
						<li><a href="javascript:;" data-val="red" title="红色">红色</a></li>
						<li><a href="javascript:;" data-val="yellow" title="黄色">黄色</a></li>
						<li><a href="javascript:;" data-val="orange" title="橙色">橙色</a></li>
					</ul>
				</li>
			</ul>
		</nav>
	</div>
</div>
</header>
<aside class="Hui-aside">
	<div class="menu_dropdown bk_2">
		<dl id="menu-article">
			<dt><i class="Hui-iconfont">&#xe622;</i> 评论管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
			<dd>
				<ul>
					<li><a data-href="../evaluation/selectAll" data-title="评论列表" href="javascript:void(0)">评论列表</a></li>
			</ul>
		</dd>
	</dl>
		<dl id="menu-picture">
			<dt><i class="Hui-iconfont">&#xe620;</i> 菜品管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
			<dd>
				<ul>
					<li><a data-href="../foodInfo/selectAll" data-title="菜品列表" href="javascript:void(0)">菜品列表</a></li>
			</ul>
		</dd>
	</dl>
		<dl id="menu-product">
			<dt><i class="Hui-iconfont">&#xe626;</i> 菜单管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
			<dd>
				<ul>
					<li><a data-href="../meauInfo/selectAll" data-title="菜单列表" href="javascript:void(0)">菜单列表</a></li>
			</ul>
		</dd>
	</dl>
		<dl id="menu-comments">
			<dt><i class="Hui-iconfont">&#xe687;</i> 订单管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
			<dd>
				<ul>
					<li><a data-href="../orderInfo/selectAll" data-title="订单列表" href="javascript:void(0)">订单列表</a></li>
			</ul>
		</dd>
	</dl>
	<c:choose>
		<c:when test="${sessionScope.rid==null }">
		<dl id="menu-comments">
			<dt><i class="Hui-iconfont">&#xe667;</i> 订单的菜品管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
			<dd>
				<ul>
					<li><a data-href="../order_food/selectAll" data-title="菜品列表" href="javascript:void(0)">菜品列表</a></li>
			</ul>
		</dd>
	</dl>
	</c:when>
	</c:choose>
		<dl id="menu-member">
			<dt><i class="Hui-iconfont">&#xe66a;</i> 餐馆管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
			<dd>
				<ul>
					<li><a data-href="../restaurantInfo/selectAll" data-title="餐馆列表" href="javascript:;">餐馆列表</a></li>
			</ul>
		</dd>
	</dl>
	<c:choose>
		<c:when test="${sessionScope.rid==null }">
		<dl id="menu-member">
			<dt><i class="Hui-iconfont">&#xe670;</i> 购物车管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
			<dd>
				<ul>
					<li><a data-href="../shopping_trolleyInfo/selectAll" data-title="购物车列表" href="javascript:;">购物车列表</a></li>
			</ul>
		</dd>
	</dl>
		<dl id="menu-member">
			<dt><i class="Hui-iconfont">&#xe667;</i> 购物车的菜品管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
			<dd>
				<ul>
					<li><a data-href="../shopping_trolley_food/selectAll" data-title="菜品列表" href="javascript:;">菜品列表</a></li>
			</ul>
		</dd>
	</dl>
		<dl id="menu-admin">
			<dt><i class="Hui-iconfont">&#xe62c;</i> 用户管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
			<dd>
				<ul>
					<li><a data-href="../userInfo/selectAll" data-title="用户列表" href="javascript:void(0)">用户列表</a></li>
			</ul>
		</dd>
	</dl>
	</c:when>
	</c:choose>
</div>
</aside>
<div class="dislpayArrow hidden-xs">
	<a class="pngfix" href="javascript:void(0);" onClick="displaynavbar(this)"></a>
</div>
<section class="Hui-article-box">
	<div id="Hui-tabNav" class="Hui-tabNav hidden-xs">
		
		<div class="Hui-tabNav-wp">
			<ul id="min_title_list" class="acrossTab cl">
				<li class="active">
				<c:choose>
					<c:when test="${sessionScope.rid==null }">
						<span title="充值请求" data-href="../bossInfo/moneyRequest">充值请求</span>
				</c:when>
					<c:when test="${sessionScope.rid!=null }">
						<span title="退款请求" data-href="../merchant/refundRequest">退款请求</span>
					</c:when>
				</c:choose>
					<em></em></li>
		</ul>
	</div>
		<div class="Hui-tabNav-more btn-group">
			<a id="js-tabNav-prev" class="btn radius btn-default size-S" href="javascript:;">
				<i class="Hui-iconfont">&#xe6d4;</i></a>
			<a id="js-tabNav-next" class="btn radius btn-default size-S" href="javascript:;">
				<i class="Hui-iconfont">&#xe6d7;</i></a>
		</div>
</div>
	<div id="iframe_box" class="Hui-article">
		<div class="show_iframe">
			<div style="display:none" class="loading"></div>
			<c:choose>
				<c:when test="${sessionScope.rid==null }">
					<iframe scrolling="yes" frameborder="0" src="../bossInfo/moneyRequest"></iframe>
				</c:when>
				<c:when test="${sessionScope.rid!=null }">
					<iframe scrolling="yes" frameborder="0" src="../merchant/refundRequest"></iframe>
				</c:when>
			</c:choose>
	</div>
</div>
</section>

<div class="contextMenu" id="Huiadminmenu">
	<ul>
		<li id="closethis">关闭当前 </li>
		<li id="closeall">关闭全部 </li>
</ul>
</div>
<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="../houtai/lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="../houtai/lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="../houtai/static/h-ui/js/H-ui.min.js"></script>
<script type="text/javascript" src="../houtai/static/h-ui.admin/js/H-ui.admin.js"></script> <!--/_footer 作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="../houtai/lib/jquery.contextmenu/jquery.contextmenu.r2.js"></script>
<script type="text/javascript">
$(function(){
});
/*管理员信息*/
function myselfinfo(){
	layer.open({
		type: 1,
		area: ['300px','200px'],
		fix: false, //不固定
		maxmin: true,
		shade:0.4,
		title: '查看管理员信息',
		content: '<div ><table class="table table-border table-bordered table-hover table-bg table-sort"> <tr class="text-c"><td width="40">ID</td><td width="100">姓名</td><td width="40">性别</td></tr> <tr class="text-c"><td width="40">${bi.bid }</td><td width="100">${bi.busername }</td><td width="40">${bi.bsex }</td></tr> </table> </div>'
	});
}
</script> 
</body>
</html>