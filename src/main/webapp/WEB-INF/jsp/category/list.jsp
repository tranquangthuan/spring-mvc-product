<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<style>
.pagination {
	display: inline-block;
}

.pagination a {
	color: black;
	float: left;
	padding: 8px 16px;
	text-decoration: none;
	transition: background-color .3s;
	border: 1px solid #ddd;
	margin: 0 4px;
}

.pagination a.active {
	background-color: #4CAF50;
	color: white;
	border: 1px solid #4CAF50;
}

.pagination a:hover:not(.active) {
	background-color: #ddd;
}

table, td, th {
	border: 1px solid black;
}

table {
	border-collapse: collapse;
	width: 50%;
}

td {
	text-align: center;
}
</style>
<meta charset="ISO-8859-1">
<title>Product List</title>
</head>
<body>

	<div align="center">
		<a href="add">Add new Category</a>
		<a href="${pageContext.request.contextPath}">Home</a>
		<table>
			<thead>
				<tr>
					<th width="30%">Id</th>
					<th width="35%">Name</th>
					<th width="35%">Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="c" items="${categories}" varStatus="status">
					<tr>
						<td>${c.id}</td>
						<td>${c.name}</td>
						<td><a href="delete?id=${c.id}">Delete</a> <a
							href="update/${c.id}">Update</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<br />

		<div class="pagination">
			<c:if test="${currentPage > 1}">
				<a href="list?page=${currentPage-1}">Previous</a>
			</c:if>
			<c:forEach begin="1" end="${totalPages}" var="i">
				<c:choose>
					<c:when test="${currentPage eq i}">
						<a class="active"> ${i} </a>
					</c:when>
					<c:otherwise>
						<a href="list?page=${i}">${i}</a>
					</c:otherwise>
				</c:choose>
			</c:forEach>

			<c:if test="${currentPage lt totalPages}">
				<a href="list?page=${currentPage+1}">Next</a>
			</c:if>
		</div>
	</div>
</body>
</html>