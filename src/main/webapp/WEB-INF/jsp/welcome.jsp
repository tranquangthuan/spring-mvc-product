<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Product</title>
</head>
<body>
	<div align="center">
		<h1>Welcome page</h1>
		<a href="${pageContext.request.contextPath}">Home</a> <br /> 
		Hello ${user.userName }, ${user.password}
	</div>
</body>
</html>