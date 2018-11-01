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
    <title>应聘信息</title>
    <link rel="stylesheet" href="../../../layui/css/layui.css" media="all">
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
                    <a class="" href="javascript:;">投递管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="visitor/index">招聘信息</a></dd>
                        <dd><a href="visitor/recruitFlowShow">投递管理</a></dd>
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
                                <td>${informationList[loop.count-1].ri_worker}</td>
                                <td>&nbsp;</td>
                                <td style="color: red">${informationList[loop.count-1].ri_salary}</td>
                                <td>&nbsp;</td>
                                <td style="text-align: right">${f.rf_consult==0?"未阅":"已阅"}</td>
                            </tr>
                            <tr>
                                <c:if test="${f.rf_state==-1}">
                                    <td>已淘汰</td>
                                </c:if>
                                <c:if test="${f.rf_state==0}">
                                    <td>等待邀请</td>
                                </c:if>
                                <c:if test="${f.rf_state==1}">
                                    <td>面试时间:${f.rf_time}</td>
                                </c:if>
                                <c:if test="${f.rf_state==2}">
                                    <td>等待结果</td>
                                </c:if>
                                <td>&nbsp;</td>
                                <td>&nbsp;</td>
                                <td>&nbsp;</td>
                                <td style="text-align: right">
                                    <c:if test="${f.rf_state==1}">
                                        <a href="visitor/recruitFlowInterview?rf_id=${f.rf_id}">确认面试</a>
                                    </c:if>
                                        <%--<a href="visitorRecruitFlowDel?rf_id=${f.rf_id}">取消</a>--%>
                                </td>
                            </tr>
                        </table>
                    </div>
                </c:forEach>
            </c:if>
            <c:if test="${requestScope.totalPages > 0}">
                <table>
                    <tr>
                        <td><a class="layui-btn layui-btn-sm" href="visitor/recruitFlowShow?currentPage=1">首页</a></td>
                        <c:if test="${requestScope.currentPage != 1}">
                            <td><a class="layui-btn layui-btn-sm" href="visitor/recruitFlowShow?currentPage=${requestScope.currentPage - 1}"><</a></td>
                        </c:if>
                        <c:forEach var="i" begin="1" end="${requestScope.totalPages}">
                            <td><a class="layui-btn layui-btn-sm" href="visitor/recruitFlowShow?currentPage=${i}">${i}</a></td>
                        </c:forEach>
                        <c:if test="${requestScope.currentPage != requestScope.totalPages}">
                            <td><a class="layui-btn layui-btn-sm" href="visitor/recruitFlowShow?currentPage=${requestScope.currentPage + 1}">></a></td>
                        </c:if>
                        <td><a class="layui-btn layui-btn-sm" href="visitor/recruitFlowShow?currentPage=${requestScope.totalPages}">尾页</a></td>
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
