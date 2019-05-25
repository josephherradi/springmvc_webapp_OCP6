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
			
			
			
				<form:form action="saveForm" cssClass="form-horizontal"
					method="post" modelAttribute="spot">
					<h2>Spot</h2>

					<form:hidden path="spotId" />

					<div class="form-group">
						<label for="spotName" class="col-md-3 control-label">Spot name</label>
						<div class="col-md-9">
							<form:input path="spotName" cssClass="form-control" />
						</div>
					</div>
					<div class="form-group">
						<label for="description" class="col-md-3 control-label">description</label>
						<div class="col-md-9">
							<form:input path="description" cssClass="form-control" />
						</div>
					</div>

					<div class="form-group">
						<label for="lieu" class="col-md-3 control-label">lieu</label>
						<div class="col-md-9">
							<form:input path="lieu" cssClass="form-control" />
						</div>
					</div>
					
					<div class="form-group">
						<label for="nbrSecteurs" class="col-md-3 control-label">nbr secteurs</label>
						<div class="col-md-9">
							<form:input path="nbrSecteurs" cssClass="form-control" />
						</div>
					</div>
					<div class="form-group">
						<label for="nbrVoies" class="col-md-3 control-label">nbr voies</label>
						<div class="col-md-9">
							<form:input path="nbrVoies" cssClass="form-control" />
						</div>
					</div>
					<div class="form-group">
						<label for="voieEquipee" class="col-md-3 control-label">voie equipee</label>
						<div class="col-md-9">
							<form:input path="voieEquipee" cssClass="form-control" />
						</div>
					</div>
<!-- 					<div class="form-group"> -->
<!-- 						<label for="dateAjout" class="col-md-3 control-label">date Ajout</label> -->
<!-- 						<div class="col-md-9"> -->
<%-- 							<form:input path="dateAjout" cssClass="form-control" /> --%>
<!-- 						</div> -->
<!-- 					</div> -->
					<div class="form-group">
						<label for="tagged" class="col-md-3 control-label">label tagged</label>
						<div class="col-md-9">
							<form:input path="tagged" cssClass="form-control" />
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