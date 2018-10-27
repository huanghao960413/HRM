<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <title>培训项目</title>
</head>
<body>
<a href="adminIndex">首页</a>
<a href="">招聘信息管理</a>
<hr/>
<a href="adminTrainAdd">新增</a>
<c:if test="${requestScope.trainList != null}">
    <c:forEach items="${requestScope.trainList}" var="t">
        <div style="border:1px dashed #000">
            <table cellspacing="0px">
                <tr>
                    <td>${t.t_name}</td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td style="text-align: right">${t.t_start_time}-${t.t_over_time}</td>
                </tr>
                <tr>
                    <td colspan="5">${t.t_message}</td>
                </tr>
                <tr>
                    <td>${t.t_address}</td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td style="text-align: right">
                        <a href="adminTrainUpdate?t_id=${t.t_id}">修改</a>/
                        <a href="adminTrainDel?t_id=${t.t_id}">删除</a>
                    </td>
                </tr>
            </table>
        </div>
    </c:forEach>
</c:if>
<c:if test="${requestScope.totalPages > 0}">
    <table>
        <tr>
            <td><a href="adminTrainShow?currentPage=1">首页</a></td>
            <c:if test="${requestScope.currentPage != 1}">
                <td><a href="adminTrainShow?currentPage=${requestScope.currentPage - 1}"><</a></td>
            </c:if>
            <c:forEach var="i" begin="1" end="${requestScope.totalPages}">
                <td><a href="adminTrainShow?currentPage=${i}">${i}</a></td>
            </c:forEach>
            <c:if test="${requestScope.currentPage != requestScope.totalPages}">
                <td><a href="adminTrainShow?currentPage=${requestScope.currentPage + 1}">></a></td>
            </c:if>
            <td><a href="adminTrainShow?currentPage=${requestScope.totalPages}">尾页</a></td>
        </tr>
    </table>
</c:if>
</body>
</html>
