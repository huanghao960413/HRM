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
    <link rel="stylesheet" href="../../../layui/css/layui.css" media="all">
    <style>
        .td1 {
            width: 15%;
        }
    </style>
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo">**游客系统</div>
        <!-- 头部区域（可配合layui已有的水平导航） -->
        <ul class="layui-nav layui-layout-left">
            <li class="layui-nav-item"><a href="visitor/index">首页</a></li>
            <li class="layui-nav-item"><a href="visitor/resumeShowByVid">简历管理</a></li>
        </ul>
        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item">
                <a>
                    <img src="../../../layui/images/face/5.gif" class="layui-nav-img">
                    ${sessionScope.visitor.v_name}
                </a>
            </li>
            <li class="layui-nav-item"><a href="">退出</a></li>
        </ul>
    </div>

    <div class="layui-side layui-bg-black">
        <div class="layui-side-scroll">
            <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
            <ul class="layui-nav layui-nav-tree" lay-filter="test">
                <li class="layui-nav-item layui-nav-itemed">
                    <a class="" href="javascript:;">简历管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="visitor/resumeAdd">新增简历</a></dd>
                        <dd><a href="visitor/resumeShowByVid">简历列表</a></dd>
                    </dl>
                </li>
            </ul>
        </div>
    </div>

    <div class="layui-body">
        <!-- 内容主体区域 -->
        <div style="padding: 15px;">
            <a class="layui-btn layui-btn-sm" href="visitor/resumeUpdate?r_id=${requestScope.resume.r_id}">修改</a>
            <a class="layui-btn layui-btn-sm" href="visitor/resumeDel?r_id=${requestScope.resume.r_id}">删除</a>
            <hr/>
            <span>简历标题:${requestScope.resume.r_title}</span>
            <table border="1" cellspacing="0" width="300px">
                <tr>
                    <td>基本信息</td>
                    <td colspan="5">
                        <hr/>
                    </td>
                </tr>
                <tr>
                    <td>*姓名:</td>
                    <td class="td1">${requestScope.resume.r_name}</td>
                    <td>*性别:</td>
                    <td class="td1">${requestScope.resume.r_sex}</td>
                    <td>*年龄:</td>
                    <td class="td1">${requestScope.resume.r_age}</td>
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
        </div>
    </div>

    <div class="layui-footer">
        <!-- 底部固定区域 -->
        © www.hh.com - **软件有限公司
    </div>
</div>
<script src="../../../layui/layui.js"></script>
<script>
    //JavaScript代码区域
    layui.use('element', function () {
        var element = layui.element;

    });
</script>
</body>
</html>
