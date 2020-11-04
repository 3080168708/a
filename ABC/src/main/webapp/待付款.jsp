<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>待付款</title>
</head>
<body>
<h3 >商品     价格</h3>
<form action="payOrder">
<c:forEach items="${sessionScope.stayPayments}" var="goods">
    ${goods.pname} ${goods.price}
    <input value="${goods.id}" name="id">
    商品数量<input type="text" name="goodsTotal">
<input type="submit" value="购买"> <a href="deleteOrder?id=${goods.id}">删除此订单</a></br>
</c:forEach>
</form>
</body>
</html>
