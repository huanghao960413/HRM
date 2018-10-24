<%--
  Created by IntelliJ IDEA.
  User: 忘我游
  Date: 2018-10-20
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
    <title>修改简历</title>
</head>
<body>
<a href="visitorIndex">首页</a>
<form action="visitorResumeUpdateDo" method="post">
    <table>
        <tr><hr/></tr>
        <tr>
            <td>简历标题:</td>
            <td><input type="text" name="r_title" value="${requestScope.resume.r_title}"></td>
        </tr>
        <tr><hr/></tr>
        <tr>
            <td>基本信息</td>
            <td>
                <input type="hidden" name="r_id" value="${requestScope.resume.r_id}">
                <input type="hidden" name="v_id" value="${requestScope.resume.v_id}">
                <input type="hidden" name="r_state" value="${requestScope.resume.r_state}">
            </td>
        </tr>
        <tr><hr/></tr>
        <tr>
            <td>*姓名:</td>
            <td><input type="text" name="r_name" value="${requestScope.resume.r_name}"></td>
        </tr>
        <tr>
            <td>*性别:</td>
            <td><input type="text" name="r_sex" value="${requestScope.resume.r_sex}"></td>
        </tr>
        <tr>
            <td>*所在地:</td>
            <td><input type="text" name="r_location" value="${requestScope.resume.r_location}"></td>
        </tr>
        <tr>
            <td>*年龄:</td>
            <td><input type="text" name="r_age" value="${requestScope.resume.r_age}"></td>
        </tr>
        <tr>
            <td>*联系方式:</td>
            <td><input type="text" name="r_phone" value="${requestScope.resume.r_phone}"></td>
        </tr>
        <tr>
            <td>*Email:</td>
            <td><input type="text" name="r_email" value="${requestScope.resume.r_email}"></td>
        </tr>
        <tr><td><hr/></td></tr>
        <tr>
            <td>教育背景</td>
            <td></td>
        </tr>
        <tr>
            <td>时间:</td>
            <td><input type="text" name="r_school_time" value="${requestScope.resume.r_school_time}"></td>
        </tr>
        <tr>
            <td>毕业院校:</td>
            <td><input type="text" name="r_school" value="${requestScope.resume.r_school}"></td>
        </tr>
        <tr>
            <td>专业:</td>
            <td><input type="text" name="r_major" value="${requestScope.resume.r_major}"></td>
        </tr>
        <tr>
            <td>学历:</td>
            <td><input type="text" name="r_education" value="${requestScope.resume.r_education}"></td>
        </tr>
        <tr><td><hr/></td></tr>
        <tr>
            <td>工作经验</td>
            <td></td>
        </tr>
        <tr>
            <td>时间:</td>
            <td><input type="text" name="r_worker_time" value="${requestScope.resume.r_worker_time}"></td>
        </tr>
        <tr>
            <td>职位:</td>
            <td><input type="text" name="r_worker" value="${requestScope.resume.r_worker}"></td>
        </tr>
        <tr>
            <td>职责:</td>
            <td><input type="text" name="r_worker_experience" value="${requestScope.resume.r_worker_experience}"></td>
        </tr>
        <tr><td><hr/></td></tr>
        <tr>
            <td>求职意向</td>
            <td></td>
        </tr>
        <tr>
            <td>职位:</td>
            <td><input type="text" name="r_job_intention" value="${requestScope.resume.r_job_intention}"></td>
        </tr>
        <tr><td><hr/></td></tr>
        <tr>
            <td>其他</td>
            <td></td>
        </tr>
        <tr>
            <td>奖项:</td>
            <td><input type="text" name="r_certificate" value="${requestScope.resume.r_certificate}"></td>
        </tr>
        <tr>
            <td>爱好:</td>
            <td><input type="text" name="r_hobby" value="${requestScope.resume.r_hobby}"></td>
        </tr>
        <tr>
            <td>自我评价:</td>
            <td><input type="text" name="r_self_assessment" value="${requestScope.resume.r_self_assessment}"></td>
        </tr>
        <tr>
            <td></td>
            <td style="color: red">${requestScope.msg}</td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="修改" onclick="return add()"></td>
        </tr>
    </table>
</form>
</body>
</html>
