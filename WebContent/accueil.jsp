<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.objis.gestionformationssession.metier.User" %>
<!DOCTYPE html>
<html>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
	<head>
		<meta charset="ISO-8859-1">
		<title>Accueil</title>
	</head>
	<body>
		
		<% User user = (User) session.getAttribute("utilisateur"); %>
		
		<div class="w3-container w3-blue">
  		<h2>Bienvenue, vous êtes sur la page d'accueil</h2>
	</div>
		<form action="MaServlet" method="post">
		
			<p>
  			<label>Email</label>
			<input disabled class="w3-input" name="login" placeholder="<%= user.getLogin() %>" ></p>
			<p>
		  	<label>Mot de passe</label>
		  	<input disabled class="w3-input" name="password" placeholder="<%= user.getPassword() %>"></p>
		 	<p>
			<label>ID de la session</label>
			<input disabled class="w3-input" name="id" placeholder="<%= session.getId() %>"></p>
		
		</form>
	</body>
</html>