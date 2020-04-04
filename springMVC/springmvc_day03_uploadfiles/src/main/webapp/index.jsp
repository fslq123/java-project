<%--
  Created by IntelliJ IDEA.
  User: 22966
  Date: 2020/3/13
  Time: 15:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>文件上传 </title>
    <style type="text/css">
        tbody{color: #ff2117; background-color: #dbf5ee
        }
    </style>

</head>
<body>
<form action="upload/tranditionalFile" method="post" enctype="multipart/form-data">
    <table>
        <tbody>
            <tr>
                <th>传统方式文件上传</th>
            </tr>
            <tr>
                <td align="center" style="background-color: #ffd58d">
                    选择文件：
                </td>
                <td>
                    <input type="file" name="upload" />
                </td>
            </tr>
            <tr>
                <td>
                    <input type="submit" value="上传"/>
                </td>
            </tr>
        </tbody>
    </table>
</form>
<form action="upload/mvcFile" method="post" enctype="multipart/form-data">
    <table>
        <tbody>
        <tr>
            <th>SpringMVC方式文件上传</th>
        </tr>
        <tr>
            <td align="center" style="background-color: #ffd58d">
                选择文件：
            </td>
            <td>
                <input type="file" name="upload" />
            </td>
        </tr>
        <tr>
            <td>
                <input type="submit" value="上传"/>
            </td>
        </tr>
        </tbody>
    </table>
</form>
</body>
</html>
