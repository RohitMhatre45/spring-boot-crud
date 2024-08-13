<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Update Laptop</title>
</head>
<body>

<h2>Update Laptop</h2>

<form action="updateLaptop" method="post">
    <input type="hidden" name="id" value="${laptop.id}" />

    <div>
        <label for="brand">Brand:</label>
        <input type="text" id="brand" name="brand" value="${laptop.brand}" required />
    </div>
    <div>
        <label for="price">Price:</label>
        <input type="text" id="price" name="price" value="${laptop.price}" required />
    </div>

    <div>
        <button type="submit">Update</button>
        <a href="allLaptops">Cancel</a>
    </div>
</form>

</body>
</html>
