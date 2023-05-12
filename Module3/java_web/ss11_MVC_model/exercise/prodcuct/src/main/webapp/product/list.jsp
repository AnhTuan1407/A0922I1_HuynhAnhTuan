<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 12/04/2023
  Time: 6:10 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <title>Products</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="webjars/bootstrap/5.1.3/css/bootstrap.min.css">
</head>
<body>
<p>
    <a href="/product/create.jsp">Create new Product</a>
</p>
<table class="table">
    <thead>
    <tr>
        <th scope="col">#</th>
        <th scope="col">Name</th>
        <th scope="col">Price</th>
        <th scope="col">Description</th>
        <th scope="col">Producer</th>
        <th scope="col">Update</th>
        <th scope="col">Remove</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${product}" var="p">
        <tr>
            <td>${p.id}</td>
            <td><a href="/products?action=update&id=${p.id}">${p.name}</a></td>
            <td>${p.price}</td>
            <td>${p.description}</td>
            <td>${p.producer}</td>
            <td><a href="/products?action=update&id=${p.id}">Update</a></td>
            <td><a href="/products?action=remove&id=${p.id}">Remove</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
