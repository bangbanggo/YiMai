<%--
  Created by IntelliJ IDEA.
  User: gwb10
  Date: 2018/5/1
  Time: 14:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:forEach var="category" items="${categoryExpand.categories}">
    <dt>${category.epcName}</dt>
    <c:forEach var="cate" items="${category.categories}">
        <dd><a href="allProduct?product.epcId=${cate.epcId}">${cate.epcName}</a></dd>
    </c:forEach>
</c:forEach>
