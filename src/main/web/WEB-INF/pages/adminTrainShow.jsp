<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 忘我游
  Date: 2018-10-27
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
    <title>培训项目</title>
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
                    <a class="" href="javascript:;">培训管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="adminTrainShow">培训信息管理</a></dd>
                        <dd><a href="adminTrainRecordShow">培训员工管理</a></dd>
                    </dl>
                </li>
            </ul>
        </div>
    </div>

    <div class="layui-body">
        <!-- 内容主体区域 -->
        <div style="padding: 15px;">
            <a href="adminTrainAdd">新增</a>
            <c:if test="${requestScope.trainList != null}">
                <c:forEach items="${requestScope.trainList}" var="t">
                    <div style="border:1px dashed #000">
                        <table cellspacing="0px">
                            <tr>
                                <td>${t.t_name}</td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td style="text-align: right">${t.t_start_time}-${t.t_over_time}</td>
                            </tr>
                            <tr>
                                <td colspan="5">${t.t_message}</td>
                            </tr>
                            <tr>
                                <td>${t.t_address}</td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td style="text-align: right">
                                    <a href="adminTrainUpdate?t_id=${t.t_id}">修改</a>/
                                    <a href="adminTrainDel?t_id=${t.t_id}">删除</a>
                                </td>
                            </tr>
                        </table>
                    </div>
                </c:forEach>
            </c:if>
            <c:if test="${requestScope.totalPages > 0}">
                <table>
                    <tr>
                        <td><a class="layui-btn layui-btn-sm" href="adminTrainShow?currentPage=1">首页</a></td>
                        <c:if test="${requestScope.currentPage != 1}">
                            <td><a class="layui-btn layui-btn-sm"
                                   href="adminTrainShow?currentPage=${requestScope.currentPage - 1}"><</a></td>
                        </c:if>
                        <c:forEach var="i" begin="1" end="${requestScope.totalPages}">
                            <td><a class="layui-btn layui-btn-sm" href="adminTrainShow?currentPage=${i}">${i}</a></td>
                        </c:forEach>
                        <c:if test="${requestScope.currentPage != requestScope.totalPages}">
                            <td><a class="layui-btn layui-btn-sm"
                                   href="adminTrainShow?currentPage=${requestScope.currentPage + 1}">></a></td>
                        </c:if>
                        <td><a class="layui-btn layui-btn-sm"
                               href="adminTrainShow?currentPage=${requestScope.totalPages}">尾页</a></td>
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
<script src="../../layui/layui.js"></script>
<script>
    //JavaScript代码区域
    layui.use('element', function () {
        var element = layui.element;

    });
</script>
</body>
</html>
