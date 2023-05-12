<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 25/04/2023
  Time: 10:28 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Employee Management Application</title>
</head>
<body>
<center>
    <h1>Employee Management</h1>
    <h2>
        <a href="/nhanvien?action=create">Them moi nhan vien</a>
    </h2>
</center>
<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>Danh sach nhan vien</h2></caption>
        <tr>
            <th>Ma Nhan Vien</th>
            <th>Ho Ten</th>
            <th>Ngay Sinh</th>
            <th>So CMND</th>
            <th>Luong</th>
            <th>So Dien Thoai</th>
            <th>Email</th>
            <th>Dia Chi</th>
            <th>Vi tri</th>
            <th>Action</th>
        </tr>
        <c:forEach var="nhanvien" items="${nhanvien}">
            <tr>
                <td><c:out value="${nhanvien.maNhanVien}"/></td>
                <td><c:out value="${nhanvien.hoTen}"/></td>
                <td><c:out value="${nhanvien.ngaySinh}"/></td>
                <td><c:out value="${nhanvien.soCMND}"/></td>
                <td><c:out value="${nhanvien.luong}"/></td>
                <td><c:out value="${nhanvien.sdt}"/></td>
                <td><c:out value="${nhanvien.email}"/></td>
                <td><c:out value="${nhanvien.diaChi}"/></td>
                <td><c:out value="${nhanvien.viTri}"/></td>
                <td>
                    <a href="/nhanvien?action=update&maNhanVien=${nhanvien.maNhanVien}">Edit</a>
                    <a href="/nhanvien?action=delete&maNhanVien=${nhanvien.maNhanVien}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>