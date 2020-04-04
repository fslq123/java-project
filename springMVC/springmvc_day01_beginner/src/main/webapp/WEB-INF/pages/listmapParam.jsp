<%--
  Created by IntelliJ IDEA.
  User: 22966
  Date: 2020/3/12
  Time: 18:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>实体集合参数</title>
</head>
<body>
    <form action="listMapPerson" method="post">
        <table>
            <thead>
                <th>
                    人名：<input type="text" name="username"/>
                </th>
                <th>
                    密码：<input type="text" name="password"/>
                </th>
            </thead>
            <thead>
            <th>
                用户姓名：<input type="text" name="list[0].uname"/>
                用户年龄：<input type="text" name="list[0].age"/>
            </th>
            <th>
                用户姓名：<input type="text" name="map[1].uname"/>
                用户年龄：<input type="text" name="map[1].age"/>
            </th>
            </thead>
            <th>
                <input type="submit" value="提交"/>
            </th>
        </table>
    </form>
</body>
</html>
