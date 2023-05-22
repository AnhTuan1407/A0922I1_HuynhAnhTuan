<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dictionary</title>
</head>
<body>
<form action="/dictionary">
    <label for="word">Enter word you want to translate</label>
    <input type="text" name="word" id="word">
    <input type="submit" value="Translate">
</form>
<h1>${translate}</h1>
</body>
</html>