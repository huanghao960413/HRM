<%--
  Created by IntelliJ IDEA.
  User: 11929
  Date: 2018/10/19
  Time: 10:42
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
    <title>测试首页</title>
</head>
<body>
<a href="visitorLogin">游客登录</a>
<a href="visitorRegister">游客注册</a>
</body>
</html>
