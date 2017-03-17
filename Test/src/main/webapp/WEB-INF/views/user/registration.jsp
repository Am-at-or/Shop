<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<div class="row">
	<div class="col-md-8 col-md-offset-2">
	<h2 class="edit">REGISTRATION</h2>
		<form:form class="form" style="margin-top:30px;" action="/registration" method="POST"
			modelAttribute="user">
			<div class="form-group">
				<label for="email" class="control-label">Email*</label> <label
					class="control-label" for="email"
					style="color: red; text-align: left;"><form:errors
						path="email" /></label>
				<form:input class="form-control" path="email" id="email" />
			</div>
			<div class="form-group">
				<label for="login" class="control-label">Login*</label> <label
					class="control-label" for="login"
					style="color: red; text-align: left;"><form:errors
						path="login" /></label>
				<form:input class="form-control" path="login" id="login" />
			</div>
			<div class="form-group">
				<label for="password" class="control-label">Password*</label> <label
					class="control-label" for="password"
					style="color: red; text-align: left;"><form:errors
						path="password" /></label>
				<form:input class="form-control" path="password" id="password" />
			</div>
			<div class="form-group">
				<label for="phoneNumber" class="control-label">Phone number</label>
				<label class="control-label" for="phoneNumber"
					style="color: red; text-align: left;"><form:errors
						path="phoneNumber" /></label>
				<form:input class="form-control" path="phoneNumber" id="phoneNumber" />
			</div>
			<div class="form-group">
				<label for="firstName" class="control-label">First name</label> <label
					class="control-label" for="firstName"
					style="color: red; text-align: left;"><form:errors
						path="firstName" /></label>
				<form:input class="form-control" path="firstName" id="firstName" />
			</div>
			<div class="form-group">
				<label for="lastName" class="control-label">Last name</label> <label
					class="control-label" for="lastName"
					style="color: red; text-align: left;"><form:errors
						path="lastName" /></label>
				<form:input class="form-control" path="lastName" id="lastName" />
			</div>
			<div class="form-group" style="margin-top: 45px">
				<div class="col-md-4 col-md-offset-4">
					<button type="submit" class="btn btn-success btn-block">Create</button>
				</div>
			</div>
		</form:form>
	</div>
</div>