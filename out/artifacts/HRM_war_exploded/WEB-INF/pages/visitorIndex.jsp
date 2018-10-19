<%--
  Created by IntelliJ IDEA.
  User: 忘我游
  Date: 2018-10-19
  Time: 下午 12:28
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
    <title>游客首页</title>
</head>
<body>
 游客首页
</body>
</html>
