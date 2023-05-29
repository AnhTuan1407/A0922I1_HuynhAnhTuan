<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 28/05/2023
  Time: 12:18 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Email Setting</title>
</head>
<body>
<h1>Setting</h1>
<table>
<tr>
    <th>ID</th>
    <th>Language</th>
    <th>PageSize</th>
    <th>Spams filter</th>
    <th>Signature</th>
    <th>Action</th>
</tr>
    <c:forEach items="${email}" var="e">
        <tr>
            <td>${e.id}</td>
            <td>${e.language}</td>
            <td>${e.pageSize}</td>
            <td>${e.spams}</td>
            <td>${e.signature}</td>
            <td><a href="/update?id=${e.id}">Update</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
