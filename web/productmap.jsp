<%--
  Created by IntelliJ IDEA.
  User: gwb10
  Date: 2018/5/1
  Time: 15:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:forEach var="pro" items="${products}">
    <li>
        <dl>
            <dt><a a href="productView?product.epId=${pro.epId}" target="_blank"><img src="images/product/1.jpg" /></a></dt>
            <dd class="title"><a href="productView?product.epId=${pro.epId}" target="_blank">${pro.epName}</a></dd>
            <dd class="price">￥${pro.epPrice}</dd>
        </dl>
    </li>
</c:forEach>
