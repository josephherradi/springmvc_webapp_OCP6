<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Spring MVC 5 - form handling | Java Guides</title>
<link href="<c:url value="/resources/css/bootstrap.min.css" />"
	rel="stylesheet">
<script src="<c:url value="/resources/js/jquery-1.11.1.min.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>

</head>
<body>
	<div class="container">
		<div class="col-md-offset-1 col-md-10">
			<br>
			<div class="panel-body">
			
			
			
				<form:form action="save" cssClass="form-horizontal"
					method="post" modelAttribute="voie">
					<h2>Voie</h2>

					<form:hidden path="voieId" />

					<div class="form-group">
						<label for="nbrLongueurs" class="col-md-3 control-label">nbr Longueurs</label>
						<div class="col-md-9">
							<form:input path="nbrLongueurs" cssClass="form-control" />
						</div>
					</div>
					<div class="form-group">
						<label for="distanceSpits" class="col-md-3 control-label">distance spits</label>
						<div class="col-md-9">
							<form:input path="distanceSpits" cssClass="form-control" />
						</div>
					</div>

					<div class="form-group">
						<label for="remarques" class="col-md-3 control-label">remarques</label>
						<div class="col-md-9">
							<form:input path="remarques" cssClass="form-control" />
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