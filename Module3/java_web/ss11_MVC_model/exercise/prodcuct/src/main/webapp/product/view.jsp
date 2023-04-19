<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 12/04/2023
  Time: 9:17 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>View Product</title>
</head>
<body>
<h1>View Product</h1>
<p>
    <a href="/products">Back to product list</a>
</p>
<form method="post" action="/products?action=view">
    <fieldset>
        <legend>Product information</legend>
        <table>
            <tr>
                <td>ID: </td>
                <td><input readonly type="hidden" name="id" id="id" value="${product.id}"></td>
            </tr>
            <tr>
                <td>Name: </td>
                <td><input readonly type="text" name="name" id="name" value="${product.name}"></td>
            </tr>
            <tr>
                <td>Price: </td>
                <td><input readonly type="text" name="price" id="price" value="${product.price}"></td>
            </tr>
            <tr>
                <td>Description: </td>
                <td><input readonly type="text" name="description" id="description" value="${product.description}"></td>
            </tr>
            <tr>
                <td>Producer: </td>
                <td><input readonly type="text" name="producer" id="producer" value="${product.producer}"></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>