<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!
DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>电子商城--首页</title>
<link href="css/Layout.css" rel="stylesheet" type="text/css" />
<SCRIPT type=text/javascript src="js/scrolltop.js"></SCRIPT>
<SCRIPT type=text/javascript src="js/qq.js"></SCRIPT>
</head>

<body>
	<!-- 代码 开始
<div class="float-contact" id="float-contact" style="position: fixed;z-index:1000; right: 1px; display: block;">
	<a title="点击收缩" href="javascript:void(0);" onClick="show()" class="close" id="float-contact-close">点击收缩</a>
	<div class="container">
		<div class="qq">
			<h3 class="qqtitle">在线客服</h3>
			<ul class="btn">
				<li><a title="客服一" target="_blank" href="http://wpa.qq.com/msgrd?v=3&uin=455605838&site=qq&menu=yes">业务QQ</a></li>
				<li><a title="客服一" target="_blank" href="http://wpa.qq.com/msgrd?v=3&uin=1910645950&site=qq&menu=yes">业务QQ</a></li>
				<li><a title="客服一" target="_blank" href="http://wpa.qq.com/msgrd?v=3&uin=1792517401&site=qq&menu=yes">客服QQ</a></li>
				<li><a title="客服一" target="_blank" href="http://wpa.qq.com/msgrd?v=3&uin=2693564150&site=qq&menu=yes">客服QQ</a></li>
				<li><a title="客服一" target="_blank" href="http://wpa.qq.com/msgrd?v=3&uin=2689812734&site=qq&menu=yes">客服QQ</a></li>
			</ul>
		</div>
		
	</div>
	<a target="_blank" href="#" class="myqqlink">东帝纺织索样平台</a>
</div>

<div class="float-contact-mini" id="float-contact-mini" style="display: none; position: fixed; right: 1px;">
	<a href="javascript:void(0);" onClick="show()" id="float-contact-mini">联系我们</a>
</div>

代码 结束 -->

	<!--顶部注册开始-->
	<div class="itop">
		<div class="itop_body">
			<div class="itop_left fl">欢迎光临好东东买卖网！</div>
			<div class="itop_right fl">

				<font color="red"></font>
				<!-- 
				
				<span class="red"></span>&nbsp;
				<span class="blue"><a href="#">[退出]</a></span>
			
				<span class="blue"><a href="login.jsp">[登录]</a></span>
			
				<span class="red"><a href="reg.jsp">[注册]</a></span>				
		 -->

				<span class="blue"><a href="login.jsp">[登录]</a></span> <span
					class="red"><a href="reg.jsp">[注册]</a></span> <a href="cart.jsp">
					<span><img src="images/d002.jpg" /></span>&nbsp; <span>购物车 </span>
					<!-- <span class="red">5</span> 件  -->
				</a>
			</div>
		</div>
	</div>
	<div class="clearall"></div>
	<!--顶部注册结束-->
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
				<A href="list">网站首页</A>
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
	<!--条件筛选开始-->
	<div class="sx mt10">
		<div class="sx_a">
			<span>所有分类 > 类型</span>
		</div>

		<div class="sx_b">
			<p class="tit fl">电脑</p>
			<p class="con fl">&nbsp;APPLE&nbsp;&nbsp;

				&nbsp;ThinkPad&nbsp;&nbsp; &nbsp;联想（Lenovo）&nbsp;&nbsp;

				&nbsp;华硕（ASUS）&nbsp;&nbsp;</p>
			<p class="more fl">
				<img src="images/d006.jpg" />
			</p>
		</div>

		<div class="sx_b">
			<p class="tit fl">冰箱</p>
			<p class="con fl">&nbsp; 美的（Midea）&nbsp;&nbsp; &nbsp;
				海信（Hisense）&nbsp;&nbsp; &nbsp; 海尔（Haier）&nbsp;&nbsp;</p>
			<p class="more fl">
				<img src="images/d006.jpg" />
			</p>
		</div>

		<div class="sx_b">
			<p class="tit fl">电视机</p>
			<p class="con fl"></p>
			<p class="more fl">
				<img src="images/d006.jpg" />
			</p>
		</div>

		<div class="sx_b">
			<p class="tit fl">洗衣机</p>
			<p class="con fl"></p>
			<p class="more fl">
				<img src="images/d006.jpg" />
			</p>
		</div>

		<div class="sx_b">
			<p class="tit fl">数码相机</p>
			<p class="con fl"></p>
			<p class="more fl">
				<img src="images/d006.jpg" />
			</p>
		</div>

	</div>
	<!-- div class="clearall"></div>   -->

	<!--条件筛选结束-->
	<!--主体开始-->
	<div class="main mt10">

		<div class="mleft fl ah">
			<div class="mleft_tit">
				<p class="fenlei fl">综合</p>
				<p class="fenlei fl">价格</p>
				<p class="fenlei fl">人气</p>
				<p class="fenlei fl">销量</p>
			</div>
			<!-- 产品循环开始 -->

			<div class="mpro fl">
				<div class="mpro_tp"
					onmouseover="javascript:this.style.background='#fbc837'"
					onmouseout="javascript:this.style.background=''">
					<a href='show?pi.id=1' target="_blank"> <img
						src="product_images/1378538.jpg" />
					</a>
				</div>
				<div class="mpro_con">
					<table width="242" border="0" cellpadding="0" cellspacing="0">
						<tr>
							<td width="180" height="25" align="left" valign="middle"
								class="jiacu">1378538</td>
							<td width="62" rowspan="3" align="right" valign="middle"><a
								href="addtoshopcart?productInfoId=1 "><img
									src="images/006.jpg" /></a> <!-- addtoshopcart?后面加上CartAction的字段属性 -->
							</td>
						</tr>
						<tr align="left" valign="middle">
							<td width="180" height="25"><font color=blue>AppleMJVE2CH/A</font></td>
						</tr>
						<tr align="left" valign="middle">
							<td width="180" height="25"><font color=red>¥6488</font></td>
						</tr>
					</table>
				</div>
			</div>

			<div class="mpro fl">
				<div class="mpro_tp"
					onmouseover="javascript:this.style.background='#fbc837'"
					onmouseout="javascript:this.style.background=''">
					<a href='show?pi.id=2' target="_blank"> <img
						src="product_images/1309456.jpg" />
					</a>
				</div>
				<div class="mpro_con">
					<table width="242" border="0" cellpadding="0" cellspacing="0">
						<tr>
							<td width="180" height="25" align="left" valign="middle"
								class="jiacu">1309456</td>
							<td width="62" rowspan="3" align="right" valign="middle"><a
								href="addtoshopcart?productInfoId=2 "><img
									src="images/006.jpg" /></a> <!-- addtoshopcart?后面加上CartAction的字段属性 -->
							</td>
						</tr>
						<tr align="left" valign="middle">
							<td width="180" height="25"><font color=blue>ThinkPadE450C(20EH0001CD)</font></td>
						</tr>
						<tr align="left" valign="middle">
							<td width="180" height="25"><font color=red>¥4199</font></td>
						</tr>
					</table>
				</div>
			</div>

			<div class="mpro fl">
				<div class="mpro_tp"
					onmouseover="javascript:this.style.background='#fbc837'"
					onmouseout="javascript:this.style.background=''">
					<a href='show?pi.id=3' target="_blank"> <img
						src="product_images/1999938.jpg" />
					</a>
				</div>
				<div class="mpro_con">
					<table width="242" border="0" cellpadding="0" cellspacing="0">
						<tr>
							<td width="180" height="25" align="left" valign="middle"
								class="jiacu">1999938</td>
							<td width="62" rowspan="3" align="right" valign="middle"><a
								href="addtoshopcart?productInfoId=3 "><img
									src="images/006.jpg" /></a> <!-- addtoshopcart?后面加上CartAction的字段属性 -->
							</td>
						</tr>
						<tr align="left" valign="middle">
							<td width="180" height="25"><font color=blue>联想小新300经典版</font></td>
						</tr>
						<tr align="left" valign="middle">
							<td width="180" height="25"><font color=red>¥4399</font></td>
						</tr>
					</table>
				</div>
			</div>

			<div class="mpro fl">
				<div class="mpro_tp"
					onmouseover="javascript:this.style.background='#fbc837'"
					onmouseout="javascript:this.style.background=''">
					<a href='show?pi.id=4' target="_blank"> <img
						src="product_images/1466274.jpg" />
					</a>
				</div>
				<div class="mpro_con">
					<table width="242" border="0" cellpadding="0" cellspacing="0">
						<tr>
							<td width="180" height="25" align="left" valign="middle"
								class="jiacu">1466274</td>
							<td width="62" rowspan="3" align="right" valign="middle"><a
								href="addtoshopcart?productInfoId=4 "><img
									src="images/006.jpg" /></a> <!-- addtoshopcart?后面加上CartAction的字段属性 -->
							</td>
						</tr>
						<tr align="left" valign="middle">
							<td width="180" height="25"><font color=blue>华硕FX50JX</font></td>
						</tr>
						<tr align="left" valign="middle">
							<td width="180" height="25"><font color=red>¥4799</font></td>
						</tr>
					</table>
				</div>
			</div>

			<div class="mpro fl">
				<div class="mpro_tp"
					onmouseover="javascript:this.style.background='#fbc837'"
					onmouseout="javascript:this.style.background=''">
					<a href='show?pi.id=5' target="_blank"> <img
						src="product_images/1981672.jpg" />
					</a>
				</div>
				<div class="mpro_con">
					<table width="242" border="0" cellpadding="0" cellspacing="0">
						<tr>
							<td width="180" height="25" align="left" valign="middle"
								class="jiacu">1981672</td>
							<td width="62" rowspan="3" align="right" valign="middle"><a
								href="addtoshopcart?productInfoId=5 "><img
									src="images/006.jpg" /></a> <!-- addtoshopcart?后面加上CartAction的字段属性 -->
							</td>
						</tr>
						<tr align="left" valign="middle">
							<td width="180" height="25"><font color=blue>华硕FL5800</font></td>
						</tr>
						<tr align="left" valign="middle">
							<td width="180" height="25"><font color=red>¥4999</font></td>
						</tr>
					</table>
				</div>
			</div>

			<div class="mpro fl">
				<div class="mpro_tp"
					onmouseover="javascript:this.style.background='#fbc837'"
					onmouseout="javascript:this.style.background=''">
					<a href='show?pi.id=6' target="_blank"> <img
						src="product_images/1904696.jpg" />
					</a>
				</div>
				<div class="mpro_con">
					<table width="242" border="0" cellpadding="0" cellspacing="0">
						<tr>
							<td width="180" height="25" align="left" valign="middle"
								class="jiacu">1904696</td>
							<td width="62" rowspan="3" align="right" valign="middle"><a
								href="addtoshopcart?productInfoId=6 "><img
									src="images/006.jpg" /></a> <!-- addtoshopcart?后面加上CartAction的字段属性 -->
							</td>
						</tr>
						<tr align="left" valign="middle">
							<td width="180" height="25"><font color=blue>联想G50-70M</font></td>
						</tr>
						<tr align="left" valign="middle">
							<td width="180" height="25"><font color=red>¥3499</font></td>
						</tr>
					</table>
				</div>
			</div>

			<div class="mpro fl">
				<div class="mpro_tp"
					onmouseover="javascript:this.style.background='#fbc837'"
					onmouseout="javascript:this.style.background=''">
					<a href='show?pi.id=7' target="_blank"> <img
						src="product_images/751624.jpg" />
					</a>
				</div>
				<div class="mpro_con">
					<table width="242" border="0" cellpadding="0" cellspacing="0">
						<tr>
							<td width="180" height="25" align="left" valign="middle"
								class="jiacu">751624</td>
							<td width="62" rowspan="3" align="right" valign="middle"><a
								href="addtoshopcart?productInfoId=7 "><img
									src="images/006.jpg" /></a> <!-- addtoshopcart?后面加上CartAction的字段属性 -->
							</td>
						</tr>
						<tr align="left" valign="middle">
							<td width="180" height="25"><font color=blue>美的BCD-206TM(E)</font></td>
						</tr>
						<tr align="left" valign="middle">
							<td width="180" height="25"><font color=red>¥1298</font></td>
						</tr>
					</table>
				</div>
			</div>

			<div class="mpro fl">
				<div class="mpro_tp"
					onmouseover="javascript:this.style.background='#fbc837'"
					onmouseout="javascript:this.style.background=''">
					<a href='show?pi.id=8' target="_blank"> <img
						src="product_images/977433.jpg" />
					</a>
				</div>
				<div class="mpro_con">
					<table width="242" border="0" cellpadding="0" cellspacing="0">
						<tr>
							<td width="180" height="25" align="left" valign="middle"
								class="jiacu">977433</td>
							<td width="62" rowspan="3" align="right" valign="middle"><a
								href="addtoshopcart?productInfoId=8 "><img
									src="images/006.jpg" /></a> <!-- addtoshopcart?后面加上CartAction的字段属性 -->
							</td>
						</tr>
						<tr align="left" valign="middle">
							<td width="180" height="25"><font color=blue>美的BCD-516WKM(E)</font></td>
						</tr>
						<tr align="left" valign="middle">
							<td width="180" height="25"><font color=red>¥3199</font></td>
						</tr>
					</table>
				</div>
			</div>

			<div class="mpro fl">
				<div class="mpro_tp"
					onmouseover="javascript:this.style.background='#fbc837'"
					onmouseout="javascript:this.style.background=''">
					<a href='show?pi.id=9' target="_blank"> <img
						src="product_images/1143562.jpg" />
					</a>
				</div>
				<div class="mpro_con">
					<table width="242" border="0" cellpadding="0" cellspacing="0">
						<tr>
							<td width="180" height="25" align="left" valign="middle"
								class="jiacu">1143562</td>
							<td width="62" rowspan="3" align="right" valign="middle"><a
								href="addtoshopcart?productInfoId=9 "><img
									src="images/006.jpg" /></a> <!-- addtoshopcart?后面加上CartAction的字段属性 -->
							</td>
						</tr>
						<tr align="left" valign="middle">
							<td width="180" height="25"><font color=blue>海尔BCD-216SDN</font></td>
						</tr>
						<tr align="left" valign="middle">
							<td width="180" height="25"><font color=red>¥1699</font></td>
						</tr>
					</table>
				</div>
			</div>

			<div class="mpro fl">
				<div class="mpro_tp"
					onmouseover="javascript:this.style.background='#fbc837'"
					onmouseout="javascript:this.style.background=''">
					<a href='show?pi.id=10' target="_blank"> <img
						src="product_images/1560207.jpg" />
					</a>
				</div>
				<div class="mpro_con">
					<table width="242" border="0" cellpadding="0" cellspacing="0">
						<tr>
							<td width="180" height="25" align="left" valign="middle"
								class="jiacu">1560207</td>
							<td width="62" rowspan="3" align="right" valign="middle"><a
								href="addtoshopcart?productInfoId=10 "><img
									src="images/006.jpg" /></a> <!-- addtoshopcart?后面加上CartAction的字段属性 -->
							</td>
						</tr>
						<tr align="left" valign="middle">
							<td width="180" height="25"><font color=blue>海尔BCD-258WDPM</font></td>
						</tr>
						<tr align="left" valign="middle">
							<td width="180" height="25"><font color=red>¥2699</font></td>
						</tr>
					</table>
				</div>
			</div>

			<div class="mpro fl">
				<div class="mpro_tp"
					onmouseover="javascript:this.style.background='#fbc837'"
					onmouseout="javascript:this.style.background=''">
					<a href='show?pi.id=11' target="_blank"> <img
						src="product_images/1721668.jpg" />
					</a>
				</div>
				<div class="mpro_con">
					<table width="242" border="0" cellpadding="0" cellspacing="0">
						<tr>
							<td width="180" height="25" align="left" valign="middle"
								class="jiacu">1721668</td>
							<td width="62" rowspan="3" align="right" valign="middle"><a
								href="addtoshopcart?productInfoId=11 "><img
									src="images/006.jpg" /></a> <!-- addtoshopcart?后面加上CartAction的字段属性 -->
							</td>
						</tr>
						<tr align="left" valign="middle">
							<td width="180" height="25"><font color=blue>海信（Hisense）BCD-559WT/Q</font></td>
						</tr>
						<tr align="left" valign="middle">
							<td width="180" height="25"><font color=red>¥3499</font></td>
						</tr>
					</table>
				</div>
			</div>

			<div class="mpro fl">
				<div class="mpro_tp"
					onmouseover="javascript:this.style.background='#fbc837'"
					onmouseout="javascript:this.style.background=''">
					<a href='show?pi.id=12' target="_blank"> <img
						src="product_images/823125.jpg" />
					</a>
				</div>
				<div class="mpro_con">
					<table width="242" border="0" cellpadding="0" cellspacing="0">
						<tr>
							<td width="180" height="25" align="left" valign="middle"
								class="jiacu">823125</td>
							<td width="62" rowspan="3" align="right" valign="middle"><a
								href="addtoshopcart?productInfoId=12 "><img
									src="images/006.jpg" /></a> <!-- addtoshopcart?后面加上CartAction的字段属性 -->
							</td>
						</tr>
						<tr align="left" valign="middle">
							<td width="180" height="25"><font color=blue>海信BCD-211TD/E</font></td>
						</tr>
						<tr align="left" valign="middle">
							<td width="180" height="25"><font color=red>¥1699</font></td>
						</tr>
					</table>
				</div>
			</div>

			<!-- 产品循环结束 -->
		</div>

		<div class="mright fl">
			<!-- 浏览排行榜开始 -->
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
			<!-- 浏览排行榜结束 -->
			<!-- 销量排行榜开始，该部分功能未实现 -->
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
			<!-- 销量排行榜结束 -->
		</div>
	</div>

	<!--主体结束-->

	<!--尾部开始-->
	<div class="end">
		<div class="cont">
			<div class="cont_a fl">
				地址：江苏省盐城市亭湖区大庆中路100号 电话：0515-88888888 邮箱：dongdi@yaohoo.com.cn
				邮编：224000<br /> 版权所有：苏州同凯信息有限公司 技术支持：0515-99999999
			</div>
			<div class="cont_b fl">
				<img src="images/008.jpg" />
			</div>
		</div>
		<!--尾部结束-->
		<DIV
			style="DISPLAY: none;POSITION: fixed; TEXT-ALIGN: center; LINE-HEIGHT: 30px; WIDTH: 30px; BOTTOM: 100px; HEIGHT: 33px; FONT-SIZE: 12px; CURSOR: pointer; RIGHT: 0px; _position: absolute; _right: auto"
			id=goTopBtn>
			<IMG border=0 src="images/lanren_top.jpg">
		</DIV>
		<SCRIPT type=text/javascript>goTopEx();
	</SCRIPT>
</body>
</html>
