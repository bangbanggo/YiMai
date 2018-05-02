<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>易买网 - 首页</title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
<script type="text/javascript" src="scripts/function.js"></script>
<script type="text/javascript" src="scripts/jquery.min.js"></script>
</head>
<body>
<div id="header" class="wrap">
	<%@include file="header.jsp"%>
</div>
<div id="childNav">
	<div class="wrap">
		<ul class="clearfix">
			<li class="first"><a href="#">音乐</a></li>
			<li><a href="#">影视</a></li>
			<li><a href="#">少儿</a></li>
			<li><a href="#">动漫</a></li>
			<li><a href="#">小说</a></li>
			<li><a href="#">外语</a></li>
			<li><a href="#">数码相机</a></li>
			<li><a href="#">笔记本</a></li>
			<li><a href="#">羽绒服</a></li>
			<li><a href="#">秋冬靴</a></li>
			<li><a href="#">运动鞋</a></li>
			<li><a href="#">美容护肤</a></li>
			<li><a href="#">家纺用品</a></li>
			<li><a href="#">婴幼奶粉</a></li>
			<li><a href="#">饰品</a></li>
			<li class="last"><a href="#">Investor Relations</a></li>
		</ul>
	</div>
</div>
<div id="position" class="wrap">
	<%@include file="currentPosition.jsp"%>
</div>
<div id="main" class="wrap">
	<div class="lefter">
		<div class="box">
			<h2>商品分类</h2>
			<dl>
				<%@include file="class-list.jsp"%>
			</dl>
		</div>
		<div class="spacer"></div>
		<div class="last-view">
			<h2>最近浏览</h2>
			<dl class="clearfix">
				<%@include file="productmap-history.jsp"%>
			</dl>
		</div>
	</div>
	<div id="product" class="main">
		<h1>${product.epName}</h1>
		<div class="infos">
			<div class="thumb">
				<c:if test="${not empty product.epFileName}">
					<img src="images/product/${product.epFileName}" />
				</c:if>
				<c:if test="${empty product.epFileName}">
					<img src="images/product/0.jpg" />
				</c:if>
			</div>
			<div class="buy">
				<p>商城价：<span class="price">￥${product.epPrice}</span></p>
				<c:if test="${product.epStock > 0 }">
					<p>库　存：有货</p>
				</c:if>
				<c:if test="${product.epStock == 0 }">
					<p>库　存：无货</p>
				</c:if>

				<div class="button"><input type="button" name="button" value="" onclick="goBuy(${product.epId})" /><a href="#">放入购物车</a></div>
			</div>
			<div class="clear"></div>
		</div>
		<div class="introduce">
			<h2><strong>商品详情</strong></h2>
			<div class="text">
				${product.epDescription}
			</div>
		</div>
	</div>
	<div class="clear"></div>
</div>
<div id="footer">
	Copyright &copy; 2015 天智立软件教育 All Rights Reserved. 京ICP证1000001号
</div>
</body>
</html>
