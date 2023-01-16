<%--
  Created by IntelliJ IDEA.
  User: xin
  Date: 2022/5/8
  Time: 18:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        * {
            margin: 0;
            padding: 0;
        }
        html {
            height: 100%;
        }
        body {
            height: 100%;
        }
        .container {
            height: 100%;
            background-image: linear-gradient(to right, #fbc2eb, #a6c1ee);
        }
        .login-wrapper {
            background-color: #fff;
            width: 358px;
            height: 588px;
            border-radius: 15px;
            padding: 0 50px;
            position: relative;
            left: 50%;
            top: 50%;
            transform: translate(-50%, -50%);
        }
        .header {
            font-size: 38px;
            font-weight: bold;
            text-align: center;
            line-height: 200px;
        }
        .input-item {
            display: block;
            width: 100%;
            margin-bottom: 20px;
            border: 0;
            padding: 10px;
            border-bottom: 1px solid rgb(128, 125, 125);
            font-size: 15px;
            outline: none;
        }
        .input-item::placeholder {
            text-transform: uppercase;
        }
        .btn {
            text-align: center;
            padding: 10px;
            width: 100%;
            margin-top: 40px;
            background-image: linear-gradient(to right, #a6c1ee, #fbc2eb);
            color: #fff;
        }
        .msg {
            text-align: center;
            line-height: 88px;
        }
        a {
            text-decoration-line: none;
            color: #abc1ee;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="login-wrapper">
        <div class="header">注册</div>
        <div id="error_msg" style="color: red">${requestScope.msg}</div>
        <form action="${pageContext.request.contextPath}/user/addUser" method="post" class="form-wrapper">

            <input type="text" id="username"  name="username" placeholder="用户名" class="input-item">
            <input type="password" id="password" name="password" placeholder="密码" class="input-item">
            <input type="submit" id="btn" class="btn" value="注册">
            <div class="msg">
                已有账号?
                <a href="${pageContext.request.contextPath}/user/login">登入</a>
            </div>
        </form>
    </div>
</div>
</body>

<script>
    var username = document.getElementById("username");
    var password = document.getElementById("password");
    document.getElementById("btn").onclick = function () {
        var usernamePatt = /[a-zA-Z0-9]{4}/;
        var passwordPatt = /[a-zA-Z0-9]{4}/;
        if (!usernamePatt.test(username.value)) {
            document.getElementById("error_msg").innerHTML = "用户名非法";
            return false;
        }
        if (!passwordPatt.test(password.value)) {
            document.getElementById("error_msg").innerHTML = "密码位数要在";
            return false;
        }
        //return false;
    }



</script>

</html>
