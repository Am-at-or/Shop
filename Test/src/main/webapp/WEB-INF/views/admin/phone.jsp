<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<form class="form-horizontal" action="/admin/phone" method="POST">
	<div class="form-group">
		<label for="model" class="col-md-2 control-label">Enter model:</label>
		<div class="col-md-10">
			<input class="form-control" type="text" name="model">
		</div>
	</div>
	<div class="form-group">
		<label for="price" class="col-md-2 control-label">Enter price:</label>
		<div class="col-md-10">
			<input class="form-control" type="text" name="price">
		</div>
	</div>
	<div class="form-group">
		<label for="primaryCamera" class="col-md-2 control-label">Enter
			primary camera:</label>
		<div class="col-md-10">
			<input class="form-control" type="text" name="primaryCamera">
		</div>
	</div>
	<div class="form-group">
		<label for="secondaryCamera" class="col-md-2 control-label">Enter
			secondary camera:</label>
		<div class="col-md-10">
			<input class="form-control" type="text" name="secondaryCamera">
		</div>
	</div>
	<div class="form-group">
		<label for="ram" class="col-md-2 control-label">Enter ram:</label>
		<div class="col-md-10">
			<input class="form-control" type="text" name="ram">
		</div>
	</div>
	<div class="form-group">
		<label for="internal" class="col-md-2 control-label">Enter
			internal memory:</label>
		<div class="col-md-10">
			<input class="form-control" type="text" name="internal">
		</div>
	</div>
	<div class="form-group">
		<label for="card" class="col-md-2 control-label">Enter card
			memory:</label>
		<div class="col-md-10">
			<input class="form-control" type="text" name="card">
		</div>
	</div>
	<div class="form-group">
		<label for="numberOfSimCards" class="col-md-2 control-label">Enter
			number of SIM cards:</label>
		<div class="col-md-10">
			<input class="form-control" type="text" name="numberOfSimCards">
		</div>
	</div>
	<div class="form-group">
		<label for="battery" class="col-md-2 control-label">Enter
			battery:</label>
		<div class="col-md-10">
			<input class="form-control" type="text" name="battery">
		</div>
	</div>
	<div class="form-group">
		<div class="col-md-offset-2 col-md-10">
			<button class="btn btn-default" type="submit">Create</button>
		</div>
	</div>
</form>
<h3>Available phones:</h3>
<ul>
	<c:forEach items="${phones}" var="phone">
		<li>${phone.model} $${phone.price}<br>Camera:
			${phone.primaryCamera}, ${phone.secondaryCamera}<br>Memory:
			${phone.internal}, ${phone.ram}, ${phone.card}<br>Number of SIM
			cards: ${phone.numberOfSimCards}<br>Battery: ${phone.battery}<a
			href="/admin/phone/delete/${phone.id}"> Delete</a>
		</li>
	</c:forEach>
</ul>