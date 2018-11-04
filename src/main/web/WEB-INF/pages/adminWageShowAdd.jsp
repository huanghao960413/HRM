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
    <title>结算薪资</title>
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
            <li class="layui-nav-item"><a href="adminRewardPunishShow">奖惩管理</a></li>
            <li class="layui-nav-item"><a href="adminWageShow">薪资管理</a></li>
        </ul>
        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item">
                <a>
                    <img src="../../layui/images/face/5.gif" class="layui-nav-img">
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
                    <a class="" href="javascript:;">薪资管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="adminWageShow">薪资查询</a></dd>
                        <dd><a href="adminWageAdd">薪资结算</a></dd>
                    </dl>
                </li>
            </ul>
        </div>
    </div>

    <div class="layui-body">
        <!-- 内容主体区域 -->
        <div style="padding: 15px;">
            <form action="adminWageAddDo" method="post">
                <table>
                    <tr>
                        <td>日期:</td>
                        <td><input type="month" name="w_date" value="${requestScope.wage.w_date}"></td>
                    </tr>
                    <tr>
                        <td>基本薪资:</td>
                        <td><input type="text" name="w_salary" value="${requestScope.wage.w_salary}"></td>
                    </tr>
                    <tr>
                        <td>绩效:</td>
                        <td><input type="text" name="w_performance" value="${requestScope.wage.w_performance}"></td>
                    </tr>
                    <tr>
                        <td>加班:</td>
                        <td><input type="text" name="w_overtime" value="${requestScope.wage.w_overtime}"></td>
                    </tr>
                    <tr>
                        <td>奖惩:</td>
                        <td><input type="text" name="w_reward_punish" value="${requestScope.wage.w_reward_punish}"></td>
                    </tr>
                    <tr>
                        <td>社保:</td>
                        <td><input type="text" name="w_social_security" value="${requestScope.wage.w_social_security}"></td>
                    </tr>
                    <tr>
                        <td><input hidden name="s_id" value="${requestScope.s_id}"></td>
                        <td><input type="submit" value="结算"></td>
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