<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Calculator</title>
</head>
<body>
<h1><%= "Simple Calculator!" %>
</h1>
<br/>
<form action="/calculator" method="post" style="border: 1px solid black">
    <table>
        <tr>
            <td>
                <label>First operand</label>
                <input type="text" name="firstOperand"><br>
            </td>
        </tr>

        <tr>
            <td>
                <label>Operation</label>
                <select name="operation" id="operation">
                    <option value="addition">Addition</option>
                    <option value="subtraction">Subtraction</option>
                    <option value="multiplication">Multiplication</option>
                    <option value="division">Division</option>
                </select><br>
            </td>
        </tr>


        <tr>
            <td>
                <label>Seconde operand</label>
                <input type="text" name="secondOperand">
            </td>
        </tr>

        <tr>
            <td>
                <input type="submit" value="Result">
            </td>
        </tr>
    </table>
</form>
</body>
</html>