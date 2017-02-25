<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div class="row">
	<div class="col-md-12 col-xs-12">
		<form:form class="form-horizontal" action="/admin/displaytechnology"
			method="POST" modelAttribute="displaytechnology">
			<div class="form-group">
				<label for="technology" class="col-sm-2 control-label">Technology</label>
				<div class="col-sm-10">
					<form:input class="form-control" path="technology" id="technology" />
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-default">Create</button>
				</div>
			</div>
		</form:form>
	</div>
</div>
<div class="row">
	<div class="col-md-4 col-xs-4">
		<h3>Display technology</h3>
	</div>
	<div class="col-md-4 col-xs-4">
		<h3>Update</h3>
	</div>
	<div class="col-md-4 col-xs-4">
		<h3>Delete</h3>
	</div>
</div>
<c:forEach items="${displaytechnologies}" var="displaytechnology">
	<div class="row">
		<div class="col-md-4 col-xs-4">${displaytechnology.technology}</div>
		<div class="col-md-4 col-xs-4">
			<a class="btn btn-warning"
				href="/admin/displaytechnology/update/${displaytechnology.id}">update</a>
		</div>
		<div class="col-md-4 col-xs-4">
			<a class="btn btn-danger"
				href="/admin/displaytechnology/delete/${displaytechnology.id}">delete</a>
		</div>
	</div>
</c:forEach>
