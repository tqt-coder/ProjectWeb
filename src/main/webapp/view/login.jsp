<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>Login page</title>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css"
		integrity="sha512-NmLkDIU1C/C88wi324HBc+S2kLhi08PN5GDeUVVVC/BVt/9Izdsc9SVeVfA1UZbY3sHUlDSyRXhCzHfr6hmPPw=="
		crossorigin="anonymous" referrerpolicy="no-referrer" />
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
	<link href="https://fonts.googleapis.com/css2?family=Roboto:wght@100;300;400;500;700&display=swap" rel="stylesheet">

</head>
<style><%@include file="/WEB-INF/css/mystyle.css"%></style>
<body>
	<h2><%= request.getAttribute("msg") != null ? request.getAttribute("msg") : " " %></h2>
	<div class="app">

		<form class="form__login" action="/DoAn/controller.logincontroller" method="Post">
			<div class="login">
				<h2 class="login__title">Please Sign In</h2>
				<input class="form-login__input m-t-20" type="text" placeholder="E-mail" name="email"> <br>
				<input class="form-login__input" type="password" placeholder="Password" name="password">
				<br>
				<div class="login__check">
					<input class="login__check-input" type="checkbox" name="remember"> Remember me
				</div>
				<br>
				<button class="login__button">Login</button>
				<a class="login__link" href="/DoAn/view/register.jsp"> Click here to Register </a>
			</div>
		</form>
	</div>
</body>

</html>

