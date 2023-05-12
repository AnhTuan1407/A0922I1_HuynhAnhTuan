<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 12/04/2023
  Time: 12:56 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Edit customer</title>
</head>
<body>
<h1>Delete customer</h1>
<p>
  <a href="/customers">Back to customer list</a>
</p>
<form method="post" action="/customers?action=delete">
  <fieldset>
    <legend>Delete Customer</legend>
    <table>
      <tr>
        <td>ID: </td>
        <td><input type="text" name="id" id="id"></td>
      </tr>

      <tr>
        <td></td>
        <td><input type="submit" value="Delete customer"></td>
      </tr>

    </table>
  </fieldset>
</form>
</body>
</html>
