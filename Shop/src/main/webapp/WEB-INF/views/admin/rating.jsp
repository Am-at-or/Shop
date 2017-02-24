<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<form class="form-horizontal" action="/admin/rating" method="POST">
	<div class="form-group">
		<label for="mark" class="col-md-2 control-label">Enter mark:</label>
		<div class="col-md-10">
			<input class="form-control" type="text" name="mark">
		</div>
	</div>
	<div class="form-group">
		<div class="col-md-offset-2 col-md-10">
			<button class="btn btn-default" type="submit">Create</button>
		</div>
	</div>
</form>
<h3>Available ratings:</h3>
<ul>
	<c:forEach items="${ratings}" var="rating">
		<li>${rating.mark}<a href="/admin/rating/delete/${rating.id}">
				Delete</a>
		</li>
	</c:forEach>
</ul>