<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2><%= request.getAttribute("msg") != null ? request.getAttribute("msg") : " " %></h2>
	<form action="/DoAn/controller.logincontroller" method="Post">
	name<input type="email" name="email">
	password<input type="password" name="password">
	<input type="submit" value="login">
	</form>
</body>
</html>