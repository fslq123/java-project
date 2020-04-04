<%--
  Created by IntelliJ IDEA.
  User: 22966
  Date: 2020/3/18
  Time: 12:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" >
    <!-- 4不支持默认图标 要用3 -->
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://cdn.staticfile.org/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/popper.js/1.12.5/umd/popper.min.js"></script>
    <title>添加</title>
</head>
<body>

<form action="save" method="post">
    <table class="table">
        <thead>
        <tr class="table-primary">
            <th scope="col">姓名</th>
            <th scope="col">金额</th>
            <th scope="col">操作</th>
        </tr>
        </thead>
        <tbody>
        <tr class='table-success'>
            <td>
                <input type="text" name="name">
            </td>
            <td>
                <input type="text" name="money">
            </td>
            <td>
                <input type="submit" value="保存"/>
            </td>
        </tr>
        </tbody>
    </table>
</form>
<div >
    <a href="findAll">
        <button type="button" class="btn btn-outline-danger" style="background-color: cornsilk">
            <span class="glyphicon glyphicon-arrow-left">返回</span>
        </button>
    </a>
</div>
</body>
</html>
