<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 忘我游
  Date: 2018-10-22
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
    <title>应聘信息</title>
</head>
<body>
<a href="adminIndex">首页</a>
<hr/>
<c:if test="${requestScope.flowList != null}">
    <c:forEach items="${requestScope.flowList}" var="f" varStatus="loop">
        <div style="border:1px dashed #000">
            <table cellspacing="0px">
                <tr>
                    <td>${informationList[loop.count-1].ri_worker}</td>
                    <td></td>
                    <td style="color: red">${informationList[loop.count-1].ri_salary}</td>
                    <td></td>
                    <td style="text-align: right">${f.rf_consult==0?"未阅":"已阅"}</td>
                </tr>
                <tr>
                    <td><a href="adminResumeShow?rf_id=${f.rf_id}">查看简历</a></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td style="text-align: right">
                        <c:if test="${f.rf_state>-1 && f.rf_state<3}">
                            <c:if test="${f.rf_state==0}">
                                <a href="adminRecruitFlowInterview?rf_id=${f.rf_id}">邀请面试</a>/
                            </c:if>
                            <c:if test="${f.rf_state==1}">
                                <a>等待面试</a>/
                            </c:if>
                            <c:if test="${f.rf_state==2}">
                                <a href="adminRecruitFlowEmploy?rf_id=${f.rf_id}">录用</a>/
                            </c:if>
                            <a href="adminRecruitFlowEliminate?rf_id=${f.rf_id}">淘汰</a>
                        </c:if>
                        <c:if test="${f.rf_state==-1}">
                            <a style="color: red">已淘汰</a>
                        </c:if>
                        <c:if test="${f.rf_state==3}">
                            <a style="color: lawngreen">已录用</a>
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
            <td><a href="adminRecruitFlowShow?currentPage=1">首页</a></td>
            <c:if test="${requestScope.currentPage != 1}">
                <td><a href="adminRecruitFlowShow?currentPage=${requestScope.currentPage - 1}"><</a></td>
            </c:if>
            <c:forEach var="i" begin="1" end="${requestScope.totalPages}">
                <td><a href="adminRecruitFlowShow?currentPage=${i}">${i}</a></td>
            </c:forEach>
            <c:if test="${requestScope.currentPage != requestScope.totalPages}">
                <td><a href="adminRecruitFlowShow?currentPage=${requestScope.currentPage + 1}">></a></td>
            </c:if>
            <td><a href="adminRecruitFlowShow?currentPage=${requestScope.totalPages}">尾页</a></td>
        </tr>
    </table>
</c:if>
</body>
</html>
