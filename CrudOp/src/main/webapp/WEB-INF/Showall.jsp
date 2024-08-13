<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>All Laptops</title>
</head>
<body>

<h2>Laptop List</h2>

<table border="1" cellpadding="5" cellspacing="0">
    <thead>
        <tr>
            <th>ID</th>
            <th>Brand</th>
            <th>Price</th>
            <th>Actions</th>
        </tr>
    </thead>
    <tbody>
        <!-- Check if the list is empty or null -->
        <c:if test="${empty laptops}">
            <tr>
                <td colspan="4">No laptops available</td>
            </tr>
        </c:if>
        <!-- Iterate over the laptops list -->
        <c:forEach var="laptop" items="${laptops}">
            <tr>
                <td>${laptop.id}</td>
                <td>${laptop.brand}</td>
                <td>${laptop.price}</td>
                <td>
                    <a href="updateLaptop?id=${laptop.id}">Update</a>
                    <a href="deleteLaptop?id=${laptop.id}" onclick="return confirm('Are you sure you want to delete this item?');">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>

</body>
</html>
