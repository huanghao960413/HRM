<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 忘我游
  Date: 2018-10-22
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
    <title>应聘信息</title>
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
                    <a class="" href="javascript:;">投递管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="adminIndex">招聘信息</a></dd>
                    </dl>
                </li>
            </ul>
        </div>
    </div>

    <div class="layui-body">
        <!-- 内容主体区域 -->
        <div style="padding: 15px;">
            <c:if test="${requestScope.flowList != null}">
                <c:forEach items="${requestScope.flowList}" var="f" varStatus="loop">
                    <div style="border:1px dashed #000">
                        <table cellspacing="0px">
                            <tr>
                                <td>${requestScope.resumeList[loop.count-1].r_name}</td>
                                <td>&nbsp;&nbsp;</td>
                                <td>${f.rf_consult==0?"未阅":"已阅"}</td>
                                <td>&nbsp;&nbsp;</td>
                                <td><a class="layui-btn layui-btn-sm" href="adminResumeShow?rf_id=${f.rf_id}">查看简历</a></td>
                                <td>&nbsp;&nbsp;</td>
                                <td style="text-align: right">
                                    <c:if test="${f.rf_state>-1 && f.rf_state<3}">
                                        <c:if test="${f.rf_state==0}">
                                            <a class="layui-btn layui-btn-sm" href="adminRecruitFlowInterview?rf_id=${f.rf_id}">邀请面试</a>
                                        </c:if>
                                        <c:if test="${f.rf_state==1}">
                                            <a>等待面试</a>/
                                        </c:if>
                                        <c:if test="${f.rf_state==2}">
                                            <a class="layui-btn layui-btn-sm" href="adminRecruitFlowEmploy?rf_id=${f.rf_id}">录用</a>
                                        </c:if>
                                        <a class="layui-btn layui-btn-sm" href="adminRecruitFlowEliminate?rf_id=${f.rf_id}">淘汰</a>
                                    </c:if>
                                    <c:if test="${f.rf_state==-1}">
                                        <a style="color: red">已淘汰</a>
                                    </c:if>
                                    <c:if test="${f.rf_state==3}">
                                        <a style="color: lawngreen">已录用</a>
                                    </c:if>
                                </td>
                            </tr>
                        </table>
                    </div>
                </c:forEach>
            </c:if>
            <c:if test="${requestScope.totalPages > 0}">
                <table>
                    <tr>
                        <td><a class="layui-btn layui-btn-sm"
                               href="adminRecruitFlowShow?ri_id=${requestScope.ri_id}&currentPage=1">首页</a></td>
                        <c:if test="${requestScope.currentPage != 1}">
                            <td><a class="layui-btn layui-btn-sm"
                                   href="adminRecruitFlowShow?ri_id=${requestScope.ri_id}&currentPage=${requestScope.currentPage - 1}"><</a>
                            </td>
                        </c:if>
                        <c:forEach var="i" begin="1" end="${requestScope.totalPages}">
                            <td><a class="layui-btn layui-btn-sm"
                                   href="adminRecruitFlowShow?ri_id=${requestScope.ri_id}&currentPage=${i}">${i}</a>
                            </td>
                        </c:forEach>
                        <c:if test="${requestScope.currentPage != requestScope.totalPages}">
                            <td><a class="layui-btn layui-btn-sm"
                                   href="adminRecruitFlowShow?ri_id=${requestScope.ri_id}&currentPage=${requestScope.currentPage + 1}">></a>
                            </td>
                        </c:if>
                        <td><a class="layui-btn layui-btn-sm"
                               href="adminRecruitFlowShow?ri_id=${requestScope.ri_id}&currentPage=${requestScope.totalPages}">尾页</a>
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
<script src="../../layui/layui.js"></script>
<script>
    //JavaScript代码区域
    layui.use('element', function () {
        var element = layui.element;

    });
</script>
</body>
</html>
