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
			<li class="current"><a href="user.jsp">用户</a></li>
			<li><a href="product.jsp">商品</a></li>
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
		<h2>新增用户</h2>
		<div class="manage">
			<form action="addUser">
				<table class="form">
					<tr>
						<td class="field">用户名：</td>
						<td><input type="text" class="text" name="user.euUserId" value="${user.euUserId}" readonly="readonly" /></td>
					</tr>
					<tr>
						<td class="field">姓名：</td>
						<td><input type="text" class="text" name="user.euUserName" value="${user.euUserName}" /></td>
					</tr>
					<tr>
						<td class="field">密码：</td>
						<td><input type="text" class="text" name="user.euPassword" value="${user.euPassword}" /></td>
					</tr>
					<tr>
						<td class="field">性别：</td>
						<td><input type="radio" name="user.euSex" value="男" <c:if test="${user.euSex == '男'}" >checked</c:if>/>男 <input type="radio" name="user.euSex" value="女" <c:if test="${user.euSex == '女'}" >checked</c:if>/>女</td>
					</tr>
					<tr>
						<td class="field">出生日期：</td>
						<td>
							<input type="date" name="user.euBirthday" value="${user.euBirthday}">
						</td>
					</tr>
					<tr>
						<td class="field">手机号码：</td>
						<td><input type="text" class="text" name="user.euMobile" value="${user.euMobile}" /></td>
					</tr>
					<tr>
						<td class="field">送货地址：</td>
						<td><input type="text" class="text" name="user.euAddress" value="${user.euAddress}" /></td>
					</tr>
					<%--<tr>--%>
						<%--<td class="field">头像：</td>--%>
						<%--<td><input type="file" class="text" name="photo" /></td>--%>
					<%--</tr>--%>
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
