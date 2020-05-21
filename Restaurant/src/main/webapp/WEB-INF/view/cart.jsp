<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1" name="viewport"
	content="width=device-width, initial-scale=1">
<title>Cart</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">

<link href="css/custom.css" rel="stylesheet" />
</head>
<body>
	<!-- Navbar -->
	<nav class="navbar navbar-expand-md  navbar-dark">
		<a class="navbar-brand" href="getIndexPage"> <i class="material-icons md-48">local_dining</i>
			truYum
		</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#collapsibleNavbar">

			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="collapsibleNavbar">
			<ul class="navbar-nav ml-auto">
				<li class="nav-item"><a class="nav-link"
					href="show-menu-list-customer?username=${userid}">Menu Items</a></li>
				<li class="nav-item"><a class="nav-link"
					href="show-cart?custid=${userid }">Cart</a></li>
			</ul>
		</div>
	</nav>

	<div class="container">
		<h1 class="display-4 edithead mt-5">Cart</h1>
	</div>

	<c:if test="${removecartstatus }">
		<div class="container">
			<div class="card itemstatus">
				<div class="card-body">
					<strong> Cart Item deleted successfully</strong>
				</div>
			</div>
		</div>
	</c:if>


	<div class="container mt-5 mycart">
		<ul class="list-group">
			<c:forEach items="${cartitems.menuItemList }" var="menulist">
				<li class="list-group-item">
					<div class="card-title">${menulist.name }</div>
					<div class="myright text-danger">&#8377;${menulist.price }</</div>
					<br> <a class="myright" href="remove-cart?menuid=${menulist.id }&userid=${userid}"> <i
						class="material-icons md-36 carddelete">delete_forever</i>
				</a>
				</li>
			</c:forEach>

			<li class="list-group-item">
				<div>
					<h4>Total</h4>
				</div>
				<div class="myright text-danger">&#8377;${cartitems.total }</</div>


			</li>

		</ul>
	</div>

	<!-- Footer -->
	<div class=" container-fluid page-footer myfooter text-center">
		<h5>© 2019 Copyright</h5>
	</div>

</body>
</html>