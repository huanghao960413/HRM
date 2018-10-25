<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 忘我游
  Date: 2018-10-25
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
    <title>修改部门</title>
</head>
<body>
<a href="adminIndex">首页</a>
<a href="adminRecruitInformationShow">招聘信息管理</a>
<hr/>
<form action="adminDepartmentUpdateDo" method="post">
    <table cellspacing="0px">
        <tr>
            <td>部门:</td>
            <td><input type="text" name="d_name" value="${requestScope.department.d_name}"></td>
        </tr>
        <tr>
            <td>建立时间:</td>
            <td>
                ${requestScope.department.d_time}
                <input hidden name="d_time" value="${requestScope.department.d_time}">
            </td>
        </tr>
        <tr>
            <td style="color: red">${requestScope.msg}</td>
            <td></td>
        </tr>
        <tr>
            <td><input hidden name="d_id" value="${requestScope.department.d_id}"></td>
            <td><input type="submit" value="修改"></td>
        </tr>
    </table>
</form>
</body>
</html>
