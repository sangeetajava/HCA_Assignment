<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Login</title>
</head>
<body>
	<%@ include file="header.jsp" %>
	<div class="container">
		<h1>Employee Login Page</h1>
		<c:if test="${message ne null}">
				<div class="alert alert-danger">${message}</div>
			</c:if>
			<div class="panel panel-primary">
			    <div class="panel panel-heading"></div>
			    <div class="panel panel-body">
			    	<form action="authentication" method="post"> <!-- login mapping with post  -->
						<div class="row">
							<div class="col-md-3">Email</div><div class="col-md-9"><input type="text" name="email"/></div>
						</div>
						</br>
						<div class="row">
							<div class="col-md-3">Password</div><div class="col-md-9"><input type="text" name="password"/></div>
						</div>
						<button type="submit" class="btn btn-success">Login</button>
					</form>
				</div>
			  </div>
			</div>
</body>
</html>