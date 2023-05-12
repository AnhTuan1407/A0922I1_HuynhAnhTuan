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
                <h2>
                    Cap nhat thong tin nhan vien
                </h2>
            </caption>
            <c:if test="${nhanVien != null}">
                <input type="hidden" name="maNhanVien" value="<c:out value='${nhanVien.maNhanVien}' />"/>
            </c:if>
            <tr>
                <th>Ten nhan vien:</th>
                <td>
                    <input type="text" name="hoTen" size="45"
                           value="<c:out value='${nhanVien.hoTen}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Ngay sinh nhan vien:</th>
                <td>
                    <input type="text" name="ngaySinh" size="45"
                           value="<c:out value='${nhanVien.ngaySinh}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>So CMND nhan vien:</th>
                <td>
                    <input type="text" name="soCMND" size="45"
                           value="<c:out value='${nhanVien.soCMND}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Luong nhan vien:</th>
                <td>
                    <input type="text" name="luong" size="45"
                           value="<c:out value='${nhanVien.luong}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>So dien thoai:</th>
                <td>
                    <input type="text" name="sdt" size="45"
                           value="<c:out value='${nhanVien.sdt}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Email nhan vien:</th>
                <td>
                    <input type="text" name="email" size="45"
                           value="<c:out value='${nhanVien.email}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Dia chi nhan vien:</th>
                <td>
                    <input type="text" name="diaChi" size="45"
                           value="<c:out value='${nhanVien.diaChi}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Vi tri nhan vien:</th>
                <td>
                    <input type="text" name="viTri" size="45"
                           value="<c:out value='${nhanVien.viTri}' />"
                    />
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save"/>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>