<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8"  pageEncoding="UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<c:forEach items="${sessionScope.sonGoods}" var="goods">
    <a href="goodsDetails?id=${goods.id}">${goods.pname}</a>
</c:forEach>
</body>
</html>

