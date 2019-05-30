<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registration Page</title>
</head>
<body>

	<h3>Registration Page</h3>
	<form:form action="saveUser" cssClass="form-horizontal" method="post"
		modelAttribute="utilisateur">
		<div class="form-group">
			<label for="userId" class="col-md-3 control-label">user id</label>
			<div class="col-md-9">
				<form:input path="userId" cssClass="form-control" />
			</div>
		</div>
		<div class="form-group">
			<label for="password" class="col-md-3 control-label">password</label>
			<div class="col-md-9">
				<form:input path="password" type="password" cssClass="form-control" />
			</div>
			<div class="form-group">
				<div class="col-md-offset-3 col-md-9">
					<form:button cssClass="btn btn-primary">Submit</form:button>
				</div>
			</div>
		</div>

	</form:form>