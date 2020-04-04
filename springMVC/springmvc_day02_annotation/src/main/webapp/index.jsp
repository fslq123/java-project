<%--
  Created by IntelliJ IDEA.
  User: 22966
  Date: 2020/3/13
  Time: 7:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>常用注解</title>
</head>
<body>
<h1>常用注解</h1>
<a href="param/requestParam?name=fslq">RequestParam</a><br>
<form action="body/requestBody" method="post">
    <table>
        <th>
            用户姓名：<input type="text" name="uname"/>
        </th>
        <th>
            用户年龄：<input type="text" name="uage"/>
        </th>
        <th>
            用户生日：<input type="text" name="birthday"/>
        </th>
    </table>
    <input type="submit" value="RequestBody"/>
</form>
<a href="rest/pathVaribale/1314521">PathVaribale</a>
<p>
    HiddentHttpMethodFilter
    <br>
    RequestHeader
</p>
<a href="cookie/cookieValue">CookieValue</a>
<br>
<h4>ModelAttribute</h4>
<a href="model/pojo?uname=fslq">基于POJO</a>
<form action="model/map" method="post">
    <table>
        <th>
            用户姓名：<input type="text" name="uname"/>
        </th>
        <th>
            用户年龄：<input type="text" name="uage"/>
        </th>
    </table>
    <input type="submit" value="RequestBody"/>
</form>
<h4>SessionAttribute</h4>
    <a href="session/put">存入</a>
    <a href="session/get">获取</a>
    <a href="session/clean">清除</a>
</body>
</html>
