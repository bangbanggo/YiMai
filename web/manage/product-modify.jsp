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
		<h2>修改商品</h2>
		<div class="manage">
			<form action="manage-result.jsp">
				<table class="form">
					<tr>
						<td class="field">商品名称：</td>
						<td><input type="text" class="text" name="product.epName" value="${product.epName}" /></td>
					</tr>
					<tr>
						<td class="field">所属分类：</td>
						<td>
							<select name="product.epcId" >
								<c:forEach var="category" items="${categoryExpand.categories}">
									<option value="${category.epcId}" disabled>${category.epcName}</option>
									<c:forEach var="cate" items="${category.categories}">
										<option value="${cate.epcId}"  <c:if test="${product.epcId==cate.epcId}" >selected</c:if> >├ ${cate.epcName}</option><dd><a href="${cate.epcAction}">${cate.epcName}</a></dd>
									</c:forEach>
								</c:forEach>
							</select>
						</td>
					</tr>
					<tr>
						<td class="field">商品图片：</td>
						<td><input type="file" class="text" name="product.epFileName" value="${product.epFileName}" /></td>
					</tr>
					<tr>
						<td class="field">商品价格：</td>
						<td><input type="text" class="text tiny" name="product.epPrice" value="${product.epPrice}" /> 元</td>
					</tr>
					<tr>
						<td class="field">品牌：</td>
						<td><input type="text" class="text" name="product.epBrandName" value="${product.epBrandName}"/></td>
					</tr>
					<tr>
						<td class="field">库存：</td>
						<td><input type="text" class="text tiny" name="product.epStock" value="${product.epStock}" /></td>
					</tr>
					<tr>
						<td class="field">条码号：</td>
						<td><input type="text" class="text" name="product.epBarCode" value="${product.epBarCode}" /></td>
					</tr>
					<tr>
						<td class="field">商品描述：</td>
						<td><input type="text" class="text" name="product.epDescription" value="${product.epDescription}" /></td>
					</tr>
					<tr>
						<td></td>
						<td><label class="ui-blue"><input type="submit" name="submit" value="添加" /></label></td>
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
