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
		<form:form action="${pageContext.request.contextPath}/login"
			method="post" modelAttribute="user">
			<table>
				<tr>
					<td><form:label path="userName">userName</form:label></td>
					<td><form:input path="userName" /></td>
					<td><form:errors path="userName" /></td>
				</tr>
				<tr>
					<td><form:label path="password">Password</form:label></td>
					<td><form:input path="password" /></td>
					<td><form:errors path="password" /></td>
				</tr>
				<tr>
					<td></td>
					<td><form:button value="Add">Add</form:button></td>
				</tr>
			</table>
		</form:form>
	</div>
</body>
</html>