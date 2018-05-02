<%--
  Created by IntelliJ IDEA.
  User: gwb10
  Date: 2018/5/1
  Time: 15:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:forEach var="pro" items="${historyProducts}">
    <dt>
        <c:if test="${not empty product.epFileName}">
            <img src="images/product/${product.epFileName}"/>
        </c:if>
        <c:if test="${empty product.epFileName}">
            <img src="images/product/0.jpg"/>
        </c:if>
    </dt>
    <dd><a href="productView?product.epId=${pro.epId}" target="_blank">${pro.epName}</a></dd>
</c:forEach>
