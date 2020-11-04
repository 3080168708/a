<%--
  Created by IntelliJ IDEA.
  User: zheng33
  Date: 2020-10-20
  Time: 22:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>用户登录</title>
</head>
<body>

    <form action="login">
        ${error}<br/>
        帐号:<input type="text" name="username"><br/>
        密码:<input type="text" name="password"><br/>
        <input type="submit" value="登录">
    </form>
</body>
</html>
