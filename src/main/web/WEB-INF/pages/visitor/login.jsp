<%--
  Created by IntelliJ IDEA.
  User: 忘我游
  Date: 2018-10-19
  Time: 下午 12:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <base href="<%=basePath%>"/>
    <title>游客登录</title>
</head>
<body>
<form action="visitor/loginDo" method="post">
    <table>
        <tr>
            <td>用户名:</td>
            <td><input type="text" name="v_name"></td>
        </tr>
        <tr>
            <td>密码:</td>
            <td><input type="text" name="v_pass"></td>
        </tr>
        <tr>
            <td></td>
            <td style="color: red">${requestScope.msg}</td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="登录"></td>
        </tr>
    </table>
</form>
</body>
</html>
