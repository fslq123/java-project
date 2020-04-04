<%--
  Created by IntelliJ IDEA.
  User: 22966
  Date: 2020/3/13
  Time: 15:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>响应数据和结果视图 </title>
    <style type="text/css">
        tbody{color: coral ; background-color: beige}
    </style>
</head>
<body>
<h4>响应数据</h4>
<form action="responses/user" method="post">
    <table>
         <tbody>
             <tr>
                <td>姓名：</td>
                <td>
                    <input type="text" name="uname"/>
                </td>
             </tr>
             <tr>
                <td>年龄：</td>
                <td>
                    <input type="text" name="age"/>
                </td>
            </tr>
            <tr>
                <td>生日：</td>
                <td>
                    <input type="text" name="birthday"/>
                </td>
            </tr>
         </tbody>
    </table>
    <input type="submit" value="提交">
</form>
<h4>页面跳转</h4>
<a href="responses/void">跳转</a>
<h4>模型和视图</h4>
<form action="responses/modelAndView" method="post">
    <table>
        <tbody>
        <tr>
            <td>姓名：</td>
            <td>
                <input type="text" name="uname"/>
            </td>
        </tr>
        <tr>
            <td>年龄：</td>
            <td>
                <input type="text" name="age"/>
            </td>
        </tr>
        <tr>
            <td>生日：</td>
            <td>
                <input type="text" name="birthday"/>
            </td>
        </tr>
        </tbody>
    </table>
    <input type="submit" value="提交">
</form>
<h4>按关键字跳转</h4>
<a href="responses/forwardOrRedirect">跳转</a>
</body>
</html>
