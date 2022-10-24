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
		<a href="${pageContext.request.contextPath}">Home</a>
		<form:form action="${pageContext.request.contextPath}/category/save"
			method="post" modelAttribute="categoryForm">
			<table>
				<tr>
					<td><form:label path="name">Name</form:label></td>
					<td><form:input path="name" /></td>
					<td><form:errors path="name" /></td>
				</tr>
				<tr>
					<td></td>
					<td><form:button value="Add">Add</form:button></td>
				</tr>
				<form:hidden path="id" />
			</table>
		</form:form>
	</div>
</body>
</html>