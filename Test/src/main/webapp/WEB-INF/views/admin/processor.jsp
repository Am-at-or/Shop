<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<h2 class="edit">ADD PROCESSOR TO THE DATABASE</h2>
<div class="container-fluid">
	<div class="row">
		<div class="col-md-8 col-md-offset-2">
			<form:form class="form" action="/admin/processor" method="POST"
				modelAttribute="processor">
				<div class="form-group col-md-6">
					<label for="maker" class="control-label">Maker</label>
					<form:select class="form-control" path="maker" id="maker"
						items="${processormakers}" itemValue="id" itemLabel="maker" />
				</div>
				<div class="form-group col-md-6">
					<label for="model" class="control-label">Model</label> <label
						class="control-label" for="model"
						style="color: red; text-align: left;"><form:errors
							path="model" /></label>
					<form:input class="form-control" path="model" id="model" />
				</div>
				<div class="form-group col-md-6">
					<label for="numberOfCores" class="control-label">Cores</label>
					<form:select class="form-control" path="numberOfCores"
						id="numberOfCores" items="${numberofcoress}" itemValue="id"
						itemLabel="cores" />
				</div>
				<div class="form-group col-md-6">
					<label for="frequency" class="control-label">Frequency</label> <label
						class="control-label" for="frequency"
						style="color: red; text-align: left;"><form:errors
							path="frequency" /></label>
					<form:input class="form-control" path="frequency" id="frequency" />
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
				<th class="text-center">Maker</th>
				<th class="text-center">Model</th>
				<th class="text-center">Frequency</th>
				<th class="text-center">Cores</th>
				<th class="text-center">Update</th>
				<th class="text-center">Delete</th>
			</tr>
			<c:forEach items="${processors}" var="processor">
				<tr>
					<td>${processor.maker.maker}</td>
					<td>${processor.model}</td>
					<td>${processor.frequency}</td>
					<td>${processor.numberOfCores.cores}</td>
					<td><a class="btn btn-warning"
						href="/admin/processor/update/${processor.id}">Update</a></td>
					<td><a class="btn btn-danger"
						href="/admin/processor/delete/${processor.id}">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</div>