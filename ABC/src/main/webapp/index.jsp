<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>页面</title>
</head>
<body>

<div>
    <a href="手机数码.jsp">手机数码</a>
    <a href="户外运动.jsp">运动户外</a>
    <a href="电脑办公.jsp">电脑办公</a>
    <a href="家具家居.jsp">家具家居</a>
    <a href="鞋靴箱包.jsp">鞋靴箱包</a>
    <a href="图书影像.jsp">图书影像</a>
    <a href="母婴孕婴.jsp">母婴孕婴</a>
    <a href="汽车用品.jsp">汽车用品</a>
    <form action="searchGoods" align="right">
        搜索商品:<input type="text" name="goodsName" placeholder="搜索商品">
        <input type="submit" value="搜索">
    </form>
</div><br/>

        <a href="login.jsp">登录    </a>
        <a href="register.jsp">注册    </a>
        <a href="SetPassword.jsp">修改密码    </a>
        <a href="selectUserShopPingCart">购物车    </a>
        <a href="exit">退出    </a>
        <a href="my">我的</a><br/>
<table>
    <c:forEach items="${sessionScope.goods}" var="goodss">
        <a href="goodsDetails?id=${goodss.id}">${goodss.pname}</a><br/>
    </c:forEach>
</table>
<%--<jsp:forward page="findAllGoods"></jsp:forward>--%>
订单数据没有入数据库
</body>
</html>
