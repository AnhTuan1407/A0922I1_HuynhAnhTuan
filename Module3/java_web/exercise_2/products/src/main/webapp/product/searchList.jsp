<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 05/05/2023
  Time: 1:04 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Searching Products</title>
</head>
<body>
<div align="center">
  <table border="1" style="text-align: center">
    <tr>
      <th>ID</th>
      <th>Name</th>
      <th>Price</th>
      <th>Amount</th>
      <th>Color</th>
      <th>Description</th>
      <th>Category</th>
    </tr>

    <c:forEach var="product" items="${product}">
      <tr>
        <td><c:out value="${product.id}"/></td>
        <td><c:out value="${product.name}"/></td>
        <td><c:out value="${product.price}"/></td>
        <td><c:out value="${product.amount}"/></td>
        <td><c:out value="${product.color}"/></td>
        <td><c:out value="${product.description}"/></td>
        <td><c:out value="${product.category}"/></td>
      </tr>
    </c:forEach>
  </table>
</div>
</body>
</html>