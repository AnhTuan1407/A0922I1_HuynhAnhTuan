<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 05/05/2023
  Time: 7:35 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Book Management</title>
    <link rel="stylesheet" href="/static/css/bootstrap.css">

    <link rel="stylesheet" href="https://cdn.datatables.net/1.13.4/css/jquery.dataTables.min.css">
    <script src="https://code.jquery.com/jquery-3.5.1.js"></script>
    <script src="https://cdn.datatables.net/1.13.4/js/jquery.dataTables.min.js"></script>
</head>
<style>
    a {
        text-decoration: none;
    }
</style>
<body style="text-align: center">
<div align="center">
    <table border="1" style="text-align: center" class="table" id="tableProduct">
        <thead>
        <th>Ma sach</th>
        <th>Ten sach</th>
        <th>Tac gia</th>
        <th>So luong</th>
        <th>Mo ta</th>
        <th></th>
        </thead>
        <tbody>
        <c:forEach var="muonSach" items="${muonSach}">
            <tr>
                <td><c:out value="${muonSach.maSach}"/></td>
                <td><c:out value="${muonSach.tenSach}"/></td>
                <td><c:out value="${muonSach.tacGia}"/></td>
                <td><c:out value="${muonSach.soLuong}"/></td>
                <td><c:out value="${muonSach.moTa}"/></td>
                            <td>
                              <a href="/muonSach?action=create&id=${muonSach.maSach}">Muon</a>
                            </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <form method="get">
        <input type="text" name="action" value="list" hidden>
        <input type="submit" value="Thong ke sach da muon">
    </form>
</div>


<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>


<script>
    $(document).ready(function () {
        $('#tableProduct').DataTable({
            'pageLength': 2,
            pagingType: 'full_numbers',
            'searching': false
        });
    });
</script>
</body>
</html>