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
			<br> <input type="button" value="Add longueur"
				onclick="window.location.href='showForm'; return false;"
				class="btn btn-primary" /> <br>
			<h2>Liste des longueurs</h2>

			<table class="table table-striped table-bordered">
				<tr>
					<th>valeur</th>
					<th>relai</th>
					<th>cotation</th>




				</tr>

				<c:forEach var="tempLongueur" items="${longueurs}">

					<c:url var="updateLink" value="updateForm">
						<c:param name="longueurId" value="${tempLongueur.id}" />
					</c:url>

					<c:url var="deleteLink" value="delete">
						<c:param name="longueurId" value="${tempLongueur.id}" />
					</c:url>

					<tr>
						<td>${tempLongueur.valeur}</td>
						<td>${tempLongueur.relai}</td>
						<td>${tempLongueur.cotation}</td>
						<td><a href="${updateLink}">Update</a>|<a
							href="${deleteLink}"
							onclick="if (!(confirm('Are you sure you want to delete cette longueur?'))) return false">Delete</a>
						</td>

					</tr>
				</c:forEach>
			</table>

		</div>
	</div>

</body>
</html>