<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 08/05/2023
  Time: 6:51 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update</title>
</head>
<body>
<div align="center">
    <h2>Update</h2>
    <form method="post">
        <table border="1">
            <tr readonly="">
                <th>Ma benh an: </th>
                <td>
                    <input readonly name="maBenhAn" size="45"
                           value="<c:out value='${benhAn.maBenhAn}' />"
                    />
                </td>
            </tr>
            <tr readonly="">
                <th>Ma benh nhan: </th>
                <td>
                    <input readonly name="maBenhNhan" size="45"
                           value="<c:out value='${benhAn.maBenhNhan}' />"
                    />
                </td>
            </tr>
            <tr >
                <th>Ten benh nhan: </th>
                <td>
                    <input type="read" name="tenBenhNhan" size="45"
                           value="<c:out value='${benhAn.tenBenhNhan}' />"
                    />
                </td>
            </tr>
            <tr >
                <th>Ngay nhap vien: </th>
                <td>
                    <input type="text" name="ngayNhapVien" size="45"
                           value="<c:out value='${benhAn.ngayNhapVien}' />"
                    />
                </td>
            </tr>
            <tr >
                <th>Ngay ra vien: </th>
                <td>
                    <input type="text" name="ngayRaVien" size="45"
                           value="<c:out value='${benhAn.ngayRaVien}' />"
                    />
                </td>
            </tr>
            <tr >
                <th>Ly do nhap vien: </th>
                <td>
                    <input type="text" name="lyDo" size="45"
                           value="<c:out value='${benhAn.lyDo}' />"
                    />
                </td>
            </tr>
        </table>
        <br>
        <br>
        <input type="submit" value="UPDATE">
        <button><a href="/benhAn">Tro ve danh sach</a></button>
    </form>
</div>
</body>
</html>