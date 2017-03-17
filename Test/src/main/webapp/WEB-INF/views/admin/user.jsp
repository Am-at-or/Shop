<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="/WEB-INF/custom.tld" prefix="custom"%>
<h2 class="edit">ADD USER TO THE DATABASE</h2>
<div class="row">
	<div class="col-md-8 col-md-offset-2">
		<form:form class="form" action="/admin/user" method="POST"
			modelAttribute="user">
			<custom:hiddenInputs
				excludeParams="email, login, password, phoneNumber, firstName, lastName" />
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
<div class="row">
	<div class="col-md-12">
		<form:form class="form-horizontal" action="/admin/user" method="GET"
			modelAttribute="filter">
			<custom:hiddenInputs
				excludeParams="emailFilter, loginFilter, phoneNumberFilter, firstNameFilter, lastNameFilter" />
			<div class="col-md-10">
				<div class="col-md-2">
					<div class="form-group">
						<label for="emailFilter" class="control-label">Email</label>
						<form:input path="emailFilter" class="form-control"
							placeholder="Email" />
					</div>
				</div>
				<div class="col-md-2">
					<div class="form-group">
						<label for="loginFilter" class="control-label">Login</label>
						<form:input path="loginFilter" class="form-control"
							placeholder="Login" />
					</div>
				</div>
				<div class="col-md-2">
					<div class="form-group">
						<label for="phoneNumberFilter" class="control-label">Phone
							number</label>
						<form:input path="phoneNumberFilter" class="form-control"
							placeholder="Phone Number" />
					</div>
				</div>
				<div class="col-md-2">
					<div class="form-group">
						<label for="firstNameFilter" class="control-label">First
							Name</label>
						<form:input path="firstNameFilter" class="form-control"
							placeholder="First Name" />
					</div>
				</div>
				<div class="col-md-2">
					<div class="form-group">
						<label for="lastNameFilter" class="control-label">Last
							Name</label>
						<form:input path="lastNameFilter" class="form-control"
							placeholder="Last Name" />
					</div>
				</div>
				<div class="col-md-2 text-right">
					<div class="form-group">
						<button type="submit" class="btn btn-primary btn-below"
							style="width: 63px">Ok</button>
					</div>
				</div>
			</div>
			<div class="col-md-2">
				<div class="col-md-6 text-right">
					<div class="dropdown">
						<button class="btn btn-primary dropdown-toggle btn-below"
							type="button" data-toggle="dropdown">
							Sort <span class="caret"></span>
						</button>
						<ul class="dropdown-menu">
							<custom:sort innerHtml="Email asc" paramValue="email" />
							<custom:sort innerHtml="Email desc" paramValue="email,desc" />
							<custom:sort innerHtml="Login asc" paramValue="login" />
							<custom:sort innerHtml="Login desc" paramValue="login,desc" />
							<custom:sort innerHtml="Phone Number asc"
								paramValue="phoneNumber" />
							<custom:sort innerHtml="Phone Number desc"
								paramValue="phoneNumber,desc" />
							<custom:sort innerHtml="First Name asc" paramValue="firstName" />
							<custom:sort innerHtml="First Name desc"
								paramValue="firstName,desc" />
							<custom:sort innerHtml="Last Name asc" paramValue="lastName" />
							<custom:sort innerHtml="Last Name desc"
								paramValue="lastName,desc" />
						</ul>
					</div>
				</div>
				<div class="col-md-6 text-right btn-below">
					<custom:size posibleSizes="1,2,5,10" size="${page.size}" />
				</div>
			</div>
		</form:form>
	</div>
</div>
<div class="row">
	<table class="table table-striped text-center">
		<tr>
			<th class="text-center">Login</th>
			<th class="text-center">Email</th>
			<th class="text-center">Phone number</th>
			<th class="text-center">First name</th>
			<th class="text-center">Last name</th>
			<th class="text-center">Update</th>
			<th class="text-center">Delete</th>
		</tr>
		<c:forEach items="${page.content}" var="user">
			<tr>
				<td>${user.login}</td>
				<td>${user.email}</td>
				<td>${user.phoneNumber}</td>
				<td>${user.firstName}</td>
				<td>${user.lastName}</td>
				<td><a class="btn btn-warning"
					href="/admin/user/update/${user.id}<custom:allParams/>">Update</a></td>
				<td><a class="btn btn-danger"
					href="/admin/user/delete/${user.id}<custom:allParams/>">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
</div>
<div class="row">
	<div class="col-md-12 text-center">
		<custom:pageable page="${page}" cell="<li></li>"
			container="<ul class='pagination'></ul>" />
	</div>
</div>