<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="ISO-8859-1">
	<title>All Employees</title>
	</head>
	<body>
		<div class="container">
		<%@ include file="header.jsp" %>
		<h1>List of all employees</h1>
		<c:if test="${message ne null}">
			<div class="alert alert-success">
				<strong>${message}</strong>
			</div>
		</c:if>
		<!-- Table creation START-->
		<table class="table table-hover table-bordered">
			<thead class="thead-dark">
				<tr>
				<th>Name</th>
				<th>Department</th>
				<th>Address</th>
				<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${allEmployee}" var="employee"> <!--  for(Employee emp :allEmployee)-->
					<tr>
						<td>${employee.name }</td>
						<td>${employee.department }</td>
						<td>${employee.address }</td>
						<td>
							<a href="getEmployee?employeeId=${employee.id}"> Emp Details</a>
							<a href="deleteEmployee?employeeId=${employee.id}"> <img alt="delete" src="img/delete.png" style="height: 40px"></a>
							<a href="editEmployee?employeeId=${employee.id}"> <img alt="delete" src="img/edit.png" style="height: 40px"></a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<!-- Table creation END-->
		</div>
	</body>
</html>