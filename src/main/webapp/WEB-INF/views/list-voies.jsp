<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>voie lists</title>
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
			<br>
			<c:if test="${sessionScope.user == spot.utilisateur.userId}"
				var="variable">

				<input type="button" value="Add voie"
					onclick="window.location.href='showForm'; return false;"
					class="btn btn-primary" />
			</c:if>


			<br>
			<h2>Liste des voies</h2>

			<table class="table table-striped table-bordered">
				<tr>
					<th>nbr Longueurs</th>
					<th>distance Spits</th>
					<th>remarques</th>




				</tr>

				<c:forEach var="tempVoie" items="${voies}">

					<c:url var="updateLink" value="updateForm">
						<c:param name="voieId" value="${tempVoie.voieId}" />
					</c:url>

					<c:url var="deleteLink" value="delete">
						<c:param name="voieId" value="${tempVoie.voieId}" />
					</c:url>
					<c:url var="detailsLink"
						value="/spots/${tempVoie.spot.spotId}/voies/${tempVoie.voieId}/longueurs/list">
					</c:url>

					<tr>
						<td>${tempVoie.nbrLongueurs}</td>
						<td>${tempVoie.distanceSpits}</td>
						<td>${tempVoie.remarques}</td>
						<c:if
							test="${sessionScope.user == tempVoie.spot.utilisateur.userId && sessionScope.user!=null}"
							var="variable">

							<td><a href="${updateLink}">Update</a>|<a
								href="${deleteLink}"
								onclick="if (!(confirm('Are you sure you want to delete cette voie?'))) return false">Delete</a>
							</td>
						</c:if>
						<td><a href="${detailsLink}">Détails</a></td>


					</tr>
				</c:forEach>
			</table>

		</div>
	</div>

</body>
</html>