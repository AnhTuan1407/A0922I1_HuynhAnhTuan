<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 05/05/2023
  Time: 8:29 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Searching</title>
</head>
<body>
<div align="center">
  <table border="1" style="text-align: center">
    <tr>
      <th>Ma muon sach</th>
      <th>Ten sach</th>
      <th>Tac gia</th>
      <th>Ten hoc sinh</th>
      <th>Lop</th>
      <th>Ngay muon</th>
      <th>Ngay tra</th>
      <th></th>
    </tr>

    <c:forEach var="muonSach" items="${muonSach}">
      <tr>
        <td><c:out value="${muonSach.maMuonSach}"/></td>
        <td><c:out value="${muonSach.tenSach}"/></td>
        <td><c:out value="${muonSach.tacGia}"/></td>
        <td><c:out value="${muonSach.hoTen}"/></td>
        <td><c:out value="${muonSach.lop}"/></td>
        <td><c:out value="${muonSach.ngayMuon}"/></td>
        <td><c:out value="${muonSach.ngayTra}"/></td>
        <td><c:out value="${muonSach.ngayTra}"/></td>
      </tr>
    </c:forEach>
  </table>
</div>
</body>
</html>