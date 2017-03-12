<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="/WEB-INF/custom.tld" prefix="custom"%>
<h2 class="edit">ADD DISPLAY RESOLUTION TO THE DATABASE</h2>
<div class="container-fluid">
	<div class="row">
		<div class="col-md-8 col-md-offset-2">
			<form:form class="form" action="/admin/displayresolution"
				method="POST" modelAttribute="displayresolution">
				<custom:hiddenInputs
					excludeParams="width, height" />
				<div class="form-group">
					<label for="width" class="control-label">Width</label> <label
						class="control-label" for="width"
						style="color: red; text-align: left;"><form:errors
							path="width" /></label>
					<form:input class="form-control" path="width" id="width" />
				</div>
				<div class="form-group">
					<label for="height" class="control-label">Height</label> <label
						class="control-label" for="height"
						style="color: red; text-align: left;"><form:errors
							path="height" /></label>
					<form:input class="form-control" path="height" id="height" />
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
		<div class="col-md-8">
			<form:form class="form-horizontal" action="/admin/displayresolution"
				method="GET" modelAttribute="filter">
				<custom:hiddenInputs
					excludeParams="minWidth, maxWidth, minHeight, maxHeight" />
				<div class="form-group col-md-5">
					<form:input path="minWidth" class="form-control" placeholder="Min" />
				</div>
				<div class="form-group col-md-5">
					<form:input path="maxWidth" class="form-control" placeholder="Max" />
				</div>
				<div class="form-group col-md-5">
					<form:input path="minHeight" class="form-control" placeholder="Min" />
				</div>
				<div class="form-group col-md-5">
					<form:input path="maxHeight" class="form-control" placeholder="Max" />
				</div>
				<button type="submit" class="btn btn-primary">Ok</button>
			</form:form>
		</div>
		<div class="col-md-4">
			<div class="col-md-3 text-left">
				<div class="dropdown">
					<button class="btn btn-primary dropdown-toggle" type="button"
						data-toggle="dropdown">
						Sort <span class="caret"></span>
					</button>
					<ul class="dropdown-menu">
						<custom:sort innerHtml="Width asc" paramValue="width" />
						<custom:sort innerHtml="Width desc" paramValue="width,desc" />
						<custom:sort innerHtml="Height asc" paramValue="height" />
						<custom:sort innerHtml="Height desc"
							paramValue="height,desc" />
					</ul>
				</div>
			</div>
			<div class="col-md-3 text-right">
				<custom:size posibleSizes="1,2,5,10" size="${page.size}" />
			</div>
		</div>
	</div>
	<div class="row">
		<table class="table table-striped text-center">
			<tr>
				<th class="text-center">Width</th>
				<th class="text-center">Height</th>
				<th class="text-center">Update</th>
				<th class="text-center">Delete</th>
			</tr>
			<c:forEach items="${page.content}" var="displayresolution">
				<tr>
					<td>${displayresolution.width}</td>
					<td>${displayresolution.height}</td>
					<td><a class="btn btn-warning"
						href="/admin/displayresolution/update/${displayresolution.id}<custom:allParams/>">Update</a></td>
					<td><a class="btn btn-danger"
						href="/admin/displayresolution/delete/${displayresolution.id}<custom:allParams/>">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<div class="row">
		<div class="col-md-12 text-center">
			<custom:pageable page="${page}" cell="<li></li>"
				container="<ul class='pagination'></ul>" />
		</div>
	</div>
</div>