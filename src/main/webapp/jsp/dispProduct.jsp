View
<h1>List of Products</h1>
<table>
	<tr>
		<th>Product ID</th>
		<th>Description</th>
		<th>Quantity in Stock</th>
	</tr>
	<tr>
		<c:forEach pro="${products}" var="product">
			<tr>
				<td>${product.pid}</td>
				<td>${product.pdesc}</td>
				<td>${product.qtyinstock}</td>
			</tr>
		</c:forEach>
	</tr>
</table>