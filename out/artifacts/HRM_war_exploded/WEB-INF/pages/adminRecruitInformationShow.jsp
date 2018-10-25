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
    <title>招聘信息</title>
</head>
<body>
<a href="adminIndex">首页</a>
<a href="adminRecruitInformationShow">招聘信息管理</a>
<hr/>
<a href="adminRecruitInformationAdd">新增</a>
<c:if test="${requestScope.informationList != null}">
    <c:forEach items="${requestScope.informationList}" var="i">
        <div style="border:1px dashed #000">
            <table cellspacing="0px">
                <tr>
                    <td>${i.ri_worker}</td>
                    <td></td>
                    <td>${i.ri_experience}</td>
                    <td></td>
                    <td style="text-align: right">${i.ri_time}</td>
                </tr>
                <tr>
                    <td style="color: red">${i.ri_salary}</td>
                    <td>${i.ri_education}</td>
                    <td></td>
                    <td>${i.ri_number}人</td>
                    <td style="text-align: right">
                        <a href="adminRecruitInformationUpdate?ri_id=${i.ri_id}">修改</a>/
                        <a href="adminRecruitInformationDel?ri_id=${i.ri_id}">删除</a>
                    </td>
                </tr>
            </table>
        </div>
    </c:forEach>
</c:if>
<c:if test="${requestScope.totalPages > 0}">
    <table>
        <tr>
            <td><a href="adminRecruitInformationShow?currentPage=1">首页</a></td>
            <c:if test="${requestScope.currentPage != 1}">
                <td><a href="adminRecruitInformationShow?currentPage=${requestScope.currentPage - 1}"><</a></td>
            </c:if>
            <c:forEach var="i" begin="1" end="${requestScope.totalPages}">
                <td><a href="adminRecruitInformationShow?currentPage=${i}">${i}</a></td>
            </c:forEach>
            <c:if test="${requestScope.currentPage != requestScope.totalPages}">
                <td><a href="adminRecruitInformationShow?currentPage=${requestScope.currentPage + 1}">></a></td>
            </c:if>
            <td><a href="adminRecruitInformationShow?currentPage=${requestScope.totalPages}">尾页</a></td>
        </tr>
    </table>
</c:if>
</body>
</html>
