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
        <a href="/nhanvien">Danh sach nhan vien</a>
    </h2>
</center>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>Them moi nhan vien</h2>
            </caption>
            <tr>
                <th>Ten nhan vien:</th>
                <td>
                    <input type="text" name="hoTen" id="hoTen" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Ngay sinh nhan vien:</th>
                <td>
                    <input type="text" name="ngaySinh" id="ngaySinh" size="45"/>
                </td>
            </tr>
            <tr>
                <th>So CMND nhan vien:</th>
                <td>
                    <input type="text" name="soCMND" id="soCMND" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Luong nhan vien:</th>
                <td>
                    <input type="text" name="luong" id="luong" size="45"/>
                </td>
            </tr>
            <tr>
                <th>So dien thoai nhan vien:</th>
                <td>
                    <input type="text" name="sdt" id="sdt" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Email nhan vien:</th>
                <td>
                    <input type="text" name="email" id="email" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Dia chi nhan vien:</th>
                <td>
                    <input type="text" name="diaChi" id="diaChi" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Vi tri nhan vien:</th>
                <td>
                    <select name="viTri" id="viTri">
                        <option value="Nhan Vien">Nhan Vien</option>
                        <option value="Quan Ly">Quan Ly</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Create"/>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>