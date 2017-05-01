<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New Order</title>
</head>
<body>
	<form:form modelAttribute="ord">
		<h1>New Order</h1>
		<table>
			<tr>
				<td>Customer ID:</td>
				<td><form:input path="cust"></form:input></td>
			</tr>
			<tr>
				<td>Product ID:</td>
				<td><form:input path="prod"></form:input></td>
			</tr>
			<tr>
				<td>Quantity:</td>
				<td><form:input path="qty"></form:input></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Order" /></td>
			</tr>
		</table>
		<a href="/">Home</a>
		<a href="/showCustomers">List Customers</a>
		<a href="/showProducts">List Product</a>
	</form:form>
</body>
</html>