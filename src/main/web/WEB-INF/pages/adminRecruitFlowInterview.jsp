<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 忘我游
  Date: 2018-10-24
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
    <title>面试邀请</title>
    <script src="js/jquery-3.2.1.js"></script>
    <script>
        $(document).ready(function () {
            $.ajax({
                url: "ajaxDepartment",
                type: "get",
                dataType: "json", //以json的形式返回，易解析 "json",
                async: false,
                success: function (departmentList) {
                    $("#department").empty();// jq写法 清除部门下拉框的所有内容，然后拼接上从后台取出来的数据
                    $("<option value=''>--请选择--</option>").appendTo("#department");
                    for (var i = 0; i < departmentList.length; i++) {//获取departmentList里面的数据，拼接到select上
                        $("#department").append("<option value='" + departmentList[i].d_id + "'>" + departmentList[i].d_name + "</option>");
                    }
                },
            });
            $("#department").change(function () {
                $("#position").empty();// jq写法 清除职位下拉框的所有内容，然后拼接上从后台取出来的数据
                $("<option value=''>--请选择--</option>").appendTo("#position");
                $("#staff").empty();
                $("<option value=''>--请选择--</option>").appendTo("#staff");
                $.ajax({
                    url: "ajaxPosition",
                    type: "get",
                    data: {"d_id": $("#department").val()},
                    dataType: "json",
                    async: false,
                    success: function (positionList) {
                        for (var i = 0; i < positionList.length; i++) {//获取positionList里面的数据，拼接到select上
                            $("#position").append("<option value='" + positionList[i].p_id + "'>" + positionList[i].p_name + "</option>");
                        }
                    },
                });
            });
            $("#position").change(function () {
                $("#staff").empty();//清除下拉列表的内容
                $("<option value=''>--请选择--</option>").appendTo("#staff");
                $.ajax({
                    url: "ajaxStaff",
                    type: "get",
                    data: {"p_id": $("#position").val()},
                    dataType: "json",
                    async: false,
                    success: function (staffList) {
                        for (var i = 0; i < staffList.length; i++) {
                            $("#staff").append("<option value='" + staffList[i].s_id + "'>" + staffList[i].s_full_name + ":" + staffList[i].s_name + "</option>");
                        }
                    },
                });
            });
        });
    </script>
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
            <form action="adminRecruitFlowInterviewDo" method="post">
                <table>
                    <tr>
                        <td>面试人员:</td>
                        <td>
                            <select id="department">
                                <option value="">--请选择--</option>
                            </select>
                            <select id="position">
                                <option value="">--请选择--</option>
                            </select>
                            <select name="s_id" id="staff">
                                <option value="">--请选择--</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>面试时间:</td>
                        <td>
                            <input type="date" name="rf_time">
                        </td>
                    </tr>
                    <tr>
                        <td></td>
                        <td style="color: red">${requestScope.msg}</td>
                    </tr>
                    <tr>
                        <td><input type="hidden" name="rf_id" value="${requestScope.rf_id}"></td>
                        <td><input class="layui-btn layui-btn-sm" type="submit" value="邀请"></td>
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
