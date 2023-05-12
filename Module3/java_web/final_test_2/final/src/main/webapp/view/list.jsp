<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 08/05/2023
  Time: 6:51 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Hospital Management</title>
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
<h1>DANH SACH BENH AN</h1>
<div align="center">
    <table border="1" style="text-align: center" class="table" id="tableBenhNhan">
        <thead>
        <th>Ma benh an</th>
        <th>Ma benh nhan</th>
        <th>Ten benh nhan</th>
        <th>Ngay nhap vien</th>
        <th>Ngay ra vien</th>
        <th>Ly do nhap vien</th>
        <th>Tac vu</th>
        </thead>
        <tbody>
        <c:forEach var="benhAn" items="${benhAn}">
            <tr>
                <td><c:out value="${benhAn.maBenhAn}"/></td>
                <td><c:out value="${benhAn.maBenhNhan}"/></td>
                <td><c:out value="${benhAn.tenBenhNhan}"/></td>
                <td><c:out value="${benhAn.ngayNhapVien}"/></td>
                <td><c:out value="${benhAn.ngayRaVien}"/></td>
                <td><c:out value="${benhAn.lyDo}"/></td>
                <td>
                    <a class="btn btn-primary" href="/benhAn?action=update&maBenhAn=${benhAn.maBenhAn}">Edit</a>
                    <a>|</a>
                    <button
                            onclick="showModelDelete('${benhAn.maBenhAn}')"
                            type="button" class="btn btn-danger" data-toggle="modal" data-target="#modelDelete">Delete
                    </button>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>


<!-- Modal -->
<div class="modal fade" id="modelDelete" tabindex="-1" role="dialog" aria-labelledby="modelTitleId" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Bạn có chắc chắn xóa không :</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <p>Ban muon xoa thong tin benh an : <span id="maBenhAn1" style="color: red"></span> hay khong?</p>
            </div>
            <form action="/benhAn" method="get">
                <input type="hidden" name="action" value="delete">
                <input type="hidden" name="maBenhAn" value="" id="maBenhAn">
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                    <button type="submit" class="btn btn-danger">Delete</button>
                </div>
            </form>
        </div>
    </div>
</div>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>

<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>


<script>
    $(document).ready(function () {
        $('#tableBenhNhan').DataTable({
            'pageLength': 2,
            pagingType: 'full_numbers',
            'searching': false
        });
    });

    function showModelDelete(maBenhAn) {
        console.log(maBenhAn);
        document.getElementById("maBenhAn").innerText = maBenhAn;
        document.getElementById("maBenhAn1").innerText = maBenhAn;
        document.getElementById("maBenhAn").value = maBenhAn;
        document.getElementById("maBenhAn1").value = maBenhAn;
    }
</script>
</body>
</html>
