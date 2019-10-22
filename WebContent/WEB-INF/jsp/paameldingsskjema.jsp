<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!-- Fra https://purecss.io/ -->
<link rel="stylesheet"
	href="https://unpkg.com/purecss@1.0.0/build/pure-min.css">
<title>P�melding</title>
</head>
<body>
	<h2>P�melding</h2>
	<form method="post" class="pure-form pure-form-aligned">
		<fieldset>
			<div class="pure-control-group">
				<label for="fornamn">Fornamn:</label> <input type="text" name="fornamn" value="${skjemaInfo.fornamn}" /> 
					<font color="red">${skjemaInfo.fornamnFeil}</font>
			</div>
			<div class="pure-control-group">
				<label for="etternamn">Etternamn:</label> <input type="text" name="etternamn" value="${skjemaInfo.etternamn}" /> 
					<font color="red">${skjemaInfo.etternamnFeil}</font>
			</div>
			<div class="pure-control-group">
				<label for="mobilnr">Mobilnr (8 siffer):</label> <input type="text" name="mobilnr" value="${skjemaInfo.mobilnr}" /> 
					<font color="red">${skjemaInfo.mobilFeil}</font>
			</div>
			<div class="pure-control-group">
				<label for="passord">Passord:</label> <input type="password" name="passord" value="${skjemaInfo.passord}" /> 
					<font color="red">${skjemaInfo.passordFeil}</font>
			</div>
			<div class="pure-control-group">
				<label for="passordRepetert">Passord repetert:</label>
				<input type="password" name="passordRepetert" value="${skjemaInfo.passordRep}" /> 
					<font color="red">${skjemaInfo.passordRepFeil}</font>
			</div>
			<div class="pure-control-group">
				<label for="kjoenn">Kj�nn:</label> <input type="radio" name="kjoenn" value="mann" ${skjemaInfo.kjoenn == "mann" ? "checked" : ""}/>mann
				<input type="radio" name="kjoenn" value="kvinne" ${skjemaInfo.kjoenn == "kvinne" ? "checked" : ""}/>kvinne
				<font color="red">${skjemaInfo.kjoennFeil}</font>
				<!-- beholde kva knapp ein har trykt p�? -->
			</div>
			<div class="pure-controls">
				<button type="submit" class="pure-button pure-button-primary">Meld meg p�</button>
			</div>
		</fieldset>
	</form>
</body>
</html>