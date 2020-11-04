<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java"  isELIgnored="false" %>
<html>
<head>
    <title>待发货</title>
</head>
<body>
    <c:forEach items="${sessionScope.stayShipments}" var="stayShipmentsGoods">
        ${stayShipmentsGoods.goodsName}
        ${stayShipmentsGoods.goodsPrice}
        <a href="Shipments?id=${stayShipmentsGoods.id}">发货</a>
    </c:forEach>
</body>
</html>
