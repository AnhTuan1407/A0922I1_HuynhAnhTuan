<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 10/04/2023
  Time: 9:23 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<html>--%>
<%--<head>--%>
<%--    <title>Customer</title>--%>
<%--</head>--%>
<%--<body>--%>
<%--<table>--%>
<%--    <tr>--%>
<%--        <td>ID</td>--%>
<%--        <td>Name</td>--%>
<%--        <td>Email</td>--%>
<%--        <td>Address</td>--%>
<%--    </tr>--%>

<%--    <c:forEach items="${customer}" var="c">--%>
<%--        <tr>--%>
<%--            <td>${c.id}</td>--%>
<%--            <td>${c.name}</td>--%>
<%--            <td>${c.email}</td>--%>
<%--            <td>${c.address}</td>--%>
<%--        </tr>--%>
<%--    </c:forEach>--%>
<%--</table>--%>
<%--</body>--%>
<%--</html>--%>

<!doctype html>
<html lang="en">
<head>
    <title>Customer</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="webjars/bootstrap/5.1.3/css/bootstrap.min.css">
</head>
<body>
<table class="table">
    <thead>
    <tr>
        <th scope="col">#</th>
        <th scope="col">First</th>
        <th scope="col">Last</th>
        <th scope="col">Handle</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${customer}" var="c">
        <tr>
            <td>${c.id}</td>
            <td>${c.name}</td>
            <td>${c.email}</td>
            <td>${c.address}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
