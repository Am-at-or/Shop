<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div class="row">
	<div class="col-md-12 col-xs-12">
		<form:form class="form-horizontal" action="/admin/displaysize"
			method="POST" modelAttribute="displaysize">
			<div class="form-group">
				<label for="size" class="col-sm-2 control-label">Size</label>
				<div class="col-sm-10">
					<form:input class="form-control" path="size" id="size" />
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
		<h3>Display size</h3>
	</div>
	<div class="col-md-4 col-xs-4">
		<h3>Update</h3>
	</div>
	<div class="col-md-4 col-xs-4">
		<h3>Delete</h3>
	</div>
</div>
<c:forEach items="${displaysizes}" var="displaysize">
	<div class="row">
		<div class="col-md-4 col-xs-4">${displaysize.size}</div>
		<div class="col-md-4 col-xs-4">
			<a class="btn btn-warning"
				href="/admin/displaysize/update/${displaysize.id}">update</a>
		</div>
		<div class="col-md-4 col-xs-4">
			<a class="btn btn-danger"
				href="/admin/displaysize/delete/${displaysize.id}">delete</a>
		</div>
	</div>
</c:forEach>
