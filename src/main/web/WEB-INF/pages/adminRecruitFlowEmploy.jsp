<%--
  Created by IntelliJ IDEA.
  User: 忘我游
  Date: 2018-10-24
  Time: 下午 5:00
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
    <title>员工录用</title>
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
        });
    </script>
</head>
<body>
<a href="adminIndex">首页</a>
<hr/>
<form action="adminRecruitFlowEmployDo" method="post">
    <table>
        <tr>
            <td>姓名:</td>
            <td><input type="text" name="s_full_name" value="${requestScope.resume.r_name}"></td>
        </tr>
        <tr>
            <td>性别:</td>
            <td><input type="text" name="s_sex" value="${requestScope.resume.r_sex}"></td>
        </tr>
        <tr>
            <td>年龄:</td>
            <td><input type="text" name="s_age" value="${requestScope.resume.r_age}"></td>
        </tr>
        <tr>
            <td>联系方式:</td>
            <td><input type="text" name="s_phone" value="${requestScope.resume.r_phone}"></td>
        </tr>
        <tr>
            <td>Email:</td>
            <td><input type="text" name="s_email" value="${requestScope.resume.r_email}"></td>
        </tr>
        <tr>
            <td>薪资:</td>
            <td><input type="text" name="s_salary" value="${requestScope.information.ri_salary}"></td>
        </tr>
        <tr>
            <td>员工账号:</td>
            <td><input type="text" name="s_name" value="${requestScope.resume.r_phone}"></td>
        </tr>
        <tr>
            <td>员工密码:</td>
            <td><input type="text" name="s_pass" value="${requestScope.resume.r_phone}"></td>
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
            <td><input type="hidden" name="rf_id" value="${requestScope.rf_id}"></td>
            <td><input type="submit" value="录用"></td>
        </tr>
    </table>
</form>
</body>
</html>
