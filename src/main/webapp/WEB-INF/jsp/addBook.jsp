<%--
  Created by IntelliJ IDEA.
  User: xin
  Date: 2022/5/8
  Time: 10:04
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>新增书籍</title>
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
                        <small>新增书籍</small>
                    </h1>
                </div>
            </div>
        </div>

        <form action="${pageContext.request.contextPath}/book/addBook" method="post">
            <div class="form-group">
                <label>书籍名称：</label>
                <input type="text" name="bookName" class="form-control" required>
            </div>
            <div class="form-group">
                <label>书籍数量：</label>
                <input type="text" name="bookCounts" class="form-control" required>
            </div>
            <div class="form-group">
                <label>书籍详情：</label>
                <input type="text" name="detail" class="form-control" required>
            </div>
            <div class="form-group">
                <label>价格：</label>
                <input type="text" name="price" class="form-control" required>
            </div>
            <div class="form-group">
                <label>出版社：</label>
                <input type="text" name="publisher" class="form-control" required>
            </div>
            <div class="form-group">
                <label>作者：</label>
                <input type="text" name="author" class="form-control" required>
            </div>
            <div class="form-group">
                <label >选择列表</label>
                <select id="bookcase" name="bid" class="form-control" required>
                    <option value="1">计算机</option>
                    <option value="2">机械</option>
                    <option value="3">教育</option>
                    <option value="4">小说</option>
                    <option value="5">地理</option>
                    <option value="5">马克思主义</option>
                </select>
            </div>
            <div class="form-group">
                <input type="submit" class="form-control" value="添加">
            </div>


        </form>


    </div>
</body>

<script>

</script>

</html>