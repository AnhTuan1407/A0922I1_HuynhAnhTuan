<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Product Servlet</title>
</head>
<body>
<h1>
    <%= "Product Servlet" %>
</h1>
<br/>
<form method="post" action="/products">
    <label>Product Description: </label><br>
    <textarea name="product-description" id="product-description" cols="30" rows="10"></textarea><br>
    <lable>List Price: </lable><br>
    <input type="text" name="price" id="price" placeholder="Giá niêm yết"><br>
    <lable>Discount Percent: </lable><br>
    <input type="text" name="discount-percent" id="discount-percent" placeholder="Tỉ lệ chiết khấu"><br>
    <input type = "submit" id = "submit" value = "Submit"/>
</form>
</body>
</html>