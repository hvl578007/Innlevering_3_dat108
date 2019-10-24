<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!-- Fra https://purecss.io/ -->
<link rel="stylesheet"
	href="https://unpkg.com/purecss@1.0.0/build/pure-min.css">
<title>P�meldingsbekreftelse</title>
</head>
<body>
	<h2>P�meldingsbekreftelse</h2>
	<p>P�meldingen er mottatt for</p>
	<p>
		<font color="red">${feilDatabase}</font>
		&nbsp;&nbsp;&nbsp;<c:out value="${deltakar.fornamn}"/><br />
		&nbsp;&nbsp;&nbsp;<c:out value="${deltakar.etternamn}"/><br />
		&nbsp;&nbsp;&nbsp;<c:out value="${deltakar.mobilnummer}"/><br />
		&nbsp;&nbsp;&nbsp;<c:out value="${deltakar.kjoenn}"/><br />
	</p>
	<a href="deltakarliste">G� til deltagerlisten</a>
</body>
</html>