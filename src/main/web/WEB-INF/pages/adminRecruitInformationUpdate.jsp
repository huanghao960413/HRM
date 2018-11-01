<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 忘我游
  Date: 2018-10-25
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
    <title>修改招聘信息</title>
    <link rel="stylesheet" href="../../layui/css/layui.css" media="all">
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo">**后台系统</div>
        <!-- 头部区域（可配合layui已有的水平导航） -->
        <ul class="layui-nav layui-layout-left">
            <li class="layui-nav-item"><a href="adminIndex">首页</a></li>
            <li class="layui-nav-item"><a href="adminRecruitInformationShow">招聘管理</a></li>
            <li class="layui-nav-item"><a href="adminStaffShow">员工管理</a></li>
            <li class="layui-nav-item"><a href="adminTrainShow">培训管理</a></li>
        </ul>
        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item">
                <a href="javascript:;">
                    <img src="../../js/hh.jpg" class="layui-nav-img">
                    admin
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
                    <a class="" href="javascript:;">招聘管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="adminRecruitInformationShow">招聘信息</a></dd>
                        <dd><a href="adminRecruitInformationAdd">新增招聘</a></dd>
                    </dl>
                </li>
            </ul>
        </div>
    </div>

    <div class="layui-body">
        <!-- 内容主体区域 -->
        <div style="padding: 15px;">
            <form action="adminRecruitInformationUpdateDo" method="post">
                <table cellspacing="0px">
                    <tr>
                        <td>职位:</td>
                        <td><input type="text" name="ri_worker" value="${requestScope.information.ri_worker}"></td>
                    </tr>
                    <tr>
                        <td>薪资:</td>
                        <td><input type="text" name="ri_salary" value="${requestScope.information.ri_salary}"></td>
                    </tr>
                    <tr>
                        <td>学历:</td>
                        <td>
                            <select name="ri_education">
                                <option value="研究生"
                                        <c:if test='${requestScope.information.ri_education=="研究生"}'>selected</c:if>>研究生
                                </option>
                                <option value="本科"
                                        <c:if test='${requestScope.information.ri_education=="本科"}'>selected</c:if>>本科
                                </option>
                                <option value="大专"
                                        <c:if test='${requestScope.information.ri_education=="大专"}'>selected</c:if>>大专
                                </option>
                                <option value="中专及以下"
                                        <c:if test='${requestScope.information.ri_education=="中专及以下"}'>selected</c:if>>
                                    中专及以下
                                </option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>经验:</td>
                        <td><input type="text" name="ri_experience" value="${requestScope.information.ri_experience}">
                        </td>
                    </tr>
                    <tr>
                        <td>人数:</td>
                        <td><input type="text" name="ri_number" value="${requestScope.information.ri_number}"></td>
                    </tr>
                    <tr>
                        <td>发布时间:</td>
                        <td>
                            ${requestScope.information.ri_time}
                            <input type="hidden" name="ri_time" value="${requestScope.information.ri_time}">
                        </td>
                    </tr>
                    <tr>
                        <td style="color: red">${requestScope.msg}</td>
                        <td></td>
                    </tr>
                    <tr>
                        <td><input hidden name="ri_id" value="${requestScope.information.ri_id}"></td>
                        <td><input type="submit" value="修改"></td>
                    </tr>
                </table>
            </form>
        </div>
    </div>

    <div class="layui-footer">
        <!-- 底部固定区域 -->
        © www.hh.com - **软件有限公司
    </div>
</div>
<script src="../../layui/layui.js"></script>
<script>

    //JavaScript代码区域
    layui.use('element', function () {
        var element = layui.element;

    });
</script>
</body>
</html>
