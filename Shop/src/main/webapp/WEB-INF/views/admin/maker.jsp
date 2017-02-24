<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<form class="form-horizontal" action="/admin/maker" method="POST">
	<div class="form-group">
		<label for="name" class="col-md-2 control-label">Enter maker
			name:</label>
		<div class="col-md-10">
			<input class="form-control" type="text" name="name">
		</div>
	</div>
	<div class="form-group">
		<div class="col-md-offset-2 col-md-10">
			<button class="btn btn-default" type="submit">Create</button>
		</div>
	</div>
</form>
<h3>Available makers:</h3>
<ul>
	<c:forEach items="${makers}" var="maker">
		<li>${maker.name}<a href="/admin/maker/delete/${maker.id}">
				Delete</a></li>
	</c:forEach>
</ul>