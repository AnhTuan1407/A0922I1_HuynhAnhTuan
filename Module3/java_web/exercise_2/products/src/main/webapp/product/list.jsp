<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 28/04/2023
  Time: 1:15 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Product Management</title>
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
<h1>List Products</h1>
<div align="center">
    <table border="1" style="text-align: center" class="table" id="tableProduct">
        <thead>
        <th>ID</th>
        <th>Name</th>
        <th>Price</th>
        <th>Amount</th>
        <th>Color</th>
        <th>Description</th>
        <th>Category</th>
        <th>Action</th>
        </thead>
        <tbody>
        <c:forEach var="product" items="${product}">
            <tr>
                <td><c:out value="${product.id}"/></td>
                <td><c:out value="${product.name}"/></td>
                <td><c:out value="${product.price}"/></td>
                <td><c:out value="${product.amount}"/></td>
                <td><c:out value="${product.color}"/></td>
                <td><c:out value="${product.description}"/></td>
                <td><c:out value="${product.category}"/></td>
                <td>
                    <a class="btn btn-primary" href="/products?action=update&id=${product.id}">Edit</a>
                    <a>|</a>
                        <%--<a href="/products?action=delete&id=${product.id}">Delete</a>--%>
                    <button
                            onclick="showModelDelete('${product.id}','${product.name}')"
                            type="button" class="btn btn-danger" data-toggle="modal" data-target="#modelDelete">Delete
                    </button>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <h2>
        <a href="/products?action=create">Create new product</a>
    </h2>
    <br>
    <h2>
        <a href="/products?action=search">Search</a>
    </h2>
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
                <p>Ban muon xoa: <span id="productName" style="color: red"></span> ?</p>
            </div>
            <form action="/products" method="get">
                <input type="hidden" name="action" value="delete">
                <input type="hidden" name="id" value="" id="productId">
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
        $('#tableProduct').DataTable({
            'pageLength': 2,
            pagingType: 'full_numbers',
            'searching': false
        });
    });

    function showModelDelete(id, name) {
        console.log(id, name);
        document.getElementById("productName").innerText = name;
        document.getElementById("productId").value = id;
    }
</script>
</body>
</html>
