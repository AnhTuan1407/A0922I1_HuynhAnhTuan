<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 12/04/2023
  Time: 6:10 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Remove Product</title>
</head>
<body>
<h1>Remove Product</h1>
<p>
    <a href="/products">Back to product list</a>
</p>
<form method="post" action="/products?action=remove">
    <fieldset>
        <legend>Product information</legend>
        <table>
            <tr>
                <td>ID: </td>
                <td><input type="hidden" name="id" id="id" value="${product.id}"></td>
            </tr>
            <tr>
                <td>Name: </td>
                <td><input type="text" name="name" id="name" value="${product.name}"></td>
            </tr>
            <tr>
                <td>Price: </td>
                <td><input type="text" name="price" id="price" value="${product.price}"></td>
            </tr>
            <tr>
                <td>Description: </td>
                <td><input type="text" name="description" id="description" value="${product.description}"></td>
            </tr>
            <tr>
                <td>Producer: </td>
                <td><input type="text" name="producer" id="producer" value="${product.producer}"></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Remove Product"></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>

