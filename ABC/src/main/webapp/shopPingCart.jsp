<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>购物车</title>
</head>
<body>
    <h3 align="center">购物车列表</h3>
    <%--购物车中的数据--%>
    <h3 align="center">商品名称     商品单价     商品个数     总价</h3>
    <c:forEach items="${sessionScope.UserShopPingCarts}" var="goods">
<%--                                                                                                                          根据购物车中的商品的id删除在购物车中取消购买的商品                                          --%>
        <h3 align="center">${goods.goodsName}     ${goods.goodsPrice}     ${goods.goodsTotal}     ${goods.goodsTotalPrice}    <a href="AccordingIdDeleteGoods?id=${goods.id}">取消</a></h3><tr/><br/>
    </c:forEach>
    <%--    结算购物车中的所有商品--%>
    <a href="stayShipments">${sessionScope.sumMoney}   结算</a>
</body>
</html>

