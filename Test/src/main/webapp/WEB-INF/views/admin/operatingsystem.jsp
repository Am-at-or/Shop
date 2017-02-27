<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div class="row">
	<div class="col-md-12 col-xs-12">
		<form:form class="form-horizontal" action="/admin/operatingsystem"
			method="POST" modelAttribute="operatingsystem">
			<div class="form-group">
				<label for="osname" class="col-sm-2 control-label">Operating
					System Name</label>
				<div class="col-sm-10">
					<form:select class="form-control" path="name" id="osname"
						items="${osnames}" itemValue="id" itemLabel="name" />
				</div>
			</div>
			<div class="form-group">
				<label for="version" class="col-sm-2 control-label">Version</label>
				<div class="col-sm-10">
					<form:input class="form-control" path="version" id="version" />
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
		<h3>Operating Systems</h3>
	</div>
	<div class="col-md-4 col-xs-4">
		<h3>Update</h3>
	</div>
	<div class="col-md-4 col-xs-4">
		<h3>Delete</h3>
	</div>
</div>
<c:forEach items="${operatingsystems}" var="operatingsystem">
	<div class="row">
		<div class="col-md-4 col-xs-4">${operatingsystem.name.name}
			${operatingsystem.version}</div>
		<div class="col-md-4 col-xs-4">
			<a class="btn btn-warning"
				href="/admin/operatingsystem/update/${operatingsystem.id}">update</a>
		</div>
		<div class="col-md-4 col-xs-4">
			<a class="btn btn-danger"
				href="/admin/operatingsystem/delete/${operatingsystem.id}">delete</a>
		</div>
	</div>
</c:forEach>