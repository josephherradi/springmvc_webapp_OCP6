<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>reservations list</title>
<link href="<c:url value="/resources/css/bootstrap.min.css" />"
	rel="stylesheet">
</head>
<body>
	<div class="container">
		<div class="col-md-offset-1 col-md-10">
			<br>
			<p>
				<button type="button" name="back" onclick="history.back()">back</button>

			</p>
			<br> <br>
			<h2>Liste des reservations</h2>

			<table class="table table-striped table-bordered">
				<tr>
					<th>nom topo</th>
					<th>lieu</th>
					<th>statut réservation</th>
					<th>propriétaire topo</th>






				</tr>

				<c:forEach var="requestResalist" items="${requestResa}">




					<tr>
						<td>${requestResalist.topo.nom}</td>
						<td>${requestResalist.topo.lieu}</td>
						<td>${requestResalist.statut}</td>
						<td>${requestResalist.topo.utilisateur.userId}</td>



					</tr>
				</c:forEach>
			</table>

		</div>
	</div>

</body>
</html>