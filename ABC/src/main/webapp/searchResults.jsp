<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: zheng33
  Date: 2020-10-22
  Time: 23:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>搜索商品结果页面</title>
</head>
<body>
<table>
    <c:forEach items="${sessionScope.searchResults}" var="good">
    <%--搜索到的商品--%>
        <a href="goodsDetails?id=${good.id}">${good.pname}</a><br/>
    </c:forEach>
</table>
</body>
</html>
