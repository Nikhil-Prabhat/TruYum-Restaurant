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
<title>Edit Menu</title>


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

<script src="https://unpkg.com/gijgo@1.9.13/js/gijgo.min.js"
	type="text/javascript"></script>

<link href="https://unpkg.com/gijgo@1.9.13/css/gijgo.min.css"
	rel="stylesheet" type="text/css" />
<script src="https://unpkg.com/gijgo@1.9.13/js/gijgo.min.js"
	type="text/javascript"></script>

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
					href="show-menu-list-admin">Menu Items</a></li>
			</ul>
		</div>
	</nav>

	<div class="container myform">

		<h1 class="display-4 edithead">Edit Menu Item</h1>

		<form:form action="edit-menu-item" method="post"
			modelAttribute="menuitem" class="needs-validation"
			novalidate="novalidate">
			<div class="form-group">
				Item Name
				<form:input type="text" class="form-control" path="name"
					required="required" />
				<div class="invalid-feedback">
					<strong>Item name is required.</strong>
				</div>
			</div>


			<div class="form-row">


				<div class="form-group col-md-3">
					Price
					<form:input type="number" class="form-control" path="price"
						required="required" />
					<div class="invalid-feedback">
						<strong>Price is required.</strong>
					</div>
				</div>
				<div class="form-group col-md-3">
					Date of Launch
					<form:input type="text" class="form-control" path="dateOfLaunch"
						required="required" />

				</div>
				<script src="js/script.js"></script>
				<div class="invalid-feedback">
					<strong>Date of Launch is required.</strong>
				</div>

				<div class="form-group col-md-3">
					Category
					<form:select path="category" class="form-control"
						required="required">
						<form:options items="${categoryList }" />
					</form:select>

				</div>

				<div class="form-group col-md-3">
					<div class="form-check">

						Active<br>
						<form:radiobutton path="active" value="true" />
						Yes
						<form:radiobutton path="active" value="false" />
						No
					</div>
				</div>

				<div class="form-group">
					<div class="checkbox">
						<label><form:checkbox path="freeDelivery" /> Free
							Delivery</label>
					</div>
				</div>
			</div>

			<div class="form-group">
				<button type="submit" class="btn btn-success">Save</button>
			</div>
			<form:hidden path="id" />

		</form:form>

		<script src="js/validation.js"></script>




	</div>

	<!-- Footer -->
	<div class="container-fluid page-footer myfooter text-center">
		<h5>© 2019 Copyright</h5>
	</div>
</body>
</html>