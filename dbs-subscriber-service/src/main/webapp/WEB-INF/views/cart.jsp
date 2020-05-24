<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>DBS Shopping Cart</title>
</head>
<body>

	<h3>Cart</h3>
	<table cellpadding="2" cellspacing="2" border="1">
		<tr>
			<th>Remove</th>
			<th>Product Id</th>
			<th>Product Name</th>
			<th></th>
			<th>Product Price</th>
			<th>Product Quantity</th>
			<th>Sub Total</th>
		</tr>
		<c:set var="total" value="0"></c:set>
		<c:forEach var="item" items="${sessionScope.item }">
			<c:set var="total" value="${total + item.product.productPrice * item.productQuantity }"></c:set>
			<tr>
				<td align="center"><a
					href="${pageContext.request.contextPath }/subscribe/removeProduct/${item.product.productId }"
					onclick="return confirm('Are you sure?')">Remove</a></td>
				<td>${item.product.productId }</td>
				<td>${item.product.productName }</td>
				<td><img src="${pageContext.request.contextPath }/images/${item.product.picUrl }" width="50"></td>
				<td>${item.product.productPrice }</td>
				<td>${item.productQuantity }</td>
				<td>${item.product.productPrice * item.productQuantity }</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="6" align="right">Sum</td>
			<td>${total}</td>
		</tr>
	</table>
	<br>
	<a href="${pageContext.request.contextPath }/subscribe/products">Continue Shopping</a>

</body>
</html>
