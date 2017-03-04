<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<h2 class="edit">ADD COLOR TO THE DATABASE</h2>
<div class="container-fluid">
	<div class="row">
		<div class="col-md-8 col-md-offset-2">
			<form:form class="form" action="/admin/color" method="POST"
				modelAttribute="color">
				<div class="form-group">
					<label for="color" class="control-label">Color</label> <label
						class="control-label" for="color"
						style="color: red; text-align: left;"><form:errors
							path="color" /></label>
					<form:input class="form-control" path="color" id="color" />
				</div>
				<div class="form-group" style="margin-top: 45px">
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
				<th class="text-center">Color</th>
				<th class="text-center">Update</th>
				<th class="text-center">Delete</th>
			</tr>
			<c:forEach items="${colors}" var="color">
				<tr>
					<td>${color.color}</td>
					<td><a class="btn btn-warning"
						href="/admin/color/update/${color.id}">Update</a></td>
					<td><a class="btn btn-danger"
						href="/admin/color/delete/${color.id}">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</div>