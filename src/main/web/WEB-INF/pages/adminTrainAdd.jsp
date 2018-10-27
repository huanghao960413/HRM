<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: 忘我游
  Date: 2018-10-27
  Time: 上午 10:28
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
    <title>新增培训项目</title>
</head>
<body>
<a href="adminIndex">首页</a>
<a href="adminRecruitInformationShow">招聘信息管理</a>
<hr/>
<form action="adminTrainAddDo" method="post">
    <table cellspacing="0px">
        <tr>
            <td>培训名称:</td>
            <td><input type="text" name="t_name"></td>
        </tr>
        <tr>
            <td>培训信息:</td>
            <td><input type="text" name="t_message"></td>
        </tr>
        <tr>
            <td>开始时间:</td>
            <td><input type="date" name="t_start_time"></td>
        </tr>
        <tr>
            <td>结束时间:</td>
            <td><input type="date" name="t_over_time"></td>
        </tr>
        <tr>
            <td>培训地点:</td>
            <td><input type="text" name="t_address"></td>
        </tr>
        <tr>
            <td style="color: red">${requestScope.msg}</td>
            <td></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="新增"></td>
        </tr>
    </table>
</form>
</body>
</html>
