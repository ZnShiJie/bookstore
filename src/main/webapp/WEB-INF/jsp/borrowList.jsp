<%--
  Created by IntelliJ IDEA.
  User: xin
  Date: 2022/5/11
  Time: 17:49
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${sessionScope.reader.username}的借书</title>
    <%--BootStrap美化界面--%>
    <link href="${pageContext.request.contextPath}/static/css/bootstrap.css" rel="stylesheet">
</head>

<body style="background-color: #E3EDCD">
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>书籍列表———显示所有书籍</small>

                    <a href="${pageContext.request.contextPath}/user/logout" style="float: right">退出登入</a>

                    <small style="float: right">${sessionScope.reader.username}</small>
                </h1>

            </div>
        </div>
        <div style="color: red">
            <h1>
                ${requestScope.error_msg}
            </h1>

        </div>

        <div class="row">
            <div class="col-md-4 column">
                <%--toAddBook--%>
<%--                <a class="btn btn-primary" href="${pageContext.request.contextPath}/book/toAddBook">新增</a>--%>
                <a class="btn btn-primary" href="${pageContext.request.contextPath}/reader/allBookReader">显示全部书籍</a>
            </div>

            <div class="col-md-4 column"></div>

            <div class="col-md-4 column">
                <%--查询书籍--%>
                <form action="${pageContext.request.contextPath}/book/queryBook" method="post" class="form-inline" style="float: right">
                    <input type="text" name="queryBookName" class="form-control" placeholder="请输入要查询的书籍名称" required>
                    <input type="submit" value="查询" class="btn btn-primary">
                </form>
            </div>
        </div>
    </div>


    <div class="row clearfix">
        <div class="col-md-12 column">
            <table class="table table-hover table-striped">
                <thead>
                <tr>
                    <th>编号</th>
                    <th>书籍名字</th>
                    <th>借书日期</th>
                    <th>还书日期</th>


                    <th>操作</th>
                </tr>
                </thead>

                <%--书籍从数据库中查询出来，从这个list中遍历出来:foreach--%>
                <tbody>
                <c:forEach var="borrow" items="${list}" varStatus="status">
                    <tr>
<%--                        <td>${status.count}</td>--%>
                        <td>${borrow.orderNumber}</td>
                        <td>${borrow.bookName}</td>
                        <td>${borrow.borrowDate}</td>
                        <td>${borrow.returnDate}</td>

                        <td>
<%--                            <a href="${pageContext.request.contextPath}/book/toUpdateBook/${book.bookID}">更改</a> |--%>
<%--                            <a href="${pageContext.request.contextPath}/book/deleteBook/${book.bookID}">删除</a>--%>
                             <a href="${pageContext.request.contextPath}/reader/returnBook/${borrow.orderNumber}">还书</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>

</div>
</body>
</html>