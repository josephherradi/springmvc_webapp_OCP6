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
					<th>utilisateur</th>






				</tr>

				<c:forEach var="requestResalist" items="${requestResa}">

					<c:url var="acceptResaLink" value="/topos/${requestResalist.topo.topoId}/reservations/updateForm">
						<c:param name="resaId" value="${requestResalist.reservationId}" />

					</c:url>


					<tr>
						<td>${requestResalist.topo.nom}</td>
						<td>${requestResalist.topo.lieu}</td>
						<td>${requestResalist.statut}</td>
						<td>${requestResalist.utilisateur.userId}</td>

						<c:if test="${requestResalist.statut=='en attente'}"
							var="variable">

							<td><a href="${acceptResaLink}">Accepter</a></td>
						</c:if>
					</tr>
				</c:forEach>
			</table>

		</div>
	</div>

</body>
</html>