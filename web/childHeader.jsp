<%--
  Created by IntelliJ IDEA.
  User: gwb10
  Date: 2018/5/2
  Time: 16:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:forEach var="category" items="${categoryExpand.categories}">
    <%--<dt>${category.epcName}</dt>--%>

    <%--当没有进二级分类时,显示所有--%>
    <c:if test="${empty currentPosition}">
        <c:forEach var="cate" items="${category.categories}">
            <li><a href="allProduct?product.epcId=${cate.epcId}">${cate.epcName}</a></li>
        </c:forEach>
    </c:if>

    <c:if test="${not  empty currentPosition}">
        <c:forEach var="cate" items="${category.categories}">
            <c:if test="${cate.epcParentId==currentPosition}">
            <li><a href="allProduct?product.epcId=${cate.epcId}">${cate.epcName}</a></li>
            </c:if>
        </c:forEach>
    </c:if>
</c:forEach>
