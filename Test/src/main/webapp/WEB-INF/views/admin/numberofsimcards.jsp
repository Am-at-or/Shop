<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<h2 class="edit">ADD NUMBER SIM TO THE DATABASE</h2>
<div class="container-fluid">
	<div class="row">
		<div class="col-md-8 col-md-offset-2">
			<form:form class="form" action="/admin/numberofsimcards"
				method="POST" modelAttribute="numberofsimcards">
				<div class="form-group">
					<label class="control-label" for="simCards"
						style="color: red; text-align: left;"><form:errors
							path="simCards" /></label>
				</div>
				<div class="form-group">
					<label for="simCards" class="control-label">Number SIM</label>
					<form:input class="form-control" path="simCards" id="simCards"/>
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
				<th class="text-center">Number SIM</th>
				<th class="text-center">Update</th>
				<th class="text-center">Delete</th>
			</tr>
			<c:forEach items="${numberofsimcardss}" var="numberofsimcards">
				<tr>
					<td>${numberofsimcards.simCards}</td>
					<td><a class="btn btn-warning"
						href="/admin/numberofsimcards/update/${numberofsimcards.id}">Update</a></td>
					<td><a class="btn btn-danger"
						href="/admin/numberofsimcards/delete/${numberofsimcards.id}">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</div>