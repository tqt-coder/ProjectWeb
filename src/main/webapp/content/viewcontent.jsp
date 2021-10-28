<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>  
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
</head>
<style><%@include file="/WEB-INF/css/mystyle1.css"%></style>
<body>
	<form action="/DoAn/search" method="post">
		<input name="search" type="text" placeholder="Search...">
		<button type="submit">Icon</button>
	</form>
	<form class="content">
		<div>
			<h1>View Content</h1>
		</div>
		<div class="view-content">
			<div class="cont ent-tb" id="viewlst">View Content List</div>
			<table id="viewtable" class="content-tb">
				<tr>
					<th>#</th>
					<th class="tb-title">Title</th>
					<th class="tb-brief">Brief</th>
					<th class="tb-cd">Created Date</th>
					<th class="tb-action">Action</th>
				</tr>

				<c:forEach items="${tbcontents}" var="row">
					<tr>
						<td><c:out value="${row.id}" /></td>
						<td><c:out value="${row.title}" /></td>
						<td><c:out value="${row.brief}" /></td>
						<td><c:out value="${row.updatetime}" /></td>
						<td><a
							href="./Update/Update.jsp?id=<c:out value='${row.id}' />">Edit</a>
							<a href="deletecontent?id=<c:out value='${row.id}' />">Delete</a>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</form>
</body>
</html>