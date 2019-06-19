<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Spot lists</title>
<link href="<c:url value="/resources/css/bootstrap.min.css" />"
	rel="stylesheet">
<script src="<c:url value="/resources/js/jquery-1.11.1.min.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
</head>
<body>
	<div class="container">



		<div class="col-md-offset-2 col-md-9">
			<div style="text-align: right">
				<a href="${pageContext.request.contextPath}/account/logout"
					class="button medium hpbottom">Se déconnecter</a>
			</div>
			<p>Bienvenue ${sessionScope.user}</p>
			<br>
			<div style="text-align: left">
				<a href="${pageContext.request.contextPath}/spots/mylist"
					class="button medium hpbottom">Mes spots</a>
			</div>
			<br>
			<div style="text-align: left">
				<a href="${pageContext.request.contextPath}/topos/mylist"
					class="button medium hpbottom">Mes topos</a>
			</div>
			<br>

			<div style="text-align: left">
				<a href="${pageContext.request.contextPath}/topos/toposlist"
					class="button medium hpbottom">Consulter liste des topos</a>
			</div>
			<br>
			<div style="text-align: left">
				<a
					href="${pageContext.request.contextPath}/topos/reservations/userlist"
					class="button medium hpbottom">Mes réservations</a>
			</div>
			<br>

			<div style="text-align: left">
				<a
					href="${pageContext.request.contextPath}/topos/reservations/requestlist"
					class="button medium hpbottom">Réservations demandées</a>
			</div>


			<h3>Recherche par critère</h3>
			<br>

			<form:form
				action="${pageContext.request.contextPath }/spots/searchSpots"
				cssClass="form-horizontal" method="get">
				<br>
				<div class="form-group">
					<div class="col-md-offset-2 col-md-6">
						<label for="tagged"></label> <select class="form-control"
							name="tagged">
							<option value="" selected disabled>Spot tagged?</option>
							<option value="TRUE">VRAI</option>
							<option value="FALSE">FAUX</option>
						</select> <br> <select class="form-control" name="voieEquipee">
							<option value="" selected disabled>Voie Equipee?</option>
							<option value="TRUE">VRAI</option>
							<option value="FALSE">FAUX</option>
						</select> <br> <input name="lieu" class="form-control"
							placeholder="lieu" /> <br> <input name="nbrSecteurs"
							class="form-control" placeholder="nombre secteurs" /> <br>
						<button type="submit" class="btn btn-default btn-sm">Chercher</button>
					</div>
				</div>


			</form:form>

			<br>
			<h2>Liste des spots</h2>

			<c:if test="${sessionScope.user != null}" var="variable">
				<input type="button" value="Add Spot"
					onclick="window.location.href='${pageContext.request.contextPath }/spots/showForm'; return false;"
					class="btn btn-primary" />
			</c:if>
			<br> <br>
			<table class="table table-striped table-bordered">
				<tr>
					<th>name</th>
					<th>description</th>
					<th>lieu</th>
					<th>nombre secteurs</th>
					<th>tagged</th>
					<th>voie equipee</th>
					<th>utilisateur</th>




				</tr>

				<c:forEach var="tempSpot"
					items="${ empty spotsFound ? spots : spotsFound}">

					<c:url var="updateLink" value="/spots/updateForm">
						<c:param name="spotId" value="${tempSpot.spotId}" />
					</c:url>

					<c:url var="deleteLink" value="/spots/delete">
						<c:param name="spotId" value="${tempSpot.spotId}" />
					</c:url>

					<c:url var="detailsLink"
						value="/spots/${tempSpot.spotId}/voies/list">
					</c:url>
					<c:url var="commentsLink"
						value="/spots/${tempSpot.spotId}/commentaires/list">
					</c:url>
					<tr>
						<td>${tempSpot.spotName}</td>
						<td>${tempSpot.description}</td>
						<td>${tempSpot.lieu}</td>
						<td>${tempSpot.nbrSecteurs}</td>
						<td>${tempSpot.tagged == true ? "VRAI" : "FAUX"}</td>
						<td>${tempSpot.voieEquipee == true ? "VRAI" : "FAUX"}</td>
						<td>${tempSpot.utilisateur.userId}</td>

						<td><a href="${detailsLink}">Détails</a></td>
						<td><a href="${commentsLink}">Commentaires</a></td>


						<c:if
							test="${(sessionScope.user == tempSpot.utilisateur.userId || sessionScope.user == 'ADMIN')&& sessionScope.user!=null}"
							var="variable">

							<td><a href="${updateLink}">Update</a> <a
								href="${deleteLink}"
								onclick="if (!(confirm('Are you sure you want to delete this spot?'))) return false">Delete</a>
							</td>
						</c:if>




					</tr>
				</c:forEach>
			</table>

		</div>
	</div>

</body>
</html>