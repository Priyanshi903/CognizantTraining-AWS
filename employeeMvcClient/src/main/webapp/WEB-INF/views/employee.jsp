<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee</title>
</head>
<body>
	<form action="addEmployee">
		<table>
			<tr>
				<td><input type="submit" value="Add Employee"></td>

			</tr>
		</table>
	</form>
	<h1>Employee Details</h1>
	<table border="1">
		<tr>
			<th>Employee ID</th>
			<th>Employee Name</th>
			<th>Gender</th>
			<th>Age</th>
			<th>Salary</th>
			<th>Action</th>
		</tr>
		<c:forEach items="${employees }" var="e">
			<tr>
				<td>${e.id}</td>
				<td>${e.name }</td>
				<td>${e.gender}</td>
				<td>${e.age}</td>
				<td>${e.salary}</td>
				<td>
					<a href="${e.id}">Delete</a>
					<a href="/update?id=${e.id}">Update</a>
				</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>