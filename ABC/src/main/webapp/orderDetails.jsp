<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>订单详情</title>
</head>
<body>
<form action="payOrder">
    <input value="${sessionScope.orderDetails.id}" name="id"><br/>
    ${sessionScope.orderDetails.pname}<br/>
    ${sessionScope.orderDetails.price}<br/>
    购买数量:<input type="text" name="goodsTotal" value="1">
    <a href="addGoodsToShopPingCart?id=${sessionScope.orderDetails.id}&goodsTotal=1">加入购物车</a>
    <input type="submit" value="付款">
</form>
</body>
</html>
