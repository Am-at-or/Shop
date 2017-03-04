<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<h2 class="edit">ADD DISPLAY SIZE TO THE DATABASE</h2>
<div class="container-fluid">
	<div class="row">
		<div class="col-md-8 col-md-offset-2">
			<form:form class="form" action="/admin/displaysize" method="POST"
				modelAttribute="displaysize">
				<div class="form-group">
					<label class="control-label" for="size"
						style="color: red; text-align: left;"><form:errors
							path="size" /></label>
				</div>
				<div class="form-group">
					<label for="size" class="control-label">Size</label>
					<form:input class="form-control" path="size" id="size" />
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
				<th class="text-center">Display size</th>
				<th class="text-center">Update</th>
				<th class="text-center">Delete</th>
			</tr>
			<c:forEach items="${displaysizes}" var="displaysize">
				<tr>
					<td>${displaysize.size}</td>
					<td><a class="btn btn-warning"
						href="/admin/displaysize/update/${displaysize.id}">Update</a></td>
					<td><a class="btn btn-danger"
						href="/admin/displaysize/delete/${displaysize.id}">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</div>