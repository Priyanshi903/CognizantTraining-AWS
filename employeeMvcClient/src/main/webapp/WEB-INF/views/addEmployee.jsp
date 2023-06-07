<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="added" modelAttribute="employee">
		<table>
			<tr>
				<td>Employee Id</td>
				<td><input type="text" name="id"></td>
			</tr>
			<tr>
				<td>Employee Name</td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td>Gender</td>
				<td><input type="text" name="gender"></td>
			</tr>
			<tr>
				<td>Age</td>
				<td><input type="text" name="age"></td>
			</tr>
			<tr>
				<td>Salary</td>
				<td><input type="text" name="salary"></td>
			</tr>
			<tr>
				<td><input type="submit" value="Add Employee"></td>

			</tr>
		</table>
	</form>

</body>
</html>