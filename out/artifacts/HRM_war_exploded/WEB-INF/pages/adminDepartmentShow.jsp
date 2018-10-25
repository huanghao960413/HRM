<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 忘我游
  Date: 2018-10-25
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
    <title>部门管理</title>
</head>
<body>
<a href="adminIndex">首页</a>
<hr/>
<a href="adminDepartmentAdd">新增</a>
<c:if test="${requestScope.departmentList != null}">
    <c:forEach items="${requestScope.departmentList}" var="d">
        <div style="border:1px dashed #000">
            <table cellspacing="0px">
                <tr>
                    <td>${d.d_name}</td>
                    <td>${d.d_time}</td>
                    <td style="text-align: right">
                        <a href="adminDepartmentUpdate?d_id=${d.d_id}">修改</a>/
                        <a href="adminDepartmentDel?d_id=${d.d_id}">删除</a>
                    </td>
                </tr>
            </table>
        </div>
    </c:forEach>
</c:if>
<c:if test="${requestScope.totalPages > 0}">
    <table>
        <tr>
            <td><a href="adminDepartmentShow?currentPage=1">首页</a></td>
            <c:if test="${requestScope.currentPage != 1}">
                <td><a href="adminDepartmentShow?currentPage=${requestScope.currentPage - 1}"><</a></td>
            </c:if>
            <c:forEach var="i" begin="1" end="${requestScope.totalPages}">
                <td><a href="adminDepartmentShow?currentPage=${i}">${i}</a></td>
            </c:forEach>
            <c:if test="${requestScope.currentPage != requestScope.totalPages}">
                <td><a href="adminDepartmentShow?currentPage=${requestScope.currentPage + 1}">></a></td>
            </c:if>
            <td><a href="adminDepartmentShow?currentPage=${requestScope.totalPages}">尾页</a></td>
        </tr>
    </table>
</c:if>
</body>
</html>
