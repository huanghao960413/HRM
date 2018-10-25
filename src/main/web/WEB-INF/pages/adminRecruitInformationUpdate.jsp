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
    <title>修改招聘信息</title>
</head>
<body>
<a href="adminIndex">首页</a>
<a href="adminRecruitInformationShow">招聘信息管理</a>
<hr/>
<form action="adminRecruitInformationUpdateDo" method="post">
    <table cellspacing="0px">
        <tr>
            <td>职位:</td>
            <td><input type="text" name="ri_worker" value="${requestScope.information.ri_worker}"></td>
        </tr>
        <tr>
            <td>薪资:</td>
            <td><input type="text" name="ri_salary" value="${requestScope.information.ri_salary}"></td>
        </tr>
        <tr>
            <td>学历:</td>
            <td>
                <select name="ri_education">
                    <option value="研究生" <c:if test='${requestScope.information.ri_education=="研究生"}'>selected</c:if>>研究生</option>
                    <option value="本科" <c:if test='${requestScope.information.ri_education=="本科"}'>selected</c:if>>本科</option>
                    <option value="大专" <c:if test='${requestScope.information.ri_education=="大专"}'>selected</c:if>>大专</option>
                    <option value="中专及以下" <c:if test='${requestScope.information.ri_education=="中专及以下"}'>selected</c:if>>中专及以下</option>
                </select>
            </td>
        </tr>
        <tr>
            <td>经验:</td>
            <td><input type="text" name="ri_experience" value="${requestScope.information.ri_experience}"></td>
        </tr>
        <tr>
            <td>人数:</td>
            <td><input type="text" name="ri_number" value="${requestScope.information.ri_number}"></td>
        </tr>
        <tr>
            <td>发布时间:</td>
            <td>
                ${requestScope.information.ri_time}
                <input type="hidden" name="ri_time" value="${requestScope.information.ri_time}">
            </td>
        </tr>
        <tr>
            <td style="color: red">${requestScope.msg}</td>
            <td></td>
        </tr>
        <tr>
            <td><input hidden name="ri_id" value="${requestScope.information.ri_id}"></td>
            <td><input type="submit" value="修改"></td>
        </tr>
    </table>
</form>
</body>
</html>
