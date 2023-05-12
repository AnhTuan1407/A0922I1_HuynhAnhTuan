<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 28/04/2023
  Time: 5:26 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create new product</title>
</head>
<body>
<div align="center">
  <form method="post">
    <table border="1" cellpadding="5">
<caption>
    <h2>Create new product</h2>
</caption>
        <tr>
            <th>Name: </th>
            <td><input type="text" name="name" size="45"></td>
        </tr>
        <tr>
            <th>Price: </th>
            <td><input type="text" name="price" size="45"></td>
        </tr>
        <tr>
            <th>Amount: </th>
            <td><input type="text" name="amount" size="45"></td>
        </tr>
        <tr>
            <th>Color: </th>
            <td><input type="text" name="color" size="45"></td>
        </tr>
        <tr>
            <th>Description: </th>
            <td><input type="text" name="description" size="45"></td>
        </tr>
        <tr>
            <th>Category: </th>
            <td><input type="text" name="category" size="45"></td>
        </tr>
    </table>
      <input type="submit" value="Create">
  </form>
</div>
</body>
</html>
