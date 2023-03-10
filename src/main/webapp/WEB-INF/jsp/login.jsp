<%--
  Created by IntelliJ IDEA.
  User: xin
  Date: 2022/5/8
  Time: 15:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
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
        <div class="header">??????</div>
        <div id="error_msg" style="color: red">${requestScope.msg}</div>
        <form action="${pageContext.request.contextPath}/user/signIn" method="post" class="form-wrapper">

            <input type="text" id="username"  name="username" placeholder="?????????" class="input-item">
            <input type="password" name="password" placeholder="??????" class="input-item">
            <div class="title">????????????:
                <input type="radio" name="type" value="reader" checked="checked"/>&nbsp;&nbsp;??????&nbsp;&nbsp;
                <input type="radio" name="type" value="admin"/>&nbsp;&nbsp;?????????
            </div>
            <input type="submit" class="btn" value="??????">

        </form>
        <div class="msg">
            ?????????????
            <a href="${pageContext.request.contextPath}/user/signUp">??????</a>
        </div>
    </div>
</div>
</body>



</html>
