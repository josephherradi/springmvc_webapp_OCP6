<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
<link href="<c:url value="/resources/css/bootstrap.min.css" />"
	rel="stylesheet">
<script src="<c:url value="/resources/js/jquery-1.11.1.min.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>

</head>
<body>
	<div class="container" >
		<div class="col-md-8 col-md-offset-3">

			<div class="panel-body">

				<h3>Login Page</h3>
				${error }
				<form method="post"
					action="${pageContext.request.contextPath }/account/login">
					<div class="form-group" >
						<div class="col-md-10">

							<label for="Username">User Id:</label> <input type="text"
								name="userId" class="form-control">
						</div>
					</div>

					<div class="form-group">
						<div class="col-md-10">

							<label for="password">password</label> <input type="password"
								name="password" class="form-control">
						</div>
					</div>

					<div class="form-group">
						<div class="col-md-10">
							<br> <input type="submit" name="Login">
						</div>
					</div>



				</form>
			</div>
		</div>
	</div>

</body>
</html>