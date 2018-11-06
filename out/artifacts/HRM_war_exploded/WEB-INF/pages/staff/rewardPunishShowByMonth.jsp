<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 忘我游
  Date: 2018-10-31
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
    <title>奖惩记录</title>
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
            <li class="layui-nav-item"><a class="layui-btn layui-btn-sm" href="staff/attendanceAdd"
                                          onclick="return add()">打卡</a></li>
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
                    <a class="" href="javascript:;">奖惩记录</a>
                    <dl class="layui-nav-child">
                        <dd><a href="staff/rewardPunishShow">奖惩查询</a></dd>
                    </dl>
                </li>
            </ul>
        </div>
    </div>

    <div class="layui-body">
        <!-- 内容主体区域 -->
        <div style="padding: 15px;">
            <c:if test="${requestScope.rewardPunishList != null}">
                <table cellspacing="0px">
                    <tr>
                        <td>日期</td>
                        <td>&nbsp;&nbsp;</td>
                        <td>原因</td>
                        <td>&nbsp;&nbsp;</td>
                        <td>金额</td>
                        <td>&nbsp;&nbsp;</td>
                        <td>状态</td>
                    </tr>
                    <c:forEach items="${requestScope.rewardPunishList}" var="rp">
                        <tr>
                            <td>${rp.rp_date}</td>
                            <td>&nbsp;&nbsp;</td>
                            <td>${rp.rp_message}</td>
                            <td>&nbsp;&nbsp;</td>
                            <td>${rp.rp_money}</td>
                            <td>&nbsp;&nbsp;</td>
                            <td>${rp.rp_state==0?"惩罚":"奖励"}</td>
                        </tr>
                    </c:forEach>
                </table>
            </c:if>
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
