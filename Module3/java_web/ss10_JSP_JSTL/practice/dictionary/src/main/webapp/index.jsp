<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Dictionary Servlet</title>
</head>
<body>
<h1><%= "Vietnamese Dictionary" %>
</h1>
<br/>
<form action="dictionary.jsp" method="post">
    <input type="text" placeholder="Enter your word: " name="search">
    <br>
    <input type="submit" value="Search" id="submit">
</form>
</body>
</html>