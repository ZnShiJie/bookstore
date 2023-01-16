<%--
  Created by IntelliJ IDEA.
  User: xin
  Date: 2022/5/8
  Time: 10:02
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改信息</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- 引入 Bootstrap -->
    <link href="${pageContext.request.contextPath}/static/css/bootstrap.css" rel="stylesheet">
</head>
<body style="background-color: #E3EDCD">
<div class="container">

    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>修改信息</small>
                </h1>
            </div>
        </div>
    </div>

    <form action="${pageContext.request.contextPath}/book/updateBook" method="post">
        <%--前端传递隐藏域id--%>
        <input type="hidden" name="bookID" value="${QBook.bookID}">

        <div class="form-group">
            <label>书籍名称：</label>
            <input type="text" name="bookName" class="form-control" value="${QBook.bookName}" required>
        </div>
        <div class="form-group">
            <label>书籍数量：</label>
            <input type="text" name="bookCounts" class="form-control" value="${QBook.bookCounts}" required>
        </div>
        <div class="form-group">
            <label>书籍详情：</label>
            <input type="text" name="detail" class="form-control" value="${QBook.detail}" required>
        </div>
        <div class="form-group">
            <label>书籍价格：</label>
            <input type="text" name="price" class="form-control" value="${QBook.price}" required>
        </div>
        <div class="form-group">
            <label>书籍出版社：</label>
            <input type="text" name="publisher" class="form-control" value="${QBook.publisher}" required>
        </div>
        <div class="form-group">
            <label>书籍作者：</label>
            <input type="text" name="author" class="form-control" value="${QBook.author}" required>
        </div>
        <div class="form-group">
            <label >选择列表</label>
            <select name="bid" class="form-control" required>
                <option value="1"  <c:if test="${QBook.bookcase.id == 1}">selected</c:if>      >计算机</option>
                <option value="2"  <c:if test="${QBook.bookcase.id == 2}">selected</c:if>      >机械</option>
                <option value="3"  <c:if test="${QBook.bookcase.id == 3}">selected</c:if>      >教育</option>
                <option value="4"  <c:if test="${QBook.bookcase.id == 4}">selected</c:if>      >小说</option>
                <option value="5"  <c:if test="${QBook.bookcase.id == 5}">selected</c:if>      >地理</option>
                <option value="5"  <c:if test="${QBook.bookcase.id == 6}">selected</c:if>      >马克思主义</option>
            </select>
        </div>
        <div class="form-group">
            <input type="submit" class="form-control" value="修改">
        </div>
    </form>

</div>