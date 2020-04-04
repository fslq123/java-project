<%--
  Created by IntelliJ IDEA.
  User: 22966
  Date: 2020/3/13
  Time: 15:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>显示</title>
    <style type="text/css">
        thead{color:red;background-color: aquamarine}
        tbody{color: cornflowerblue;background-color: bisque}
    </style>
</head>
<body>
    <table>
        <thead>
            <tr>
                <th>姓名</th>
                <th>年龄</th>
                <th>生日</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td>${user.uname}</td>
                <td>${user.age}</td>
                <td>${user.birthday}</td>
            </tr>
        </tbody>
    </table>
</body>
</html>
