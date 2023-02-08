<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url var="image" value="/rs/image" />
<spring:url var="css" value="/rs/css" />
<spring:url var="js" value="/rs/js" />


<c:set var="contextRoot" value="${pageContext.request.contextPath}" />


<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Online shopping website">
<meta name="author" content="Debabrato Ghosh">

<title>${title}</title>

<script>
	window.contextRoot = '${contextRoot}';
</script>

<!-- Bootstrap core CSS -->
<link href="${css}/bootstrap.min.css" rel="stylesheet">
<!-- Datatable CSS -->
<link href="${css}/jquery.dataTables.css" rel="stylesheet">
<!-- Custom styles for this template -->
<link href="${css}/myStyle.css" rel="stylesheet">

</head>

<body>
	<div class="container">

		<div class="row">

			<div class="col-md-6">
				<h1>Personal Details</h1>
				
				<a href="${flowExecutionUrl}&_eventId_personal"
								class="btn btn-primary">Edit</a>
			</div>
			<div class="col-md-6">
				<h1>Billing Details</h1>
				<a href="${flowExecutionUrl}&_eventId_billing"
								class="btn btn-primary">Edit</a>
			</div>
			
			<a href="${flowExecutionUrl}&_eventId_success"
								class="btn btn-primary">Confirm</a>

		</div>


	</div>
	<!-- JQuery core JavaScript -->
	<script src="${js}/jquery.min.js"></script>

	<!-- Bootstrap core JavaScript -->
	<script src="${js}/bootstrap.min.js"></script>
	<!-- Datatable JavaScript -->
	<script src="${js}/dataTables.bootstrap.js"></script>
	<script src="${js}/jquery.dataTables.js"></script>
	<script src="${js}/bootbox.min.js"></script>
	<!-- Custom JavaScript -->
	<script src="${js}/myscript.js"></script>

</body>

</html>