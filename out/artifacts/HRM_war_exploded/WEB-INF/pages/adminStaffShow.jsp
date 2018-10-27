<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 忘我游
  Date: 2018-10-26
  Time: 上午 10:00
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
    <title>员工管理</title>
</head>
<body>
<a href="adminIndex">首页</a>
<hr/>
<a href="adminStaffAdd">新增</a>
<c:if test="${requestScope.staffList != null}">
    <c:forEach items="${requestScope.staffList}" var="s" varStatus="loop">
        <div style="border:1px dashed #000">
            <table cellspacing="0px">
                <tr>
                    <td>${departmentList[loop.count-1].d_name}</td>
                    <td>${positionList[loop.count-1].p_name}</td>
                    <td>${s.s_name}</td>
                    <td>${s.s_phone}</td>
                    <td>
                        <c:if test="${s.s_state==0}">试用</c:if>
                        <c:if test="${s.s_state==1}">在职</c:if>
                        <c:if test="${s.s_state==2}">休假</c:if>
                        <c:if test="${s.s_state==-1}">离职</c:if>
                    </td>
                    <td style="text-align: right">
                        <a href="adminStaffUpdate?s_id=${s.s_id}">管理</a>
                    </td>
                </tr>
            </table>
        </div>
    </c:forEach>
</c:if>
<c:if test="${requestScope.totalPages > 0}">
    <table>
        <tr>
            <td><a href="adminStaffShow?currentPage=1">首页</a></td>
            <c:if test="${requestScope.currentPage != 1}">
                <td><a href="adminStaffShow?currentPage=${requestScope.currentPage - 1}"><</a></td>
            </c:if>
            <c:forEach var="i" begin="1" end="${requestScope.totalPages}">
                <td><a href="adminStaffShow?currentPage=${i}">${i}</a></td>
            </c:forEach>
            <c:if test="${requestScope.currentPage != requestScope.totalPages}">
                <td><a href="adminStaffShow?currentPage=${requestScope.currentPage + 1}">></a></td>
            </c:if>
            <td><a href="adminStaffShow?currentPage=${requestScope.totalPages}">尾页</a></td>
        </tr>
    </table>
</c:if>
</body>
</html>
