<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<title>Student Management</title>
<meta charset="utf-8">
<meta name="viewport" 
	  content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet"
	  href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">
</head>
<body>
	<div class="container">
		<h3> Student Directory </h3>
		<a href="add" class="btn btn-primary btn-sm mb-3">Add Student</a>
	
		<!-- Table - structure changes -->
		<table class ="table table-bordered table-striped">
			<thead class ="thead-dark">
				<tr>
					<th>Name</th>
					<th>Department </th>
					<th>Country</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${studentModel}" var="student">
					<tr>
						<td><c:out value="${student.name}"></c:out></td>
						<td><c:out value="${student.department}"></c:out></td>
						<td><c:out value="${student.country}"></c:out></td>
						<td>
							<a href="update?id=${student.id}" class="btn btn-info btn-sm">Update</a>
							<a href="delete?id=${student.id}" class="btn btn-danger btn-sm" onclick="if(!(confirm('Are you sure to delete this student?'))) return false">Delete</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		
		</table>
	</div>
</body>
</html>