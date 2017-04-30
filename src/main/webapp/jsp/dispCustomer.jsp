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
		<title>List of Customers</title>
	</head>
<body>
	<h1>List of Customers</h1>
	<c:forEach items="${customers}" var="customer">
		<h1>${customer.cId} ${customer.cName}</h1>
		<h2>${customer.cName}'s Order</h2>
		<table>
			<tr>
				<th>Order ID</th>
				<th>Quantity</th>
				<th>Product ID</th>
				<th>Description</th>
			</tr>
			<tr>
				<c:forEach items="${customer.orders}" var="custOrd">
					<tr>
						<td>${custOrd.oId}</td>
						<td>${custOrd.qty}</td>
						<td>${custOrd.prod.pId}</td>
						<td>${custOrd.prod.pDesc}</td>
					
				</c:forEach>	
			</tr>
		</table>
	</c:forEach>
	<a href="/">Home</a>
	<a href="/addCustomers">Add Customer</a>
	<a href="/showProducts">List Products</a>
	<a href="/showOrders">List Orders</a>
	<a href="/logout">Logout</a>
</body>
</html>