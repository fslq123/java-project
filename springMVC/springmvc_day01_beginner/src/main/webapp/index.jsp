<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: 22966
  Date: 2020/3/12
  Time: 8:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h3>入门程序</h3>
        <a href="hello">入门程序</a>
<p>
    <a href="test?username=fslq">测试</a>
    <a href="param/postParam?username=fslq">传参</a>
</p>
<p1>
    <h3>封装实体类</h3>
    <form action="param/saveAccount" method="post">
        <table>
            <tbody>
                <tr>
                    姓名：<input type="text" name="username"/>
                </tr>
                <tr>
                    密码：<input type="text" name="password"/>
                </tr>
                <tr>
                    金额：<input type="text" name="money"/>
                </tr>
            </tbody>
            <thead>
                <th>
                    用户姓名：<input type="text" name="user.uname"/>
                </th>
                <th>
                    用户年龄：<input type="text" name="user.age"/>
                </th>
            </thead>
            <th>
                 <input type="submit" value="提交">
            </th>
        </table>
    </form>
</p1>
</body>
</html>
