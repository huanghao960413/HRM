<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 忘我游
  Date: 2018-10-30
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
    <title>员工培训管理</title>
</head>
<body>
<a href="adminIndex">首页</a>
<hr/>
<a href="adminTrainRecordAdd?t_id=${requestScope.t_id}">新增员工培训</a>
<c:if test="${requestScope.recordList!=null}">
    <c:forEach items="${requestScope.recordList}" var="r" varStatus="loop">
        <div style="border:1px dashed #000">
            <table cellspacing="0px">
                <tr>
                    <td>${requestScope.staffList[loop.count-1].s_name}</td>
                    <td>${requestScope.staffList[loop.count-1].s_phone}</td>
                    <td>${r.tr_score}</td>
                    <td style="text-align: right">
                        <c:if test="${r.tr_state==0}">
                            <a href="adminTrainRecordDel?tr_id=${r.tr_id}">删除培训</a>
                        </c:if>
                    </td>
                </tr>
            </table>
        </div>
    </c:forEach>
</c:if>
<c:if test="${requestScope.totalPages > 0}">
    <table>
        <tr>
            <td><a href="adminTrainRecordShowByTid?t_id=${requestScope.t_id}&currentPage=1">首页</a></td>
            <c:if test="${requestScope.currentPage != 1}">
                <td><a href="adminTrainRecordShowByTid?t_id=${requestScope.t_id}&currentPage=${requestScope.currentPage - 1}"><</a></td>
            </c:if>
            <c:forEach var="i" begin="1" end="${requestScope.totalPages}">
                <td><a href="adminTrainRecordShowByTid?t_id=${requestScope.t_id}&currentPage=${i}">${i}</a></td>
            </c:forEach>
            <c:if test="${requestScope.currentPage != requestScope.totalPages}">
                <td><a href="adminTrainRecordShowByTid?t_id=${requestScope.t_id}&currentPage=${requestScope.currentPage + 1}">></a></td>
            </c:if>
            <td><a href="adminTrainRecordShowByTid?t_id=${requestScope.t_id}&currentPage=${requestScope.totalPages}">尾页</a></td>
        </tr>
    </table>
</c:if>
</body>
</html>
