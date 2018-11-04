<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 忘我游
  Date: 2018-10-29
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
    <title>薪资复议</title>
    <link rel="stylesheet" href="../../../layui/css/layui.css" media="all">
    <script>
        function add() {
            if (!confirm("确认要打卡吗？")) {
                window.event.returnValue = false;
            }
        }
    </script>
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo">**员工系统</div>
        <!-- 头部区域（可配合layui已有的水平导航） -->
        <ul class="layui-nav layui-layout-left">
            <li class="layui-nav-item"><a href="staff/index">首页</a></li>
            <li class="layui-nav-item"><a href="staff/staffShow">通讯录</a></li>
            <li class="layui-nav-item"><a href="staff/trainRecordShow">员工培训</a></li>
            <li class="layui-nav-item"><a href="staff/rewardPunishShow">奖惩记录</a></li>
            <li class="layui-nav-item"><a href="staff/wageShow">员工薪资</a></li>
            <li class="layui-nav-item"><a class="layui-btn layui-btn-sm" href="staff/attendanceAdd" onclick="return add()">打卡</a></li>
        </ul>

        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item">
                <a>
                    <img src="../../../layui/images/face/5.gif" class="layui-nav-img">
                    ${sessionScope.staff.s_name}
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
                    <a class="" href="javascript:;">员工薪资</a>
                    <dl class="layui-nav-child">
                        <dd><a href="staff/wageShow">薪资查看</a></dd>
                    </dl>
                </li>
            </ul>
        </div>
    </div>

    <div class="layui-body">
        <!-- 内容主体区域 -->
        <div style="padding: 15px;">
            <form action="staff/wageReviewAddDo" method="post">
                <table>
                    <tr>
                        <td>复议原因:</td>
                        <td><input type="text" name="wr_message"></td>
                    </tr>
                    <tr>
                        <td>复议状态:</td>
                        <td>
                            <select name="wr_state">
                                <option value="0">少</option>
                                <option value="1">多</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>复议金额:</td>
                        <td><input type="text" name="wr_money"></td>
                    </tr>
                    <tr>
                        <td><input hidden name="w_id" value="${requestScope.w_id}"></td>
                        <td><input type="submit" value="复议"></td>
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
<script src="../../../layui/layui.js"></script>
<script>
    //JavaScript代码区域
    layui.use('element', function () {
        var element = layui.element;

    });
</script>
</body>
</html>
