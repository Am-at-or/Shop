<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<form class="form-horizontal" action="/admin/user" method="POST">
	<div class="form-group">
		<label for="login" class="col-md-2 control-label">Enter login:</label>
		<div class="col-md-10">
			<input class="form-control" type="text" name="login">
		</div>
	</div>
	<div class="form-group">
		<label for="password" class="col-md-2 control-label">Enter
			password:</label>
		<div class="col-md-10">
			<input class="form-control" type="text" name="password">
		</div>
	</div>
	<div class="form-group">
		<label for="email" class="col-md-2 control-label">Enter email:</label>
		<div class="col-md-10">
			<input class="form-control" type="text" name="email">
		</div>
	</div>
	<div class="form-group">
		<label for="phoneNumber" class="col-md-2 control-label">Enter
			phone number:</label>
		<div class="col-md-10">
			<input class="form-control" type="text" name="phoneNumber">
		</div>
	</div>
	<div class="form-group">
		<label for="firstName" class="col-md-2 control-label">Enter
			first name:</label>
		<div class="col-md-10">
			<input class="form-control" type="text" name="firstName">
		</div>
	</div>
	<div class="form-group">
		<label for="lastName" class="col-md-2 control-label">Enter
			last name:</label>
		<div class="col-md-10">
			<input class="form-control" type="text" name="lastName">
		</div>
	</div>
	<div class="form-group">
		<div class="col-md-offset-2 col-md-10">
			<button class="btn btn-default" type="submit">Create</button>
		</div>
	</div>
</form>
<h3>Available users:</h3>
<ul>
	<c:forEach items="${users}" var="user">
		<li>Login: ${user.login}, Password: ${user.password}, Email:
			${user.email}, Phone number: ${user.phoneNumber}, First name:
			${user.firstName}, Last name: ${user.lastName}<a
			href="/admin/user/delete/${user.id}"> Delete</a>
		</li>
	</c:forEach>
</ul>