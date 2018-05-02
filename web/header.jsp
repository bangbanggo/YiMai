<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: gwb10
  Date: 2018/5/2
  Time: 12:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div id="logo"><img src="images/logo.gif" /></div>
<div class="help">
    <a href="shopping" class="shopping">购物车</a>
    <c:if test="${username != null}">
        <a href="#">${username}</a>
        <a href="logout">注销</a>
    </c:if>
    <c:if test="${username == null}">
        <a href="login.jsp">登录</a>
        <a href="register.jsp">注册</a>
    </c:if>
    <a href="guestbook.jsp">留言</a>
    <c:if test="${usertype == 2}">
        <a href="manage/index.jsp">后台管理</a>
    </c:if>
</div>
<div class="navbar">
    <ul class="clearfix">
        <c:if test="${empty currentPosition}">
            <li class="current"><a href="index">首页</a></li>
        </c:if>
        <c:if test="${not  empty currentPosition}">
            <li><a href="index">首页</a></li>
        </c:if>
        <c:forEach var="category" items="${categoryExpand.categories}">
            <c:if test="${currentPosition==category.epcId}">
                <li class="current"><a href="allProduct?currentPosition=${category.epcId}">${category.epcName}</a></li>
            </c:if>
            <c:if test="${currentPosition!=category.epcId}">
                <li><a href="allProduct?currentPosition=${category.epcId}">${category.epcName}</a></li>
            </c:if>
        </c:forEach>
    </ul>
</div>
