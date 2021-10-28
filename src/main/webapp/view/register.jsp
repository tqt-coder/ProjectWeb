<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register page</title>

</head>
<style><%@include file="/WEB-INF/css/mystyle.css"%></style>
<body>
	<div class="app">


			<form class="form__login" action="/DoAn/registercontroller" method="Post">
				<div class="login">
					<h2 class="login__title">Register</h2>
					<input class="form-login__input m-t-20" type="text" placeholder="User name" name="username"> <br>
					<input class="form-login__input" type="text" placeholder="E-mail" name="email"> <br>
					<input class="form-login__input" type="password" placeholder="Password" name="password">
					<input class="form-login__input" type="password" placeholder="Re Password"
					name="repassword"> <br>
					<button class="login__button">Register</button>
					<a class="login__link" href="login.jsp"> Click here to Login </a>
					
				</div>
			</form>
	</div>
</body>
</html>