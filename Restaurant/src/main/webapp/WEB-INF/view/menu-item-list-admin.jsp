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
<title>Menu Item List Admin</title>

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
					href="show-menu-list-admin">Menu Items</a></li>
			</ul>
		</div>
	</nav>

	<!--  Jumbotron Part -->

	<div class="jumbotron">
		<h1 class="display-4">Find Food</h1>
		<form>
			<div class="input-group mb-3">
				<div class="input-group-prepend">
					<span class="input-group-text"><i
						class="material-icons md-48">free_breakfast</i></span>
				</div>
				<input type="text" class="form-control" placeholder="Search food" id="myinput"
					onkeyup="searchFunction()">
			</div>
		</form>
	</div>



	<!--  Adding food items -->
	<div class="row">
		<c:forEach items="${adminlist }" var="menulist">

			<div class="col-sm-3">
				<div class="card m-2">
					<img class="card-img-top" src=${menulist.pic } alt="Card image cap">
					<div class="card-body">

						<div class="card-title">${menulist.name }</div>
						<div class="myright text-danger">&#8377;${menulist.price }</div>

					</div>
					<div class="card-body">
						<div class="myleft">
							<c:choose>
								<c:when test="${menulist.active }">
									<span class="badge badge-success">Active</span> ${menulist.category }
							</c:when>
								<c:otherwise>
									<span class="badge badge-danger">Inactive</span> ${menulist.category } </c:otherwise>
							</c:choose>
						</div>
						<div class="myright">
							<c:choose>
								<c:when test="${menulist.freeDelivery }">
									<i class="material-icons md-36 shipping">local_shipping</i>
									<span class="badge badge-pill badge-info">free</span>
								</c:when>
								<c:otherwise></c:otherwise>

							</c:choose>
						</div>

					</div>

					<div class="card-footer">

						<div class="myleft dateoflaunch">
							<i class="material-icons md-18">query_builder</i> Launch <br>
							${menulist.dateOfLaunch}
						</div>

						<button type="button" class="btn btn-danger footerbutton"
							onClick="location.href='show-edit-menu-item?id=${menulist.id }'">
							<i class="material-icons ">create</i>Edit
						</button>
					</div>
				</div>
			</div>

		</c:forEach>
	</div>
	
	<script src="js/search.js"></script>

	<!-- Footer -->
	<div class="page-footer myfooter text-center">
		<h5>© 2019 Copyright</h5>
	</div>
</body>
</html>