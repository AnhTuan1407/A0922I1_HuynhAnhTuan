<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 10/04/2023
  Time: 4:49 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Customer List</title>
  <link rel="stylesheet" href="/static/css/bootstrap.css">
</head>
<body>
<h1>Customer List</h1>
<form action="/customers" method="get">
  <table class="table">
    <thead>
    <tr>
      <td>Name</td>
      <td>Date of birth</td>
      <td>Address</td>
      <td>Image</td>
    </tr>
    </thead>

    <tbody>
    <c:forEach items = "${customerList}" var="customer">
      <tr>
        <td>${customer.nameCustomer}</td>
        <td>${customer.dateOfBirth}</td>
        <td>${customer.address}</td>
        <td>
          <img src="/static/img/avatar.png" ${customer.image} width="50px">
        </td>
      </tr>
    </c:forEach>
    </tbody>
  </table>
</form>
</body>
</html>
