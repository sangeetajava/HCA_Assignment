<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Employee</title>
</head>
<body>
	<div class="container">
		<%@ include file="header.jsp" %>
		<h1>Edit Employee Page</h1>
		<c:if test="${message ne null}">
			<div class="alert alert-success"><strong>${message}</strong></div>
		</c:if>
		
		<form action="editEmployee" method="post">
			<div class="row">
				<div class="col-md-3">EmployeeName</div><div class="col-md-9"><input type="text" value="${employee.name }" name="name"></div>
			</div>
			</br>
			<div class="row">
				<div class="col-md-3">EmployeeAge</div><div class="col-md-9"><input type="number" value="${employee.age }" name="age"></div>
			</div>
			</br>
			<div class="row">
				<div class="col-md-3">SALARY</div><div class="col-md-9"><input type="number" value="${employee.salary }" name="salary"></div>
			</div>
			</br>
			<div class="row">
				<div class="col-md-3">Department</div><div class="col-md-9"><input type="text" value="${employee.department }" name="department"></div>
			</div>	
			<br>
			<div class="row">
				<div class="col-md-3">Address</div><div class="col-md-9"><input type="text" value="${employee.address }" name="address"></div>
			</div>	
			<br>
			<div class="row">
				<div class="col-md-3">Mobile</div><div class="col-md-9"><input type="text" value="${employee.mobile }" name="mobile"></div>
			</div>
			<button type="submit" class="btn btn-success">Update Employee</button>
		</form>
	</div>
</body>
</html>