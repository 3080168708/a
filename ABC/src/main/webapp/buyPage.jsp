<%--
  Created by IntelliJ IDEA.
  User: zheng33
  Date: 2020-10-31
  Time: 14:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="payOrder">
    <%--立即购买商品--%>
    <tr>商品名称:${sessiounScope.goodsDetails.pname}</tr><br/>
    <tr>商品单价:${sessionScope.goodsDetails.price}</tr><br/>
    <tr>商品介绍:${sessionScope.goodsDetails.details}</tr><br/>
    <input value="${sessionScope.goodsDetails.id}" name="id">
    购买数量:<input type="text" value="1" name="goodsTotal" >
    <input type="submit" value="支付"> <a href="cancelBuy?id=${sessionScope.goodsDetails.id}">取消本次付款</a>
</form>
</body>
</html>
