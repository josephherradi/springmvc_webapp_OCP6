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
			<br>
			<c:if test="${sessionScope.user !=null}"
				var="variable">

				<input type="button" value="Add topo"
					onclick="window.location.href='showForm'; return false;"
					class="btn btn-primary" />
			</c:if>


			<br>
			<h2>Liste des topos</h2>

			<table class="table table-striped table-bordered">
				<tr>
					<th>nom</th>
					<th>description</th>
					<th>lieu</th>
					<th>statut</th>
					




				</tr>

				<c:forEach var="tempTopo" items="${topos}">

					<c:url var="updateLink" value="updateForm">
						<c:param name="topoId" value="${tempTopo.topoId}" />
					</c:url>

					<c:url var="deleteLink" value="delete">
						<c:param name="topoId" value="${tempTopo.topoId}" />
					</c:url>


					<tr>
						<td>${tempTopo.nom}</td>
						<td>${tempTopo.description}</td>
						<td>${tempTopo.lieu}</td>
						<td>${tempTopo.statut}</td>
						
						<c:if
							test="${sessionScope.user!=null}"
							var="variable">

							<td><a href="${updateLink}">Update</a>|<a
								href="${deleteLink}"
								onclick="if (!(confirm('Are you sure you want to delete ce topo?'))) return false">Delete</a>
							</td>
						</c:if>


					</tr>
				</c:forEach>
			</table>

		</div>
	</div>

</body>
</html>