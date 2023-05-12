<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 05/05/2023
  Time: 7:19 CH
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
    <th>Ma muon sach</th>
    <th>Ten sach</th>
    <th>Tac gia</th>
    <th>Ten hoc sinh</th>
    <th>Lop</th>
    <th>Ngay muon</th>
    <th>Ngay tra</th>
    <th></th>
    </thead>
    <tbody>
    <c:forEach var="muonSach" items="${muonSach}">
      <tr>
        <td><c:out value="${muonSach.maMuonSach}"/></td>
        <td><c:out value="${muonSach.tenSach}"/></td>
        <td><c:out value="${muonSach.tacGia}"/></td>
        <td><c:out value="${muonSach.hoTen}"/></td>
        <td><c:out value="${muonSach.lop}"/></td>
        <td><c:out value="${muonSach.ngayMuon}"/></td>
        <td><c:out value="${muonSach.ngayTra}"/></td>
        <td><c:out value="${muonSach.trangThai}"/></td>
<%--        <td>--%>
<%--          <a href="/products?action=update&id=${product.id}">Edit</a>--%>
<%--          <a>|</a>--%>
<%--          <a href="/products?action=delete&id=${product.id}">Delete</a>--%>
<%--        </td>--%>
      </tr>
    </c:forEach>
    </tbody>
  </table>

  <h2>
    <a href="/muonSach?action=searchNameBook">Search By Name Book</a>
  </h2>
  <br>
  <h2>
    <a href="/muonSach?action=searchNameStudent">Search By Name Student</a>
  </h2>
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