<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: gwb10
  Date: 2018/5/1
  Time: 16:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
您现在的位置：<a href="index">易买网</a>
<c:forEach var="category" items="${categoryExpand.categories}">
    <c:if test="${currentPosition == category.epcId}">
        &gt;<a href="allProduct?currentPosition=${category.epcId}">${category.epcName}</a>
    </c:if>
    <c:forEach var="cate" items="${category.categories}">
        <c:if test="${currentPosition == cate.epcId}">
            &gt;<a href="allProduct?currentPosition=${category.epcId}">${category.epcName}</a> &gt; ${cate.epcName}
        </c:if>
    </c:forEach>
</c:forEach>

<%--<a href="allProduct?product.epcId=${cate.epcId}">${cate.epcName}</a>--%>
<%--您现在的位置：<a href="index">易买网</a> &gt; <a href="index">${category.epcName}</a> &gt; ${cate.epcName}--%>
