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
    <title>投递简历</title>
</head>
<body>
<a href="visitorIndex">首页</a>
<hr/>
<form action="visitorRecruitFlowAddDo" method="post">
    <table>
        <tr>
            <td>简历标题:</td>
            <td>
                <select name="r_id">
                    <c:forEach items="${requestScope.resumeList}" var="r">
                        <option value="${r.r_id}">
                                ${r.r_title}
                        </option>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr>
            <td><input type="hidden" name="ri_id" value="${requestScope.ri_id}"></td>
            <td><input type="submit" value="投递"></td>
        </tr>
    </table>
</form>
</body>
</html>
