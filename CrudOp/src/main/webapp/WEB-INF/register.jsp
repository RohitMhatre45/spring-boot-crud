<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration page</title>
</head>
<body>
<form action="/submitLaptopDetails" method="post">
    Enter the laptop Id: <input type="text" name="id"><br>
    Enter the laptop brand: <input type="text" name="brand"><br>
    Enter the laptop price: <input type="text" name="price"><br>
    <input type="submit" value="Submit">
</form>

</body>
</html>