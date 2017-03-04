<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<h2 class="edit">ADD OPERATING SYSTEM TO THE DATABASE</h2>
<div class="container-fluid">
	<div class="row">
		<div class="col-md-8 col-md-offset-2">
			<form:form class="form" action="/admin/operatingsystem" method="POST"
				modelAttribute="operatingsystem">
				<div class="form-group col-md-6">
					<label for="name" class="control-label">Name</label>
					<form:select class="form-control" path="name" id="name"
						items="${osnames}" itemValue="id" itemLabel="name" />
				</div>
				<div class="form-group col-md-6">
					<label for="version" class="control-label">Version</label> <label
						class="control-label" for="version"
						style="color: red; text-align: left;"><form:errors
							path="version" /></label>
					<form:input class="form-control" path="version" id="version" />
				</div>
				<div class="form-group">
					<label class="control-label" for="ifExist"
						style="color: red; text-align: left;"><form:errors
							path="ifExist" /></label>
				</div>
				<div class="form-group">
					<div class=" col-md-4 col-md-offset-4">
						<button type="submit" class="btn btn-success btn-block">Create</button>
					</div>
				</div>
			</form:form>
		</div>
	</div>
	<div class="row">
		<table class="table table-striped text-center">
			<tr>
				<th class="text-center">OS name</th>
				<th class="text-center">Version</th>
				<th class="text-center">Update</th>
				<th class="text-center">Delete</th>
			</tr>
			<c:forEach items="${operatingsystems}" var="operatingsystem">
				<tr>
					<td>${operatingsystem.name.name}</td>
					<td>${operatingsystem.version}</td>
					<td><a class="btn btn-warning"
						href="/admin/operatingsystem/update/${operatingsystem.id}">Update</a></td>
					<td><a class="btn btn-danger"
						href="/admin/operatingsystem/delete/${operatingsystem.id}">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</div>