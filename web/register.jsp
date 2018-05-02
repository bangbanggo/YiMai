<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
<div id="register" class="wrap">
	<div class="shadow">
		<em class="corner lb"></em>
		<em class="corner rt"></em>
		<div class="box">
			<h1>欢迎注册易买网</h1>
			<ul class="steps clearfix">
				<li class="current"><em></em>填写注册信息</li>
				<li class="last"><em></em>注册成功</li>
			</ul>
			<form id="regForm" method="post" action="register" onsubmit="return checkForm(this);">
				<table>
					<tr>
						<td class="field">用户名：</td>
						<td><input class="text" type="text" name="user.euUserName" onfocus="FocusItem(this)" onblur="CheckItem(this);" /><span>${user.euUserName}</span></td>
					</tr>
					<tr>
						<td class="field">登录密码：</td>
						<td><input class="text" type="password" id="password" name="user.euPassword" onfocus="FocusItem(this)" onblur="CheckItem(this);" /><span>${user.euPassword}</span></td>
					</tr>
					<tr>
						<td class="field">确认密码：</td>
						<td><input class="text" type="password" name="rePassWord" onfocus="FocusItem(this)" onblur="CheckItem(this);" /><span></span></td>
					</tr>
					<tr>
						<td class="field">性别：</td>
						<td>
							<input class="radio" type="radio" name="user.euSex" value="男" checked onfocus="FocusItem(this)"/>男
							<input class="radio" type="radio" name="user.euSex" value="女" onfocus="FocusItem(this)" />女
							<span></span>
						</td>
					</tr>
					<tr>
						<td class="field">出生日期：</td>
						<td><input class="text" type="date" name="user.euBirthday" onfocus="FocusItem(this)" onblur="CheckItem(this);" /><span>${user.euBirthday}</span></td>
					</tr>
					<tr>
						<td class="field">身份证：</td>
						<td><input class="text" type="text" name="user.euIdentityCode" onfocus="FocusItem(this)" onblur="CheckItem(this);" /><span>${user.euIdentityCode}</span></td>
					</tr>
					<tr>
						<td class="field">电子邮箱：</td>
						<td><input class="text" type="text" name="user.euEmail" onfocus="FocusItem(this)" onblur="CheckItem(this);" /><span>${user.euEmail}</span></td>
					</tr>
					<tr>
						<td class="field">手机：</td>
						<td><input class="text" type="text" name="user.euMobile" onfocus="FocusItem(this)" onblur="CheckItem(this);" /><span>${user.euMobile}</span></td>
					</tr>
					<tr>
						<td class="field">住址：</td>
						<td><input class="text" type="text" name="user.euAddress" onfocus="FocusItem(this)" onblur="CheckItem(this);" /><span>${user.euAddress}</span></td>
					</tr>
					<tr>
						<td class="field">验证码：</td>
						<td><input class="text verycode" type="text" name="veryCode" onfocus="FocusItem(this)" onblur="CheckItem(this);" /><img id="veryCode" src="image.jsp" /><span>${veryCode}</span></td>
					</tr>
					<tr>
						<td></td>
						<td><label class="ui-green"><input type="submit" name="submit" value="提交注册" /></label></td>
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
