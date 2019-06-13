<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>topos list</title>
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
			<h2>Liste des topos</h2>

			<table class="table table-striped table-bordered">
				<tr>
					<th>nom</th>
					<th>description</th>
					<th>lieu</th>
					<th>statut</th>
					<th>utilisateur</th>






				</tr>

				<c:forEach var="tempTopo" items="${topos}">

					<c:url var="reservationLink" value="${tempTopo.topoId}/reservations/showResaForm">
					</c:url>



					<tr>
						<td>${tempTopo.nom}</td>
						<td>${tempTopo.description}</td>
						<td>${tempTopo.lieu}</td>
						<td>${tempTopo.statut}</td>
						<td>${tempTopo.utilisateur.userId}</td>


						<c:if test="${tempTopo.statut=='disponible'}" var="variable">

						 							<td><a href="${reservationLink}">Réserver</a>
							</td>
						</c:if>


					</tr>
				</c:forEach>
			</table>

		</div>
	</div>

</body>
</html>