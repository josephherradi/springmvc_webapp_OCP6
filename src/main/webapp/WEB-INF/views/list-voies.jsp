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
			<br> <input type="button" value="Add voie"
				onclick="window.location.href='showForm'; return false;"
				class="btn btn-primary" /> <br>
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
						<tr>
							<td>${tempVoie.nbrLongueurs}</td>
							<td>${tempVoie.distanceSpits}</td>
							<td>${tempVoie.remarques}</td>
							<td><a href="${updateLink}">Update</a> 
								<a href="${deleteLink}"
								
								onclick="if (!(confirm('Are you sure you want to delete this spot?'))) return false">Delete</a>
							</td>

						</tr>
					</c:forEach>
				</table>

		</div>
	</div>

</body>
</html>