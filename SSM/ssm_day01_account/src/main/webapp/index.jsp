<%--
  Created by IntelliJ IDEA.
  User: 22966
  Date: 2020/3/16
  Time: 14:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>首页</title>
</head>
<body>
<p style="background: bisque" align="center">操作</p>
<a href="account/findAll">查询所有</a>
<form action="account/save" style="background: #bedded;color: #ff5711">
    <table align="center">
        <tbody align="center">
            <tr>姓名：</tr>
            <tr><input type="text" name="name"> </tr>
        </tbody>
        <br>
        <tbody align="center">
            <tr>金额：</tr>
            <tr><input type="text" name="money"> </tr>
        </tbody>
        <input type="submit" value="保存" align="center">
    </table>
</form>
</body>
</html>
