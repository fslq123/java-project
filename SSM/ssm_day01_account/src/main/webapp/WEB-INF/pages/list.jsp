<%--
  Created by IntelliJ IDEA.
  User: 22966
  Date: 2020/3/16
  Time: 22:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>列表</title>
</head>
<body>
<p style="background: bisque" align="center">查询</p>
<c:forEach items="${accounts}" var="account">
    <p style="background: cornsilk" align="center">账号：${account.id}    姓名：${account.name}    金额：${account.money}</p>
</c:forEach>
</body>
</html>
