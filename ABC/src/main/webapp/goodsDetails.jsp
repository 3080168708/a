<%@ page import="com.abc.pojo.Goods" %><%--
  Created by IntelliJ IDEA.
  User: zheng33
  Date: 2020-10-23
  Time: 10:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  isELIgnored="false" %>
<html>
<head>
    <title>商品详情</title>
</head>
<body>
<form action="addGoodsToShopPingCart">
        <tr>商品名称:${sessionScope.goodsDetails.pname}</tr><br/>
        <tr>商品单价:${sessionScope.goodsDetails.price}</tr><br/>
        <tr>商品介绍:${sessionScope.goodsDetails.details}</tr><br/>
        <input value="${sessionScope.goodsDetails.id}" name="id">
        购买数量:<input type="text" name="goodsTotal" value="1">
        <a href="atonce">立即购买</a>
        <input type="submit" value="加入购物车">
</form>
</body>
</html>
