<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>后台管理 - 易买网</title>
<link type="text/css" rel="stylesheet" href="../css/style.css" />
<script type="text/javascript" src="../scripts/function-manage.js"></script>
</head>
<body>
<div id="header" class="wrap">
	<div id="logo"><img src="../images/logo.gif" /></div>
	<div class="help"><a href="../index.jsp">返回前台页面</a></div>
	<div class="navbar">
		<ul class="clearfix">
			<li><a href="index.jsp">首页</a></li>
			<li><a href="user.jsp">用户</a></li>
			<li class="current"><a href="product.jsp">商品</a></li>
			<li><a href="order.jsp">订单</a></li>
			<li><a href="guestbook.jsp">留言</a></li>
			<li><a href="news.jsp">新闻</a></li>
		</ul>
	</div>
</div>
<div id="childNav">
	<div class="welcome wrap">
		管理员pillys您好，今天是2012-12-21，欢迎回到管理后台。
	</div>
</div>
<div id="position" class="wrap">
	您现在的位置：<a href="index.jsp">易买网</a> &gt; 管理后台
</div>
<div id="main" class="wrap">
	<div id="menu-mng" class="lefter">
		<%@include file="menu-mng.jsp"%>
	</div>
	<div class="main">
		<h2>添加分类</h2>
		<div class="manage">
			<form action="category_add" method="post">
				<table class="form">
					<tr>
						<td class="field">父分类：</td>
						<td>
							<select name="category.epcParentId">
								<option value="0">根栏目</option>
								<c:forEach var="cate" items="${categories}">
									<option value="${cate.epcId}">${cate.epcName}</option>
								</c:forEach>
							</select>
						</td>
					</tr>
					<tr>
						<td class="field">分类名称：</td>
						<td><input type="text" class="text" name="category.epcName" value="" /></td>
					</tr>
					<tr>
						<td class="field">地址：</td>
						<td><input type="text" class="text" name="category.epcAction" value="#" readonly/></td>
					</tr>
					<tr>
						<td></td>
						<td><label class="ui-blue"><input type="submit" name="submit" value="更新" /></label></td>
					</tr>
				</table>
			</form>
		</div>
	</div>
	<div class="clear"></div>
</div>
<div id="footer">
	Copyright &copy; 2015 天智立软件教育 All Rights Reserved. 京ICP证1000001号
</div>
</body>
</html>
