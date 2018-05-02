
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>易买网 - 首页</title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
<script type="text/javascript" src="scripts/function.js"></script>
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
	您现在的位置：<a href="index.jsp">易买网</a> &gt; 阅读新闻
</div>
<div id="main" class="wrap">
	<div class="left-side">
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
	<div id="news" class="right-main">
		<h1>${news.enTitle}</h1>
		<div class="content">
			${news.enContent}
		</div>
	</div>
	<div class="clear"></div>
</div>
<div id="footer">
	Copyright &copy; 2015 天智立软件教育 All Rights Reserved. 京ICP证1000001号
</div>
</body>
</html>
