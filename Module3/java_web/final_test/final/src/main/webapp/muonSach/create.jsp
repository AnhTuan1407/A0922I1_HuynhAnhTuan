<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 05/05/2023
  Time: 7:58 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create</title>
</head>
<body>
<div align="center">
    <h1>Muon Sach</h1>
    <form method="post">
        <table border="1" cellpadding="5">
            <tr>
                <th>Ma muon sach: </th>
                <td><input type="text" name="maMuonSach" size="45"></td>
            </tr>
            <tr>
                <th>Ten sach: </th>
                <td><input type="text" name="tenSach" size="45" <c:out value="${muonSach.tenSach}"/>></td>
            </tr>
            <tr>
                <th>Ten hoc sinh: </th>
                <td><input type="text" name="tenHocSinh" size="45"></td>
            </tr>
            <tr>
                <th>Ngay muon sach: </th>
                <td><input type="text" name="ngayMuon" size="45"></td>
            </tr>
            <tr>
                <th>Ngay tra sach: </th>
                <td><input type="text" name="ngayTra" size="45"></td>
            </tr>
        </table>
        <input type="submit" value="Muon Sach">
    </form>
</div>
</body>
</html>
