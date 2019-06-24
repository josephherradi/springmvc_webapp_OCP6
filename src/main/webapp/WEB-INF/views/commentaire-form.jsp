<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Spring MVC 5 - form handling | Java Guides</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="<c:url value="/resources/js/jquery-1.11.1.min.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>

</head>
<body>
	<div class="container">
		<div class="col-md-offset-1 col-md-10">

			<div class="panel-body">
				<br>
				<button type="button" name="back" onclick="history.back()">back</button>

				<br>


				<form:form action="saveForm" cssClass="form-horizontal"
					method="post" modelAttribute="theComment">
					<h2>Commentaire</h2>

					<form:hidden path="commentId" />
					<form:hidden path="date" />
					

					<div class="form-group">
						<label for="contenu" class="col-md-3 control-label">Poster un commentaire</label>
						<div class="col-md-9">
							<form:input path="contenu" cssClass="form-control" />
						</div>
					</div>
					<div class="form-group">
						<div class="col-md-offset-3 col-md-9">
							<form:button cssClass="btn btn-primary">Submit</form:button>
						</div>
					</div>
				</form:form>


			</div>
		</div>
	</div>

</body>
</html>