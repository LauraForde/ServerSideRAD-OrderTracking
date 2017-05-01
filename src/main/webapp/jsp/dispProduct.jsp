<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
	<head>
		<style>
			table, th, td {
				border: 2px solid black;
			}
		</style>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>List of Products</title>
		</head>
	<body>
	<h1>List of Products</h1>
	<table>
		<tr>
			<th>Product ID</th>
			<th>Description</th>
			<th>Quantity in Stock</th>
		</tr>
		<tr>
			<c:forEach items="${products}" var="product">
				<tr>
					<td>${product.pId}</td>
					<td>${product.pDesc}</td>
					<td>${product.qtyInStock}</td>
				</tr>
			</c:forEach>
		</tr>
	</table>
	<a href="/">Home</a>
	<a href="/addProduct">Add Product</a>
	<a href="/showCustomers">List Customers</a>
	<a href="/showOrders">List Orders</a>
</body>
</html>