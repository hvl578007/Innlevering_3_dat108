<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!-- Fra https://purecss.io/ -->
<link rel="stylesheet"
	href="https://unpkg.com/purecss@1.0.0/build/pure-min.css">
<title>Deltagerliste</title>
</head>
<body>
	<h2>Deltagerliste</h2>
	<table class="pure-table">
		<tr bgcolor="#cccccc">
			<th>Kjønn</th>
			<th align="left">Navn</th>
			<th align="left">Mobil</th>
		</tr>
		<tr bgcolor="#aaffaa">
			<td align="center">${deltakar.kjoenn == "mann" ? "&#9794;" : "&#9792;"}</td>
			<td><c:out value="${deltakar.fornamn}"/>&nbsp;<c:out value="${deltakar.etternamn}"/></td>
			<td><c:out value="${deltakar.mobilnummer}"/></td>
			<!-- fikse på mobilnr slik at det blir med mellomrom??: 123 45 678 -->
		</tr>
		<c:forEach items="${liste}" var="d">
			<tr bgcolor="#ffffff">
				<td align="center">${d.kjoenn == "mann" ? "&#9794;" : "&#9792;"}</td>
				<td><c:out value="${d.fornamn}"/>&nbsp;<c:out value="${d.etternamn}"/></td>
				<td><c:out value="${d.mobilnummer}"/></td>
			</tr>
		</c:forEach>
	</table>
	<p>
		<a href="loggut">Ferdig</a>
	</p>
</body>
</html>