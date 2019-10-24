<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!-- Fra https://purecss.io/ -->
<link rel="stylesheet"
	href="https://unpkg.com/purecss@1.0.0/build/pure-min.css">
<title>Deltakerliste</title>
</head>
<body>
	<h2>Deltakerliste</h2>
	<font color="red">${feilDatabase}</font>
	<table class="pure-table">
		<tr bgcolor="#cccccc">
			<th>Kjønn</th>
			<th align="left">Navn</th>
			<th align="left">Mobil</th>
		</tr>
		<c:forEach items="${liste}" var="d">
			<tr bgcolor="${d.mobilnummer == mobilnr ? "#aaffaa" : "#ffffff"}">
				<td align="center">${d.kjoennFormatert}</td>
				<td><c:out value="${d.fornamn}"/>&nbsp;<c:out value="${d.etternamn}"/></td>
				<td><c:out value="${d.mobilnrFormatert}"/></td>
			</tr>
		</c:forEach>
	</table>
	<p>
		<form action="loggut" method="POST" class="pure-form pure-form-aligned">
			<input type="submit" value="Ferdig" />
		</form>
		<!-- bruke form knapp som submitter til POST /loggut som s? redirecter/forward til jsp?-->
	</p>
</body>
</html>