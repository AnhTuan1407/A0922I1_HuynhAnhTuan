<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sandwich Condiments</title>
</head>
<body>
<h1>Sandwich Condiments</h1>
<form action="/sandwich">
    <input type="checkbox" name="condiment" value="Lettuce"> <label>Lettuce</label>
    <input type="checkbox" name="condiment" value="Tomato"> <label>Tomato</label>
    <input type="checkbox" name="condiment" value="Mustard"> <label>Mustard</label>
    <input type="checkbox" name="condiment" value="Sprouts"> <label>Sprouts</label>
    <hr>
    <input type="submit" value="save">
</form>
<h1>${condiments}</h1>
</body>
</html>