<%--
  Created by IntelliJ IDEA.
  User: xin
  Date: 2022/5/10
  Time: 13:10
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>书籍展示页面</title>
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
                </h1>
                <a href="${pageContext.request.contextPath}/user/logout" style="float: right">退出登入</a>

                <small style="float: right">${sessionScope.reader.username}</small>
            </div>
        </div>
        <div style="color: red">
            <h1>
                ${requestScope.error_msg}
            </h1>

        </div>
        <div class="row">
            <div class="col-md-4 column">
                <a class="btn btn-primary" href="${pageContext.request.contextPath}/reader/allBookReader">显示全部书籍</a>
            </div>
            <div class="col-md-4 column">
                <a class="btn btn-primary" href="${pageContext.request.contextPath}/reader/borrowBookListReader">借书目录</a>
            </div>
            <div class="col-md-4 column"></div>

            <div class="col-md-4 column">
                <%--查询书籍--%>
                <form action="${pageContext.request.contextPath}/reader/queryBook" method="post" class="form-inline"
                      style="float: right">
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
                    <th>书籍编号</th>
                    <th>书籍名字</th>
                    <th>书籍详情</th>
                    <th>出版社</th>
                    <th>作者</th>
                    <th>类型</th>
                    <th>操作</th>
                </tr>
                </thead>

                <%--书籍从数据库中查询出来，从这个list中遍历出来:foreach--%>
                <tbody>
                <c:forEach var="book" items="${list}" varStatus="status">
                    <tr>
                            <%--                        <div style="color: red">${requestScope.borrowmsg}</div>--%>
                        <td>${status.count}</td>
                        <td>${book.bookName}</td>
                        <td>${book.detail}</td>
                            <%--                        <td>${book.price}</td>--%>
                        <td>${book.publisher}</td>
                        <td>${book.author}</td>
                        <td>${book.bookcase.name}</td>

                        <td>
                            <c:choose>
                                <c:when test="${book.bookCounts > 0}">
                                    <a href="${pageContext.request.contextPath}/reader/borrowBook/${book.bookID}">借书</a>
                                </c:when>
                                <c:otherwise>不可借阅</c:otherwise>
                            </c:choose>
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