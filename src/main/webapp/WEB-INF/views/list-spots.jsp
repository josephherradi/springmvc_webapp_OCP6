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
				<a href="${pageContext.request.contextPath}/spots/user/list"
					class="button medium hpbottom">Mes spots</a>
			</div>


			<h3>Recherche par critère</h3>
			<br>

			<form:form
				action="${pageContext.request.contextPath }/spots/searchSpots"
				cssClass="form-horizontal" method="get">
				<br>
				<div class="form-group">
					<div class="col-md-offset-2 col-md-4">
						<label for="tagged"></label> <select class="form-control"
							name="tagged">
							<option value="" selected disabled>Spot tagged?</option>
							<option value="TRUE">oui</option>
							<option value="FALSE">non</option>
						</select> <br> <select class="form-control" name="voieEquipee">
							<option value="" selected disabled>Voie Equipee?</option>
							<option value="TRUE">oui</option>
							<option value="FALSE">non</option>
						</select> <br> <input name="lieu" class="form-control"
							placeholder="lieu" /> <br> <input name="nbrSecteurs"
							class="form-control" placeholder="nombre secteurs" /> <br>
						<button type="submit" class="btn btn-default btn-sm">Chercher</button>
					</div>
				</div>


			</form:form>

			<br> <input type="button" value="Add Spot"
				onclick="window.location.href='${pageContext.request.contextPath }/spots/showForm'; return false;"
				class="btn btn-primary" /> <br>
			<h2>Liste des spots</h2>

			<table class="table table-striped table-bordered">
				<tr>
					<th>name</th>
					<th>description</th>
					<th>lieu</th>
					<th>nombre secteurs</th>
					<th>tagged</th>
					<th>voie equipee</th>




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

					<tr>
						<td>${tempSpot.spotName}</td>
						<td>${tempSpot.description}</td>
						<td>${tempSpot.lieu}</td>
						<td>${tempSpot.nbrSecteurs}</td>
						<td>${tempSpot.tagged}</td>
						<td>${tempSpot.voieEquipee}</td>
<%-- 						<td><a href="${updateLink}">Update</a> <a --%>
<%-- 							href="${deleteLink}" --%>
<!-- 							onclick="if (!(confirm('Are you sure you want to delete this spot?'))) return false">Delete</a> -->
<!-- 						</td> -->
						<td><a href="${detailsLink}">Détails</a></td>


					</tr>
				</c:forEach>
			</table>

		</div>
	</div>

</body>
</html>