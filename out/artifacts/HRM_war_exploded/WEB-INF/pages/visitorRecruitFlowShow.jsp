<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 忘我游
  Date: 2018-10-21
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
<a href="visitorIndex">首页</a>
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
                    <c:if test="${f.rf_state==1}">
                        <td>应聘失败</td>
                    </c:if>
                    <c:if test="${f.rf_state==0}">
                        <td>等待邀请</td>
                    </c:if>
                    <c:if test="${f.rf_state==1}">
                        <td>面试时间:${f.rf_time}</td>
                    </c:if>
                    <c:if test="${f.rf_state==2}">
                        <td>等待结果</td>
                    </c:if>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td style="text-align: right"><a href="visitorRecruitFlowDel?rf_id=${f.rf_id}">取消</a></td>
                </tr>
            </table>
        </div>
    </c:forEach>
</c:if>
<c:if test="${requestScope.totalPages > 0}">
    <table>
        <tr>
            <td><a href="visitorRecruitFlowShow?currentPage=1">首页</a></td>
            <c:if test="${requestScope.currentPage != 1}">
                <td><a href="visitorRecruitFlowShow?currentPage=${requestScope.currentPage - 1}"><</a></td>
            </c:if>
            <c:forEach var="i" begin="1" end="${requestScope.totalPages}">
                <td><a href="visitorRecruitFlowShow?currentPage=${i}">${i}</a></td>
            </c:forEach>
            <c:if test="${requestScope.currentPage != requestScope.totalPages}">
                <td><a href="visitorRecruitFlowShow?currentPage=${requestScope.currentPage + 1}">></a></td>
            </c:if>
            <td><a href="visitorRecruitFlowShow?currentPage=${requestScope.totalPages}">尾页</a></td>
        </tr>
    </table>
</c:if>
</body>
</html>
