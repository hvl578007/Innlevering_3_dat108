<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!-- Fra https://purecss.io/ -->
<link rel="stylesheet"
	href="https://unpkg.com/purecss@1.0.0/build/pure-min.css">
<title>Påmelding</title>
</head>
<body>
	<h2>Påmelding</h2>
	<form method="post" class="pure-form pure-form-aligned">
		<fieldset>
			<div class="pure-control-group">
				<label for="fornamn">Fornamn:</label> <input type="text" name="fornamn" value="${fornamn}" /> 
					<font color="red">${feilFornamn}</font>
			</div>
			<div class="pure-control-group">
				<label for="etternamn">Etternamn:</label> <input type="text" name="etternamn" value="${etternamn}" /> 
					<font color="red">${feilEtternamn}</font>
			</div>
			<div class="pure-control-group">
				<label for="mobilnr">Mobilnr (8 siffer):</label> <input type="text" name="mobilnr" value="${mobilnr}" /> 
					<font color="red">${feilMobilnr}</font>
			</div>
			<div class="pure-control-group">
				<label for="passord">Passord:</label> <input type="password" name="passord" value="${passord}" /> 
					<font color="red">${feilPassord}</font>
			</div>
			<div class="pure-control-group">
				<label for="passordRepetert">Passord repetert:</label>
				<input type="password" name="passordRepetert" value="${passordRepetert}" /> 
					<font color="red">${feilPassordRep}</font>
			</div>
			<div class="pure-control-group">
				<label for="kjoenn">Kjønn:</label> <input type="radio" name="kjoenn" value="mann" />mann
				<input type="radio" name="kjoenn" value="kvinne"/>kvinne
				<font color="red">${feilKjoenn}</font>
				<!-- beholde kva knapp ein har trykt på? -->
			</div>
			<div class="pure-controls">
				<button type="submit" class="pure-button pure-button-primary">Meld meg på</button>
			</div>
		</fieldset>
	</form>
</body>
</html>