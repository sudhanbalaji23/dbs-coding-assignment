<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>DBS Shopping Cart - Products</title>

<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"
	type="text/javascript"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/cart.js"></script>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/styles.css" />

</head>
<body>

	<div class="container">
		<div class="heading">
			<h1>
				<span class="shopper">DBS Shopping Cart</span>
			</h1>

			<a href="#" class="visibility-cart transition is-open">X</a>
		</div>

		<div class="cart transition is-open">

			<div class="table">
				<div class="layout-inline row th">
					<div class="col col-pro">Product</div>
					<div class="col col-qty align-center">Product Price(SGD)</div>
					<div class="col col-qty align-center">Select Product</div>
				</div>


				<c:forEach var="product" items="${listProducts}" varStatus="stat">

					<div class="layout-inline row">
						<div class="col col-pro layout-inline">
							<img
								src="${pageContext.request.contextPath}/images/${product.picUrl}"
								alt="${product.picUrl}" width="50" />
							<p>${product.productName}</p>
						</div>

						<div class="col col-price col-numeric align-center">
							<p>${product.productPrice}</p>
						</div>

						<div class="col col-numeric align-center">
							<p>
								<a
									href="${pageContext.request.contextPath}/subscribe/products/${product.productId}">Choose</a>
							</p>
						</div>
					</div>

				</c:forEach>
			</div>
		</div>
	</div>
</html>