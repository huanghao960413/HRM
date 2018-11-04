<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 忘我游
  Date: 2018-10-26
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
    <title>员工修改</title>
    <script src="js/jquery-3.2.1.js"></script>
    <script>
        $(function () {
            $.ajax({
                url: "ajaxDepartment",
                type: "get",
                dataType: "json", //以json的形式返回，易解析 "json",
                async: false,
                success: function (departmentList) {
                    $("#department").empty();// jq写法 清除部门下拉框的所有内容，然后拼接上从后台取出来的数据
                    $("<option value=''>--请选择--</option>").appendTo("#department");
                    for (var i = 0; i < departmentList.length; i++) {//获取departmentList里面的数据，拼接到select上
                        if (departmentList[i].d_id == ${requestScope.staff.d_id}) {
                            $("#department").append("<option value='" + departmentList[i].d_id + "' selected >" + departmentList[i].d_name + "</option>");
                        } else {
                            $("#department").append("<option value='" + departmentList[i].d_id + "'>" + departmentList[i].d_name + "</option>");
                        }
                    }
                },
            });
            $.ajax({
                url: "ajaxPosition",
                type: "get",
                data: {"d_id": $("#department").val()},
                dataType: "json",
                async: false,
                success: function (positionList) {
                    for (var i = 0; i < positionList.length; i++) {//获取positionList里面的数据，拼接到select上
                        if (positionList[i].p_id == ${requestScope.staff.p_id}) {
                            $("#position").append("<option value='" + positionList[i].p_id + "' selected >" + positionList[i].p_name + "</option>");
                        } else {
                            $("#position").append("<option value='" + positionList[i].p_id + "'>" + positionList[i].p_name + "</option>");
                        }
                    }
                },
            });
            $("#department").change(function () {
                $("#position").empty();// jq写法 清除职位下拉框的所有内容，然后拼接上从后台取出来的数据
                $("<option value=''>--请选择--</option>").appendTo("#position");
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
            $("#re_pass").click(function () {
                $("#re_pass").empty();
                $("#pass").attr('type', 'password');
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
                <a class="" href="javascript:;">员工管理</a>
                <dl class="layui-nav-child">
                    <dd><a href="adminDepartmentShow">部门管理</a></dd>
                    <dd><a href="adminPositionShow">职位管理</a></dd>
                    <dd><a href="adminStaffShow">员工管理</a></dd>
                </dl>
            </ul>
        </div>
    </div>

    <div class="layui-body">
        <!-- 内容主体区域 -->
        <div style="padding: 15px;">
<form action="adminStaffUpdateDo" method="post">
    <table cellspacing="0">
        <tr>
            <td>员工信息</td>
            <td colspan="5">
                <hr/>
            </td>
        </tr>
        <tr>
            <td>账号:</td>
            <td>
                ${requestScope.staff.s_name}
                <input hidden name="s_name" value="${requestScope.staff.s_name}">
            </td>
        </tr>
        <tr>
            <td>密码:</td>
            <td>
                <a id="re_pass">重置密码</a>
                <input type="hidden" id="pass" name="s_pass" value="${requestScope.staff.s_pass}">
            </td>
        </tr>
        <tr>
            <td>姓名:</td>
            <td>
                ${requestScope.staff.s_full_name}
                <input hidden name="s_full_name" value="${requestScope.staff.s_full_name}">
            </td>
        </tr>
        <tr>
            <td>性别:</td>
            <td>
                ${requestScope.staff.s_sex}
                <input hidden name="s_sex" value="${requestScope.staff.s_sex}">
            </td>
        </tr>
        <tr>
            <td>年龄:</td>
            <td>
                ${requestScope.staff.s_age}
                <input hidden name="s_age" value="${requestScope.staff.s_age}">
            </td>
        </tr>
        <tr>
            <td>联系方式:</td>
            <td>
                ${requestScope.staff.s_phone}
                <input hidden name="s_phone" value="${requestScope.staff.s_phone}">
            </td>
        </tr>
        <tr>
            <td>Email:</td>
            <td>
                ${requestScope.staff.s_email}
                <input hidden name="s_email" value="${requestScope.staff.s_email}">
            </td>
        </tr>
        <tr>
            <td>薪资:</td>
            <td>
                <input type="text" name="s_salary" value="${requestScope.staff.s_salary}">
            </td>
        </tr>
        <tr>
            <td>部门:</td>
            <td>
                <select name="d_id" id="department">
                    <option value="">--请选择--</option>
                </select>
            </td>
        </tr>
        <tr>
            <td>职位:</td>
            <td>
                <select name="p_id" id="position">
                    <option value="">--请选择--</option>
                </select>
            </td>
        </tr>
        <tr>
            <td>员工状态:</td>
            <td>
                <select name="s_state">
                    <option value="">--请选择--</option>
                    <option value="0" <c:if test="${requestScope.staff.s_state==0}">selected</c:if>>试用</option>
                    <option value="1" <c:if test="${requestScope.staff.s_state==1}">selected</c:if>>在职</option>
                    <option value="2" <c:if test="${requestScope.staff.s_state==2}">selected</c:if>>休假</option>
                    <option value="-1" <c:if test="${requestScope.staff.s_state==-1}">selected</c:if>>离职</option>
                </select>
            </td>
        </tr>
        <tr>
            <td></td>
            <td>${requestScope.msg}</td>
        </tr>
        <tr>
            <td>
                <input hidden name="s_id" value="${requestScope.staff.s_id}"/>
            </td>
            <td>
                <input type="submit" value="修改">
            </td>
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
