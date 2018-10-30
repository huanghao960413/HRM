<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: 忘我游
  Date: 2018-10-30
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
    <title>新增员工培训</title>
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
</head>
<body>
<a href="adminIndex">首页</a>
<hr/>
<form action="adminTrainRecordAddDo" method="post">
    <table cellspacing="0px">
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
            <td>员工:</td>
            <td>
                <select name="s_id" id="staff">
                    <option value="">--请选择--</option>
                </select>
            </td>
        </tr>
        <tr>
            <td><input hidden name="t_id" value="${requestScope.t_id}"></td>
            <td><input type="submit" value="新增"></td>
        </tr>
    </table>
</form>
</body>
</html>
