<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>DBS Shopping Cart</title>

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

			<a href="${pageContext.request.contextPath }/subscribe/products"
				class="btn btn-update">Continue Shopping</a>

			<div class="table">
				<div class="layout-inline row th">
					<div class="col col-pro">Product</div>
					<div class="col col-qty align-center">Price(SGD)</div>
					<div class="col">Quantity</div>
					<div class="col">Sub Total</div>
				</div>


				<c:set var="total" value="0"></c:set>
				<c:forEach var="item" items="${sessionScope.item }">
					<c:set var="total"
						value="${total + item.product.productPrice * item.productQuantity }"></c:set>

					<div class="layout-inline row">
						<div class="col col-pro layout-inline">
							<img
								src="${pageContext.request.contextPath}/images/${item.product.picUrl}"
								alt="${product.picUrl}" width="50" />
							<p>${item.product.productName}</p>
						</div>

						<div class="col col-price col-numeric align-center ">
							<p>${item.product.productPrice}</p>
						</div>

						<div class="col col-vat col-numeric">
							<p>${item.productQuantity}</p>
						</div>

						<div class="col col-vat col-numeric">
							<p>${item.product.productPrice * item.productQuantity }</p>
						</div>
						<div class="col col-vat col-numeric">
							<p>
								<a
									href="${pageContext.request.contextPath }/subscribe/removeProduct/${item.product.productId }"
									onclick="return confirm('Are you sure?')">Remove</a>
							</p>
						</div>
					</div>
				</c:forEach>

				<div class="tf">
					<div class="row layout-inline">
						<div class="col">
							<p>Sum</p>
						</div>
						<div class="col">${total}</div>
					</div>
				</div>
			</div>
			<a href="${pageContext.request.contextPath }/subscribe/products"
				class="btn btn-update">Continue Shopping</a>
		</div>
	</div>
</html>