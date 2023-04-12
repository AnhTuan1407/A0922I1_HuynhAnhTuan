<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Currency Converter</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<h1>
    <%= "Currency Converter" %>
</h1>
<br/>
<form method="post" action="convert.jsp">
    <label for="rate">Rate: </label><br>
    <input type="text" name="rate" id="rate" placeholder="RATE" value="22000"><br>
    <label for="usd">USD: </label><br>
    <input type="text" name="usd" id="usd" placeholder="USD" value="0"><br>
    <input type="submit" id="submit" value="Converter">
</form>
</body>
</html>