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
    <title>响应数据和结果视图 </title>
    <style type="text/css">
        tbody{color: #ff2117; background-color: beige}
    </style>
    <script type="text/javascript" src="js/jquery-3.4.1.min.js"></script>
    <%--响应json数据--%>
    <script>
        //页面加载，绑定单击事件
        $(function(){
          $("#btn").click(function () {

              //ajax编程
              $.ajax({
                  //编写json格式:api文档
                  //async:true,//异步
                  url:"user/ajax",
                  ContentType: "application/json;charset=UTF-8",
                  data:{"uname":"fslq","age":23},
                  //dataType:"json",
                  type:"POST",
                  success:function (data) {
                        //data:服务器返回的数据
                      alert("姓名："+data.uname+"\r\n年龄："+data.age);
                      //alert(data.toString())
                  }
              })
          })
        })
    </script>
</head>
<body>

<table>
    <tbody>
        <tr>
            <th>ResponseBody响应json数据</th>
        </tr>
        <tr>
            <td align="center" style="background-color: antiquewhite;color: blue">
                <input id="btn" type="button" value="发送" />
            </td>
        </tr>
    </tbody>
</table>
</body>
</html>
