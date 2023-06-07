<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="updated" modelAttribute="employee">
		<table>
			<tr>
				<td>Employee Id</td>
				<td><input type="text" name="id" value="${employee.id }" readonly="true"></td>
			</tr>
			<tr>
				<td>Employee Name</td>
				<td><input type="text" name="name" value="${employee.name}"></td>
			</tr>
			<tr>
				<td>Gender</td>
				<td><input type="text" name="gender" value="${ employee.gender}"></td>
			</tr>
			<tr>
				<td>Age</td>
				<td><input type="text" name="age" value="${employee.age }"></td>
			</tr>
			<tr>
				<td>Salary</td>
				<td><input type="text" name="salary" value="${ employee.salary}"></td>
			</tr>
			<tr>
				<td><input type="submit" value="Update Employee"></td>

			</tr>
		</table>
	</form>

</body>
</html>