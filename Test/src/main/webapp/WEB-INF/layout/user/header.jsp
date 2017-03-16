<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<div class="row">
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#myNavbar">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<div class="collapse navbar-collapse" id="myNavbar">
				<ul class="nav navbar-nav">
					<li><a href="/">Home</a></li>
					<li><a href="/faq">FAQ</a></li>
					<li><a href="/about">About us</a></li>
					<li><a href="/delivery">Delivery</a></li>
					<li><a href="/contacts">Contacts</a></li>
					<sec:authorize access="isAuthenticated()">
						<sec:authorize access="hasRole('ROLE_ADMIN')">
							<li><a href="/admin">Admin panel</a></li>
						</sec:authorize>
						<form:form style="display:inline-block;margin-top:8px;" action="/logout" method="POST">
							<button type="submit" class="btn btn-danger">Logout</button>
							<li><a href="/shoppingcart">Shopping Cart</a></li>
						</form:form>
					</sec:authorize>
					<sec:authorize access="!isAuthenticated()">
						<li><a href="/login">Login</a></li>
						<li><a href="/registration">Registration</a></li>
					</sec:authorize>
				</ul>
			</div>
		</div>
	</nav>
</div>