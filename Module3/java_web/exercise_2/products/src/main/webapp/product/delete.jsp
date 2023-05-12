<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 30/04/2023
  Time: 12:21 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete product</title>
</head>
<body>
<div align="center">
    <h2>Delete Product</h2>
    <form method="post">
        <table border="1">
            <tr hidden>
                <th>ID: </th>
                <td><c:out value="${product.id}"/></td>
            </tr>
            <tr>
                <th>Name: </th>
                <td>
                    <input type="text" name="name" size="45"
                           value="<c:out value='${product.name}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Price: </th>
                <td>
                    <input type="text" name="price" size="45"
                           value="<c:out value='${product.price}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Amount: </th>
                <td>
                    <input type="text" name="amount" size="45"
                           value="<c:out value='${product.amount}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Color: </th>
                <td>
                    <input type="text" name="color" size="45"
                           value="<c:out value='${product.color}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Description: </th>
                <td>
                    <input type="text" name="description" size="45"
                           value="<c:out value='${product.description}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Category: </th>
                <td>
                    <input type="text" name="category" size="45"
                           value="<c:out value='${product.category}' />"
                    />
                </td>
            </tr>
        </table>
        <input type="submit" value="DELETE">
    </form>
</div>
</body>
</html>
