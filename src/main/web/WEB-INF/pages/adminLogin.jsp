<%--
  Created by IntelliJ IDEA.
  User: 忘我游
  Date: 2018-10-21
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
    <title>管理员登录</title>
    <link rel="stylesheet" href="../../layui/css/layui.css" media="all">
</head>
<body>
<div>
    <header class="layui-elip">后台登录</header>
    <form action="adminLoginDo" method="post" class="layui-form">
        <div class="layui-input-inline">
            <label class="layui-form-label">账号</label>
            <div class="layui-input-block">
                <input type="text" name="a_name" required lay-verify="required" autocomplete="off"
                       class="layui-input">
            </div>
        </div><br/>
        <div class="layui-input-inline">
            <label class="layui-form-label">密码</label>
            <div class="layui-input-block">
                <input type="password" name="a_pass" required lay-verify="required" autocomplete="off"
                       class="layui-input">
            </div>
        </div><br/>
        <div class="layui-input-inline login-btn">
            <label class="layui-form-label">&nbsp;</label>
            <div class="layui-input-block">
                <input type="submit" class="layui-btn" value="登录"></input>
            </div>
        </div>
    </form>
</div>
</body>
</html>
