<%--
  Created by IntelliJ IDEA.
  User: gwb10
  Date: 2018/5/1
  Time: 22:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:if test="${page.pageNow>1}">
    <li><a href="${page.url}?page.pageNow=${page.pageNow-1}&currentPosition=${currentPosition}">上一页</a></li>
</c:if>
<c:forEach var="p" begin="1" end="${page.pageTotal}" step="1">
    <c:if test="${page.pageNow == p}"><li  class="current">${p} </li> </c:if>
    <c:if test="${page.pageNow != p}"><li  class="current"><a href="${page.url}?page.pageNow=${p}&currentPosition=${currentPosition}" >${p}</a></li> </c:if>
</c:forEach>
<c:if test="${page.pageNow<page.pageTotal}">
    <li><a href="${page.url}?page.pageNow=${page.pageNow+1}&currentPosition=${currentPosition}">下一页</a></li>
</c:if>

