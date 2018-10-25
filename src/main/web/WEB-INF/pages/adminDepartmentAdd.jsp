<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
    <title>新增部门</title>
</head>
<body>
<a href="adminIndex">首页</a>
<a href="adminRecruitInformationShow">招聘信息管理</a>
<hr/>
<form action="adminDepartmentAddDo" method="post">
    <table cellspacing="0px">
        <tr>
            <td>部门:</td>
            <td><input type="text" name="d_name"></td>
        </tr>
        <tr>
            <td>建立时间:</td>
            <td>
                <jsp:useBean id="now" class="java.util.Date" scope="page"/>
                <fmt:formatDate var="now" value="${now}" pattern="yyyy-MM-dd" />
                ${now}
                <input type="hidden" name="d_time" value="${now}">
            </td>
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
