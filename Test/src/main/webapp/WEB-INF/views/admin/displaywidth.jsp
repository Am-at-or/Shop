<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div class="row">
	<div class="col-md-12 col-xs-12">
		<form:form class="form-horizontal" action="/admin/displaywidth"
			method="POST" modelAttribute="displaywidth">
			<div class="form-group">
				<label class="col-sm-10 col-sm-offset-2 control-label" for="width"
					style="color: red; text-align: left;"><form:errors
						path="width" /></label>
			</div>
			<div class="form-group">
				<label for="width" class="col-sm-2 control-label">Width</label>
				<div class="col-sm-10">
					<form:input class="form-control" path="width" id="width" />
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-10 col-sm-offset-2 control-label" for="ifExist"
					style="color: red; text-align: left;"><form:errors
						path="ifExist" /></label>
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
		<h3>Display width</h3>
	</div>
	<div class="col-md-4 col-xs-4">
		<h3>Update</h3>
	</div>
	<div class="col-md-4 col-xs-4">
		<h3>Delete</h3>
	</div>
</div>
<c:forEach items="${displaywidths}" var="displaywidth">
	<div class="row">
		<div class="col-md-4 col-xs-4">${displaywidth.width}</div>
		<div class="col-md-4 col-xs-4">
			<a class="btn btn-warning"
				href="/admin/displaywidth/update/${displaywidth.id}">update</a>
		</div>
		<div class="col-md-4 col-xs-4">
			<a class="btn btn-danger"
				href="/admin/displaywidth/delete/${displaywidth.id}">delete</a>
		</div>
	</div>
</c:forEach>
