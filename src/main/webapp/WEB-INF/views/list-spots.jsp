<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Spot lists</title>
<link href="<c:url value="/resources/css/bootstrap.min.css" />"
	rel="stylesheet">
</head>
<body>
	<div class="container">
		<div class="col-md-offset-1 col-md-10">

			<br> <input type="button" value="Add Spot"
				onclick="window.location.href='showForm'; return false;"
				class="btn btn-primary" /> <br>
			<h2>Liste des spots</h2>

				<table class="table table-striped table-bordered">
					<tr>
						<th>name</th>
						<th>description</th>
						<th>lieu</th>
						<th>nombre secteurs</th>
						<th>nombre voies</th>
						<th>voie equipee</th>




					</tr>

					<c:forEach var="tempSpot" items="${spots}">

						<c:url var="updateLink" value="/spots/updateForm">
							<c:param name="spotId" value="${tempSpot.spotId}" />
						</c:url>

						<c:url var="deleteLink" value="/spots/delete">
							<c:param name="spotId" value="${tempSpot.spotId}" />
						</c:url>
						
						<c:url var="detailsLink" value="/spots/${tempSpot.spotId}/voies/list">
						</c:url>
							
						<tr>
							<td>${tempSpot.spotName}</td>
							<td>${tempSpot.description}</td>
							<td>${tempSpot.lieu}</td>
							<td>${tempSpot.nbrSecteurs}</td>
							<td>${tempSpot.nbrVoies}</td>
							<td>${tempSpot.voieEquipee}</td>
							<td><a href="${updateLink}">Update</a> 
								<a href="${deleteLink}"
								
								onclick="if (!(confirm('Are you sure you want to delete this spot?'))) return false">Delete</a>
							</td>
							<td><a href="${detailsLink}">Détails</a> </td>
							

						</tr>
					</c:forEach>
				</table>

		</div>
	</div>

</body>
</html>