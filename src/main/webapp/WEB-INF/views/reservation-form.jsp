<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Spring MVC 5 - form handling | Java Guides</title>
<link href="<c:url value="/resources/css/bootstrap.min.css" />"
	rel="stylesheet">
<script src="<c:url value="/resources/js/jquery-1.11.1.min.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>

</head>
<body>
	<div class="container">
		<div class="col-md-offset-1 col-md-10">

			<div class="panel-body">

				<br>
				<button type="button" name="back" onclick="history.back()">back</button>

				<br>
				<form:form action="saveOrUpdate" cssClass="form-horizontal"
					method="post" modelAttribute="laReservation">
					<h2>Reservation</h2>
					<form:hidden path="reservationId" />
					<form:hidden path="statut" />


					<div class="form-group">

						<div class="col-md-9">
							<h4>Valider la demande de réservation?</h4>
						</div>
					</div>


					<div class="form-group">
						<div class="col-md-offset-3 col-md-9">
							<form:button cssClass="btn btn-primary">OK</form:button>
						</div>
					</div>
					
				</form:form>
				



			</div>
		</div>
	</div>

</body>
</html>