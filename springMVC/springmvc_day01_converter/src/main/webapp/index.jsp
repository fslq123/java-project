<%--
  Created by IntelliJ IDEA.
  User: 22966
  Date: 2020/3/12
  Time: 20:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>首页</title>
</head>
<body>
<h2>
    <a href="">演示获取原生API</a>
</h2>
    <h3 align="central">录入信息</h3>
    <form action="user/saveUser" method="post">
        <table>
            <thead>
                <tr>
                    姓名：<input type="text" name="username"/>
                </tr>
            </thead>
            <thead>
                <tr>
                    密码：<input type="text" name="password"/>
                </tr>
            </thead>
            <thead>
                <tr>
                    生日：<input type="text" name="birthday"/>
                </tr>
            </thead>
        </table>
        <br>
        <input type="submit" value="提交">
    </form>
</body>
</html>
