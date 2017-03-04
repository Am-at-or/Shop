<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<h2 class="edit">ADD DISPLAY TO THE DATABASE</h2>
<div class="container-fluid">
	<div class="row">
		<div class="col-md-8 col-md-offset-2">
			<form:form class="form" action="/admin/display" method="POST"
				modelAttribute="display">
				<div class="form-group col-md-12">
					<label for="displaysize" class="control-label">Display Size</label>
					<form:select class="form-control" path="size" id="displaysize"
						items="${displaysizes}" itemValue="id" itemLabel="size" />
				</div>
				<div class="form-group col-md-6">
					<label for="displaywidth" class="control-label">Resolution
						Width</label>
					<form:select class="form-control" path="width" id="displaywidth"
						items="${displaywidths}" itemValue="id" itemLabel="width" />
				</div>
				<div class="form-group col-md-6">
					<label for="displayheight" class="control-label">Resolution
						Height</label>
					<form:select class="form-control" path="height" id="displayheight"
						items="${displayheights}" itemValue="id" itemLabel="height" />
				</div>
				<div class="form-group col-md-12">
					<label for="displaytechnology" class="control-label">Technology</label>
					<form:select class="form-control" path="technology"
						id="displaytechnology" items="${displaytechnologies}"
						itemValue="id" itemLabel="technology" />
				</div>
				<div class="form-group">
					<label class="control-label" for="technology"
						style="color: red; text-align: left;"><form:errors
							path="technology" /></label>
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
				<th class="text-center">Size</th>
				<th class="text-center">Width</th>
				<th class="text-center">Height</th>
				<th class="text-center">Technology</th>
				<th class="text-center">Update</th>
				<th class="text-center">Delete</th>
			</tr>
			<c:forEach items="${displays}" var="display">
				<tr>
					<td>${display.size.size}</td>
					<td>${display.width.width}</td>
					<td>${display.height.height}</td>
					<td>${display.technology.technology}</td>
					<td><a class="btn btn-warning"
						href="/admin/display/update/${display.id}">Update</a></td>
					<td><a class="btn btn-danger"
						href="/admin/display/delete/${display.id}">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</div>