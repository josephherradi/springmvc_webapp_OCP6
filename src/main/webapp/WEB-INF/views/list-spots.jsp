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
		<div class="col-md-offset-1 col-md-8">
		<br>
		<table class="table table-striped table-bordered">
		<tr>
							<th>description</th>
							<th>lieu</th>
							<th>name</th>
		</tr>
		
		<c:forEach var="tempSpot" items="${spots}">
		<tr>
			<td>	${tempSpot.description}</td>
			<td>	${tempSpot.lieu}</td>
			<td>	${tempSpot.spotName}</td>
		</tr>

		</c:forEach>
		</table>
	
	</div>
	</div>	 
</body>
</html>