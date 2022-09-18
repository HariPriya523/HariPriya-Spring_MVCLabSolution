<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<title>Student- Add</title>
<meta charset="utf-8">
<meta name="viewport" 
	  content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet"
	  href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">
</head>
<body>
<div class="container">
	<h3> Add Student </h3>
	<form action="save" method="post">
			<input type="hidden" name="id" value="${student.id}">
			<div class="form-inline">
			<input type="text"  name="name" value="${student.name}" placeholder="Student Name" class="form-control mb-4 col-4">
			</div>
			<div class="form-inline">
			<input type="text"  name="department" value="${student.department}" placeholder="Student Department" class="form-control mb-4 col-4">
			</div>
			<div class="form-inline">
			<input type="text"  name="country" value="${student.country}" placeholder="Student Country" class="form-control mb-4 col-4">
			</div>
			<button type="submit" class="btn btn-info col-2">Submit</button>
		</form>
		<a href="list">Back to student List</a>
</div>	
</body>
</html>