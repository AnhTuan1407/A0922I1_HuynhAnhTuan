<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
    <title>Update</title>
</head>
<body>
<form:form action="/update" method="post" modelAttribute="email">
    <table>
        <tr>
            <td><form:hidden path="id"/></td>
        </tr>
        <tr>
            <td>Languages</td>
            <td><form:select path="language" items="${languageList}"/></td>
        </tr>
        <tr>
            <td>Page size</td>
            <td>Show <form:select path="pageSize" items="${pageSizeList}"/>email per page</td>
        </tr>
        <tr>
            <td>spamFilter</td>
            <td><form:checkbox path="spams"/>Enable spams filter</td>
        </tr>
        <tr>
            <td>signature</td>
            <td><form:textarea path="signature"/></td>
        </tr>
        <tr>
            <td><form:button>Update</form:button></td>
            <td><form:button>Cancel</form:button></td>
        </tr>
    </table>
</form:form>

</body>
</html>