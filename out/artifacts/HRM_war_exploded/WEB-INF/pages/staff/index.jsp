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
    <title>员工首页</title>
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
                    <a class="" href="javascript:;">考勤管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="staff/index">考勤信息</a></dd>
                    </dl>
                </li>
            </ul>
        </div>
    </div>

    <div class="layui-body">
        <!-- 内容主体区域 -->
        <div style="padding: 15px;">
            <c:if test="${requestScope.attendanceList != null}">
                <table cellspacing="0px">
                    <tr>
                        <td>打卡日期</td>
                        <td>&nbsp;&nbsp;</td>
                        <td>上班打卡</td>
                        <td>&nbsp;&nbsp;</td>
                        <td>下班打卡</td>
                        <td>&nbsp;&nbsp;</td>
                        <td>当天状态</td>
                    </tr>
                    <c:forEach items="${requestScope.attendanceList}" var="a">
                        <tr>
                            <td>${a.a_date}</td>
                            <td>&nbsp;&nbsp;</td>
                            <td>${a.a_start_time}</td>
                            <td>&nbsp;&nbsp;</td>
                            <td>${a.a_over_time}</td>
                            <td>&nbsp;&nbsp;</td>
                            <td style="text-align: right">
                                <c:if test="${a.a_state==0}">
                                    正常
                                </c:if>
                                <c:if test="${a.a_state==1}">
                                    迟到
                                </c:if>
                                <c:if test="${a.a_state==2}">
                                    早退
                                </c:if>
                                <c:if test="${a.a_state==3}">
                                    迟到及早退
                                </c:if>
                                <c:if test="${a.a_state==4}">
                                    旷工
                                </c:if>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </c:if>
            <c:if test="${requestScope.totalPages > 0}">
                <table>
                    <tr>
                        <td><a class="layui-btn layui-btn-sm"
                               href="staff/index?currentPage=1">首页</a></td>
                        <c:if test="${requestScope.currentPage != 1}">
                            <td><a class="layui-btn layui-btn-sm"
                                   href="staff/index?currentPage=${requestScope.currentPage - 1}"><</a></td>
                        </c:if>
                        <c:forEach var="i" begin="1" end="${requestScope.totalPages}">
                            <td><a class="layui-btn layui-btn-sm" href="staff/index?currentPage=${i}">${i}</a></td>
                        </c:forEach>
                        <c:if test="${requestScope.currentPage != requestScope.totalPages}">
                            <td><a class="layui-btn layui-btn-sm"
                                   href="staff/index?currentPage=${requestScope.currentPage + 1}">></a></td>
                        </c:if>
                        <td><a class="layui-btn layui-btn-sm" href="staff/index?currentPage=${requestScope.totalPages}">尾页</a>
                        </td>
                    </tr>
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
