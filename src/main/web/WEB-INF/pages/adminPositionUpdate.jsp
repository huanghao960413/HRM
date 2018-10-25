<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 忘我游
  Date: 2018-10-25
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
    <title>修改职位</title>
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
                        if (departmentList[i].d_id == ${requestScope.position.d_id}) {
                            $("#department").append("<option value='" + departmentList[i].d_id + "' selected >" + departmentList[i].d_name + "</option>");
                        } else {
                            $("#department").append("<option value='" + departmentList[i].d_id + "'>" + departmentList[i].d_name + "</option>");
                        }
                    }
                },
            });
        });
    </script>
</head>
<body>
<a href="adminIndex">首页</a>
<a href="adminRecruitInformationShow">招聘信息管理</a>
<hr/>
<form action="adminPositionUpdateDo" method="post">
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
            <td><input name="p_name" value="${requestScope.position.p_name}"></td>
        </tr>
        <tr>
            <td style="color: red">${requestScope.msg}</td>
            <td></td>
        </tr>
        <tr>
            <td><input hidden name="p_id" value="${requestScope.position.p_id}"></td>
            <td><input type="submit" value="修改"></td>
        </tr>
    </table>
</form>
</body>
</html>
