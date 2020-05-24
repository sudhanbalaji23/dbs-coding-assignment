<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>DBS Products</title>

<script type="text/javascript"  src="webjars/jquery/2.2.4/jquery.min.js"></script>

</head>
<body>

	<h3>DBS Products</h3>
	
	<table cellpadding="2" cellspacing="2" border="1">
		<tr>
			<th>Product Id</th>
			<th>Product Name</th>
			<th></th>
			<th>Product Price(SGD)</th>
			<th>Select Product</th>
		</tr>
		<c:forEach var="product" items="${listProducts}" varStatus="stat">
			<tr>
				<td>${product.productId }</td>
				<td>${product.productName }</td>
				<td><img src="${pageContext.request.contextPath}/images/${product.picUrl}" width="50"></td>
				<td>${product.productPrice }</td>
				<td align="center">
					<a href="${pageContext.request.contextPath}/subscribe/products/${product.productId}">Choose</a>
				</td>			
			</tr>	
		</c:forEach>
		
	</table>

</body>
</html>