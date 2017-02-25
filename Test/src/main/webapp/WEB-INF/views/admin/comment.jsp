<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<form class="form-horizontal" action="/admin/comment" method="POST">
	<div class="form-group">
		<label for="textComment" class="col-md-2 control-label">Enter
			comment:</label>
		<div class="col-md-10">
			<input class="form-control" type="text" name="textComment">
		</div>
	</div>
	<div class="form-group">
		<div class="col-md-offset-2 col-md-10">
			<button class="btn btn-default" type="submit">Create</button>
		</div>
	</div>
</form>
<h3>Available comments:</h3>
<ul>
	<c:forEach items="${comments}" var="comment">
		<li>${comment.textComment}<br>${comment.date}<a
			href="/admin/comment/delete/${comment.id}"> Delete</a>
		</li>
	</c:forEach>
</ul>