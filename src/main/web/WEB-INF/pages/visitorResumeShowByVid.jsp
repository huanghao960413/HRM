<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 忘我游
  Date: 2018-10-23
  Time: 上午 11:02
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
    <title>简历列表</title>
</head>
<body>
<a href="visitorIndex">首页</a>
<hr/>
<a href="visitorResumeAdd">新增</a>
<c:if test="${requestScope.resumeList != null}">
    <c:forEach items="${requestScope.resumeList}" var="r">
        <div style="border:1px dashed #000">
            <table cellspacing="0px">
                <tr>
                    <td>${r.r_title}</td>
                    <td>${r.r_state==0?"未投递":"已投递"}</td>
                    <td style="text-align: right"><a href="visitorResumeShowByRid?r_id=${r.r_id}">查看简历</a></td>
                </tr>
            </table>
        </div>
    </c:forEach>
</c:if>
</body>
</html>
