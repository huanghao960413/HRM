<%--
  Created by IntelliJ IDEA.
  User: 忘我游
  Date: 2018-10-19
  Time: 下午 1:03
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
    <title>游客注册</title>
    <script src="js/jquery-3.2.1.js"></script>
    <script>
        var isName = false;
        var isPass = false;
        $(function () {
            $("input[name='v_name']").blur(function () {
                if ($("input[name='v_name']").val() == "") {
                    $("#v_name_msg").text("× 用户名不能为空");
                    $("#v_name_msg").css("color", "red");
                    isName = false;
                } else {
                    $.ajax({
                        type: "get",
                        url: "queryVisitorByName",
                        data: {v_name: $("input[name='v_name']").val()},
                        success: function (obj) {
                            if (obj == "false") {
                                $("#v_name_msg").text("× 此用户已存在");
                                $("#v_name_msg").css("color", "red");
                                isName = false;
                            } else {
                                $("#v_name_msg").text("√ 用户名可用");
                                $("#v_name_msg").css("color", "green");
                                isName = true;
                            }
                        }
                    });
                }
            });
            $("input[name='v_pass']").blur(function () {
                if ($("input[name='v_pass']").val() != "") {
                    $("#v_pass_msg").text("√");
                    $("#v_pass_msg").css("color", "green");
                    isPass = true;
                } else {
                    $("#v_pass_msg").text("× 密码不能为空");
                    $("#v_pass_msg").css("color", "red");
                    isPass = false;
                }
            });
            $("input[name='v_pass2']").blur(function () {
                if ($("input[name='v_pass2']").val() == ($("input[name='v_pass']").val())) {
                    $("#v_pass2_msg").text("√");
                    $("#v_pass2_msg").css("color", "green");
                    isPass = true;
                } else {
                    $("#v_pass2_msg").text("× 两次密码不同!");
                    $("#v_pass2_msg").css("color", "red");
                    isPass = false;
                }
            });
            $("form").submit(function (e) {
                if (isName == true && isPass == true) {
                    return true;
                } else {
                    e.preventDefault();
                }
            });
        });

        function add() {
            if (!confirm("确认注册？")) {
                window.event.returnValue = false;
            }
        }
    </script>
</head>
<body>
<form action="visitorRegisterDo" method="post">
    <table>
        <tr>
            <td>用户名:</td>
            <td><input type="text" name="v_name"/></td>
            <td>
                <a id="v_name_msg"></a>
            </td>
        </tr>
        <tr>
            <td>密码:</td>
            <td><input type="text" name="v_pass"/></td>
            <td>
                <a id="v_pass_msg"></a>
            </td>
        </tr>
        <tr>
            <td>确认密码:</td>
            <td><input type="text" name="v_pass2"/></td>
            <td>
                <a id="v_pass2_msg"></a>
            </td>
        </tr>
        <tr>
            <td></td>
            <td style="color: red">${requestScope.msg}</td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="注册" onclick="return add()"></td>
        </tr>
    </table>
</form>
</body>
</html>
