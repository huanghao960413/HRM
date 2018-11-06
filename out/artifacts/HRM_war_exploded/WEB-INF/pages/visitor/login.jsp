<%--
  Created by IntelliJ IDEA.
  User: 忘我游
  Date: 2018-10-19
  Time: 下午 12:30
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
    <title>游客登录</title>
    <style>
        html {
            background-color: white;
        }

        .wrapper {
            margin: 140px 0 140px auto;
            width: 884px;
        }

        .loginBox {
            background-color: #F0F4F6;
            /*上divcolor*/
            border: 1px solid #BfD6E1;
            border-radius: 5px;
            color: #444;
            font: 14px 'Microsoft YaHei', '微软雅黑';
            margin: 0 auto;
            width: 388px
        }

        .loginBox .loginBoxHeader {
            border-bottom: 1px solid #DDE0E8;
            padding: 10px 24px;
        }

        .loginBox .loginBoxCenter {
            border-bottom: 1px solid #DDE0E8;
            padding: 10px 24px;
        }

        .loginBox .loginBoxCenter p {
            margin-bottom: 10px
        }

        .loginBox .loginBoxButtons {
            /*background-color: #F0F4F6;*/
            /*下divcolor*/
            border-top: 0px solid #FFF;
            border-bottom-left-radius: 5px;
            border-bottom-right-radius: 5px;
            line-height: 28px;
            overflow: hidden;
            padding: 20px 24px;
            vertical-align: center;
            filter: alpha(Opacity=80);
            -moz-opacity: 0.5;
            opacity: 0.5;
        }

        .loginBox .loginInput {
            border: 1px solid #D2D9dC;
            border-radius: 2px;
            color: #444;
            font: 12px 'Microsoft YaHei', '微软雅黑';
            padding: 8px 14px;
            margin-bottom: 8px;
            width: 310px;
        }

        .loginBox .loginInput:FOCUS {
            border: 1px solid #B7D4EA;
            box-shadow: 0 0 8px #B7D4EA;
        }

        .loginBox .loginBtn {
            background-image: -moz-linear-gradient(to bottom, blue, #85CFEE);
            border: 1px solid #98CCE7;
            border-radius: 20px;
            box-shadow: inset rgba(255, 255, 255, 0.6) 0 1px 1px, rgba(0, 0, 0, 0.1) 0 1px 1px;
            color: #444;
            /*登录*/
            cursor: pointer;
            float: right;
            font: bold 13px Arial;
            padding: 10px 50px;
        }

        .loginBox .loginBtn:HOVER {
            background-image: -moz-linear-gradient(to top, blue, #85CFEE);
        }

        .loginBox a.forgetLink {
            color: #ABABAB;
            cursor: pointer;
            float: right;
            font: 11px/20px Arial;
            text-decoration: none;
            vertical-align: middle;
            /*忘记密码*/
        }

        .loginBox a.forgetLink:HOVER {
            color: #000000;
            text-decoration: none;
            /*忘记密码*/
        }

        .loginBox input#remember {
            vertical-align: middle;
        }

        .loginBox label[for="remember"] {
            font: 11px Arial;
        }
    </style>
</head>
<body>
<div class="wrapper">
    <form action="visitor/loginDo" method="post">
        <div class="loginBox">
            <div class="loginBoxHeader">
                <h2>游客登录</h2>
            </div>
            <div class="loginBoxCenter">
                <p><label for="username">用户名：</label></p>
                <!--autofocus 规定当页面加载时按钮应当自动地获得焦点。 -->
                <!-- placeholder提供可描述输入字段预期值的提示信息-->
                <p><input type="text" id="username" name="v_name" class="loginInput" autofocus="autofocus"
                          required="required" autocomplete="off" placeholder="请输入用户名" value=""/></p>
                <!-- required 规定必需在提交之前填写输入字段-->
                <p><label for="password">密码：</label></p>
                <p><input type="password" id="password" name="v_pass" class="loginInput" required="required"
                          placeholder="请输入密码" value=""/></p>
                <p><a style="color: red">${requestScope.msg}</a></p>
            </div>
            <div class="loginBoxButtons">
                <input class="loginBtn" type="submit" value="登录">
                <div><a href="visitor/register">游客注册</a></div>
            </div>
        </div>
    </form>
</div>
</body>
</html>
