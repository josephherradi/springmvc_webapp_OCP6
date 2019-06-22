<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>liste commentaires</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

</head>
<body>
	<div class="container">
		<div class="col-md-offset-1 col-md-10">
		<br>
			<p>
				<a href="${pageContext.request.contextPath}/spots/list"> <span
					class="glyphicon glyphicon-home"></span>
				</a>
			</p>
			<br>
			<button type="button" name="back" onclick="history.back()">back</button>
			<br> <br>
			<p>
				<c:if test="${sessionScope.user !=null}" var="variable">

					<input type="button" value="Add commentaire"
						onclick="window.location.href='showForm'; return false;"
						class="btn btn-primary" />
					<br>
				</c:if>
			<h2>Liste des commentaires</h2>

			<table class="table table-striped table-bordered">
				<tr>
					<th>Commentaire</th>
					<th>utilisateur</th>
					<th>date</th>



				</tr>

				<c:forEach var="tempComment" items="${theComments}">

					<c:url var="updateLink" value="updateForm">
						<c:param name="commentId" value="${tempComment.commentId}" />
					</c:url>

					<c:url var="deleteLink" value="delete">
						<c:param name="commentId" value="${tempComment.commentId}" />
					</c:url>


					<tr>
						<td>${tempComment.contenu}</td>
						<td>${tempComment.utilisateur.userId}</td>
						<td>${tempComment.date}</td>

						<c:if
							test="${sessionScope.user == 'ADMIN' && sessionScope.user!=null}"
							var="variable">

							<td><a href="${updateLink}">Update</a>|<a
								href="${deleteLink}"
								onclick="if (!(confirm('Are you sure you want to delete ce commentaire?'))) return false">Delete</a>
							</td>
						</c:if>


					</tr>
				</c:forEach>
			</table>

		</div>
	</div>

</body>
</html>