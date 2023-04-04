<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<link href="<c:url value="/resources/css/bootstrap.min.css" />"
	rel="stylesheet">
<script src="<c:url value="/resources/js/jquery-3.6.4.min.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
		<div class="container-fluid">
			<ul class="navbar-nav">
				<li class="nav-item"><a class="nav-link active"
					href="product/list">All product</a></li>
				<li class="nav-item"><a class="nav-link" href="product/add">Add
						new product</a></li>
				<li class="nav-item"><a class="nav-link" href="category/list">All
						Category</a></li>
				<li class="nav-item"><a class="nav-link" href="category/add">Add
						new Category</a></li>
				<li class="nav-item"><a class="nav-link" href="login">Login</a></li>
				<li class="nav-item"><a class="nav-link" href="welcome">Welcome</a></li>
				<li class="nav-item"><a class="nav-link" href="profile">Profile</a></li>
				<li class="nav-item"><a class="nav-link"
					href="redirect/no-param">redirect no param</a></li>
				<li class="nav-item"><a class="nav-link" href="redirect/param">redirect
						has param</a></li>
			</ul>
		</div>
	</nav>
</body>
</html>
