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
<a href="visitor/login">游客登录</a>
<a href="visitor/register">游客注册</a>
<hr/>
<a href="staff/login">员工登录</a>
<hr/>
<a href="adminLogin">管理员登录</a>
</body>
</html>
