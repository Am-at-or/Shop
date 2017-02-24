<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<form class="form-horizontal" action="/admin/processor" method="POST">
	<div class="form-group">
		<label for="maker" class="col-md-2 control-label">Enter maker:</label>
		<div class="col-md-10">
			<input class="form-control" type="text" name="maker">
		</div>
	</div>
	<div class="form-group">
		<label for="name" class="col-md-2 control-label">Enter name:</label>
		<div class="col-md-10">
			<input class="form-control" type="text" name="name">
		</div>
	</div>
	<div class="form-group">
		<label for="frequency" class="col-md-2 control-label">Enter frequency:</label>
		<div class="col-md-10">
			<input class="form-control" type="text" name="frequency">
		</div>
	</div>
	<div class="form-group">
		<label for="numberOfCores" class="col-md-2 control-label">Enter number of cores:</label>
		<div class="col-md-10">
			<input class="form-control" type="text" name="numberOfCores">
		</div>
	</div>
	<div class="form-group">
		<div class="col-md-offset-2 col-md-10">
			<button class="btn btn-default" type="submit">Create</button>
		</div>
	</div>
</form>
<h3>Available processors:</h3>
<ul>
	<c:forEach items="${processors}" var="processor">
		<li>${processor.maker} ${processor.name},
			${processor.frequency}Hz, ${processor.numberOfCores} cores<a
			href="/admin/processor/delete/${processor.id}"> Delete</a>
		</li>
	</c:forEach>
</ul>