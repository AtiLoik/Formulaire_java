<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.objis.gestionformationssession.metier.User" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Accueil</title>
	</head>
	<body>
		
		<% User user = (User) session.getAttribute("utilisateur"); %>
	
		<h1>Bienvenue, vous êtes sur la page d'accueil</h1>
		<h4>vos informations:</h4>
		<ul>
			<li>Login: <%= user.getLogin() %></li>
			<li>Password: <%= user.getPassword() %></li>
			<li>ID de la session: <%= session.getId() %></li>
		</ul>
	</body>
</html>