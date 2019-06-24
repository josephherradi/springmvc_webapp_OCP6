<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Mes topos</title>
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

				<form:form action="saveOrUpdate" cssClass="form-horizontal"
					method="post" modelAttribute="leTopo">
					<h2>Topo</h2>

					<form:hidden path="topoId" />

					<div class="form-group">
						<label for="nom" class="col-md-3 control-label">nom</label>
						<div class="col-md-9">
							<form:input path="nom" cssClass="form-control" />
						</div>
					</div>
					<div class="form-group">
						<label for="date" class="col-md-3 control-label">date parution (YYYY-MM-DD)</label>
						<div class="col-md-9">
							<form:input path="date" cssClass="form-control" />
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
						<label for="statut" class="col-md-3 control-label">statut</label>
						<div class="col-md-9">
							<form:select path="statut" cssClass="form-control">
								<form:option value="disponible">disponible</form:option>
								<form:option value="indisponible">indisponible</form:option>
							</form:select>
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