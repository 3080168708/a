<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>待收货</title>
</head>
<body>
<h3 align="center">商品    价格</h3>
<c:forEach items="${sessionScope.stayReceivings}" var="goods">
    <h3 align="center">${goods.goodsName} ${goods.goodsPrice}x${goods.goodsTotal} <a href="Receivings?id=${goods.id}">已收货</a></h3><br/>
</c:forEach>
</body>
</html>

