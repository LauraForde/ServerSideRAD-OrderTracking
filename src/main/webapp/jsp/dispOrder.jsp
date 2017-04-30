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
		<title>List of Orders</title>
		</head>
	<body>
	<table>
		<tr>
			<th>Quantity</th>
			<th>Order Date</th>
			<th>Customer ID</th>
			<th>Customer Name</th>
			<th>Product ID</th>
			<th>Description</th>
		</tr>
		<tr>
			<c:forEach items="${orders}" var="order">
				<tr>
					
				</tr>
			</c:forEach>
		</tr>
	</table>
	<a href="/">Home</a>
	<a href="/addOrder">Add Order</a>
	<a href="/showProducts">List Products</a>
	<a href="/showCustomers">List Customers</a>
	<a href="/logout">Logout</a>
</body>
</html>