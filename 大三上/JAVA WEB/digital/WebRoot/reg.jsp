<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title><s:text name="register.page"></s:text></title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<link href="css/Layout.css" rel="stylesheet" type="text/css" />
<SCRIPT type=text/javascript src="js/scrolltop.js"></SCRIPT>
<SCRIPT type=text/javascript src="js/scrolltop.js"></SCRIPT>
</head>

<body>
	<!--顶部开始-->
	<div class="itop">
		<div class="itop_body">
			<div class="itop_left fl">欢迎光临好东东买卖网！</div>
			<div class="itop_right fl">
				<span class="blue"><a href="login.jsp">[登录]</a></span> <span
					class="red"><a href="reg.jsp">[注册]</a></span> <span><img
					src="images/d002.jpg" /></span> <span>购物车 <span class="red">5</span>
					件
				</span>
			</div>
		</div>
	</div>
	<div class="clearall"></div>
	<!--顶部结束-->

	<!--头部搜索开始-->
	<div class="header">
		<div class="logo fl">
			<img src="images/d001.jpg" />
		</div>
		<div class="search fl">
			<div class="search_from">
				<div>
					<input name="" type="text" class="s_input fl" />
				</div>
				<div class="s_botton fl">
					<input type="image" src="images/002.jpg" />
				</div>
			</div>
			<div class="s_hot hui">热门搜索：笔记本 台式机 一体机 平板电脑 手机 打印机</div>
		</div>
	</div>
	<!--头部搜索结束-->

	<!--菜单开始-->
	<div class="menu">
		<div class="menu_left fl">全部商品分类</div>
		<div class="menu_center fl">
			<div class="dh_topd">
				<A href="index.jsp">网站首页</A>
			</div>
			<div class="dh_topd">
				<A href="index.jsp">购物流程</A>
			</div>
			<div class="dh_topd">
				<A href="index.jsp">联系我们</A>
			</div>
		</div>
	</div>
	<div class="clearall"></div>
	<!--菜单结束-->

	<!--主体开始-->
	<div class="main mt10">
		<div class="mleft fl ah">
			<!--注册开始-->
			<div class="reg_a jiacu">会员注册</div>
			<div class="reg_b fl">
				<s:text name="register.title"></s:text>
			</div>
			<div class="reg_c fl ah">
				<!-- 使用Struts 2标签完成注册功能 -->
				<s:form action="registerAction" method="post" name="frm">
					<table width="300" align="center" style="text-align:center;">
						<!-- 	<center>
							<font color="red" size="3px"><s:fielderror /></font>
						</center>
				 -->
						<s:textfield name="user.id" label="id号" />
						<s:textfield name="user.userName" label="登录名称" />
						<s:textfield name="user.password" label="登录密码" />
						<s:textfield name="repassword" label="确认密码" />
						<s:textfield name="user.realName" label="真实姓名" />
						<s:submit value="提交" align="center"></s:submit>
					</table>
				</s:form>
			</div>

			<!--注册结束-->
		</div>

		<div class="mright fl">
			<!-- 浏览排行榜 -->
			<div class="mright_b mt10">
				<p class="tit">浏览排行榜</p>
				<div class="con">
					<div class="conshow">
						<p class="img fl">
							<img height='50px' width='65px' src="product_images/1981672.jpg" />
						</p>
						<p class="content fl">华硕FL5800</p>
					</div>

					<p class="paihang">华硕FL5800</p>

					<p class="paihang">美的BCD-516WKM(E)</p>
				</div>
			</div>
			<div class="mright_a">
				<p class="tit">销量排行榜</p>
				<div class="con">
					<div class="conshow">
						<p class="img fl">
							<img src="images/d007.jpg" />
						</p>
						<p class="content fl">笔记本电脑/联想S200</p>
					</div>
					<p class="paihang">笔记本电脑/联想S200</p>
					<p class="paihang">笔记本电脑/联想S230</p>
					<p class="paihang">笔记本电脑/联想S400</p>

				</div>
			</div>
		</div>

	</div>
	<!--主体结束-->
	<!--尾部结束-->
	<div class="end">
		地址：江苏省盐城市亭湖区大庆中路100号电话：0515-88888888邮箱：dongdi@yaohoo.com.cn邮编：224000<br />
		版权所有：苏州同凯信息有限公司 技术支持：0515-99999999
	</div>
	<!--尾部结束-->
	<DIV
		style="DISPLAY: none;POSITION: fixed; TEXT-ALIGN: center; LINE-HEIGHT: 30px; WIDTH: 30px; BOTTOM: 100px; HEIGHT: 33px; FONT-SIZE: 12px; CURSOR: pointer; RIGHT: 0px; _position: absolute; _right: auto"
		id=goTopBtn>
		<IMG border=0 src="images/lanren_top.jpg">
	</DIV>
	<SCRIPT type=text/javascript>goTopEx();</SCRIPT>
</body>
</html>
