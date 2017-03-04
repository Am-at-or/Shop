<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<h2 class="edit">ADD INTERNAL MEMORY TO THE DATABASE</h2>
<div class="container-fluid">
	<div class="row">
		<div class="col-md-8 col-md-offset-2">
			<form:form class="form" action="/admin/internalmemory" method="POST"
				modelAttribute="internalmemory">
				<div class="form-group">
					<label for="internal" class="control-label">Internal</label> <label
						class="control-label" for="internal"
						style="color: red; text-align: left;"><form:errors
							path="internal" /></label>
					<form:input class="form-control" path="internal" id="internal" />
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
				<th class="text-center">Internal</th>
				<th class="text-center">Update</th>
				<th class="text-center">Delete</th>
			</tr>
			<c:forEach items="${internalmemories}" var="internalmemory">
				<tr>
					<td>${internalmemory.internal}</td>
					<td><a class="btn btn-warning"
						href="/admin/internalmemory/update/${internalmemory.id}">Update</a></td>
					<td><a class="btn btn-danger"
						href="/admin/internalmemory/delete/${internalmemory.id}">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</div>