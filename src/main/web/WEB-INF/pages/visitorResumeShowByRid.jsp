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
    <title>简历查看</title>
</head>
<body>
<a href="visitorIndex">首页</a>
<hr/>
<a href="visitorResumeUpdate?r_id=${requestScope.resume.r_id}">修改</a>
<a href="visitorResumeDel?r_id=${requestScope.resume.r_id}">删除</a>
<hr/>
<span>简历标题:${requestScope.resume.r_title}</span>
<table border="1" cellspacing="0">
    <tr>
        <td>基本信息</td>
        <td colspan="5"><hr/></td>
    </tr>
    <tr>
        <td>*姓名:</td>
        <td>${requestScope.resume.r_name}</td>
        <td>*性别:</td>
        <td>${requestScope.resume.r_sex}</td>
        <td>*年龄:</td>
        <td>${requestScope.resume.r_age}</td>
    </tr>
    <tr>
        <td>*所在地:</td>
        <td colspan="5">${requestScope.resume.r_location}</td>
    </tr>
    <tr>
        <td>*联系方式:</td>
        <td colspan="5">${requestScope.resume.r_phone}</td>
    </tr>
    <tr>
        <td>*Email:</td>
        <td colspan="5">${requestScope.resume.r_email}</td>
    </tr>
    <tr>
        <td>教育背景</td>
        <td colspan="5">
            <hr/>
        </td>
    </tr>
    <tr>
        <td>毕业院校:</td>
        <td>${requestScope.resume.r_school}</td>
        <td>专业:</td>
        <td>${requestScope.resume.r_major}</td>
        <td>学历:</td>
        <td>${requestScope.resume.r_education}</td>
    </tr>
    <tr>
        <td>时间:</td>
        <td colspan="5">${requestScope.resume.r_school_time}</td>
    </tr>
    <tr>
        <td>工作经验</td>
        <td colspan="5">
            <hr/>
        </td>
    </tr>
    <tr>
        <td>时间:</td>
        <td colspan="5">${requestScope.resume.r_worker_time}</td>
    </tr>
    <tr>
        <td>职位:</td>
        <td>${requestScope.resume.r_worker}</td>
        <td>职责:</td>
        <td colspan="3">${requestScope.resume.r_worker_experience}</td>
    </tr>
    <tr>
        <td>求职意向</td>
        <td colspan="5">
            <hr/>
        </td>
    </tr>
    <tr>
        <td>职位:</td>
        <td colspan="5">${requestScope.resume.r_job_intention}</td>
    </tr>
    <tr>
        <td>其他</td>
        <td colspan="5">
            <hr/>
        </td>
    </tr>
    <tr>
        <td>奖项:</td>
        <td colspan="5">${requestScope.resume.r_certificate}</td>
    </tr>
    <tr>
        <td>爱好:</td>
        <td colspan="5">${requestScope.resume.r_hobby}</td>
    </tr>
    <tr>
        <td>自我评价:</td>
        <td colspan="5">${requestScope.resume.r_self_assessment}</td>
    </tr>
</table>
</body>
</html>
