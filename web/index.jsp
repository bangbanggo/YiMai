<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>易买网 - 首页</title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
<script type="text/javascript" src="scripts/vue.js"></script>
<script type="text/javascript" src="scripts/function.js"></script>
</head>
<body>
<div id="header" class="wrap">
	<%@include file="header.jsp"%>
</div>
<div id="childNav">
	<div class="wrap">
		<ul class="clearfix">
			<%@include file="childHeader.jsp"%>
		</ul>
	</div>
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
	<div class="main">
		<div class="price-off">
			<h2>今日特价</h2>
			<ul class="product clearfix">
				<%@include file="productmap.jsp"%>
			</ul>
		</div>
		<div class="side">
			<div class="news-list">
				<h4>最新公告</h4>
				<ul>
					<li><a href="news-view.jsp" target="_blank">抢钱啦</a></li>
					<li><a href="news-view.jsp" target="_blank">抢钱啦</a></li>
					<li><a href="news-view.jsp" target="_blank">抢钱啦</a></li>
					<li><a href="news-view.jsp" target="_blank">抢钱啦</a></li>
					<li><a href="news-view.jsp" target="_blank">抢钱啦</a></li>
					<li><a href="news-view.jsp" target="_blank">抢钱啦</a></li>
					<li><a href="news-view.jsp" target="_blank">抢钱啦</a></li>
				</ul>
			</div>
			<div class="spacer"></div>
			<div class="news-list">
				<h4>新闻动态</h4>
				<ul>
					<li><a href="news-view.jsp" target="_blank">抢钱啦</a></li>
					<li><a href="news-view.jsp" target="_blank">抢钱啦</a></li>
					<li><a href="news-view.jsp" target="_blank">抢钱啦</a></li>
					<li><a href="news-view.jsp" target="_blank">抢钱啦</a></li>
					<li><a href="news-view.jsp" target="_blank">抢钱啦</a></li>
					<li><a href="news-view.jsp" target="_blank">抢钱啦</a></li>
					<li><a href="news-view.jsp" target="_blank">抢钱啦</a></li>
				</ul>
			</div>
		</div>
		<div class="spacer clear"></div>
		<div class="hot">
			<h2>热卖推荐</h2>
			<ul class="product clearfix">
				<%@include file="productmap-hot.jsp"%>
			</ul>
		</div>
	</div>
	<div class="clear"></div>
</div>
<div id="footer">
	Copyright &copy; 2015 天智立软件教育 All Rights Reserved. 京ICP证1000001号
</div>
</body>-
<script type="text/javascript" src="scripts/jquery.min.js"></script>
<script type="text/javascript" src="scripts/data.js"></script>
</html>
