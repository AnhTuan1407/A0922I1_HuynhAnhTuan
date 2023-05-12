<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 11/04/2023
  Time: 10:15 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Customer</title>
</head>
<body>
<link rel="stylesheet" href="/webjars/bootstrap/5.1.3/css/bootstrap.min.css">
<form method="post" action="/customers?action=create">
    <div class="row">
        <div class="col">
            <input type="text" class="form-control" placeholder="ID" name="id">
        </div>
    </div>
    <div class="row">
        <div class="col">
            <input type="text" class="form-control" placeholder="Name" name="name">
        </div>
    </div>

    <div class="row">
        <div class="col">
            <input type="text" class="form-control" placeholder="Email" name="email">
        </div>
    </div>

    <div class="row">
        <div class="col">
            <input type="text" class="form-control" placeholder="Address" name="address">
        </div>
    </div>

    <input type="submit" value="Create">
</form>
</body>
</html>
