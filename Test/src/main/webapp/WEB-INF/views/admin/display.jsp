<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="/WEB-INF/custom.tld" prefix="custom"%>
<h2 class="edit">ADD DISPLAY TO THE DATABASE</h2>
<div class="container-fluid">
	<div class="row">
		<div class="col-md-8 col-md-offset-2">
			<form:form class="form" action="/admin/display" method="POST"
				modelAttribute="display">
				<custom:hiddenInputs
					excludeParams="value, width, height, technology" />
				<div class="form-group col-md-12">
					<label for="displayvalue" class="control-label">Display
						Size</label>
					<form:select class="form-control" path="value" id="displayvalue"
						items="${displayvalues}" itemValue="id" itemLabel="value" />
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
					<form:select class="form-control chosen-select" path="technology"
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
		<div class="col-md-8">
			<form:form class="form-horizontal" action="/admin/display"
				method="GET" modelAttribute="filter">
				<custom:hiddenInputs
					excludeParams="_displayValueIds, _displayWidthIds, _displayHeightIds, _displayTechnologyIds, displayValueIds, displayWidthIds, displayHeightIds, displayTechnologyIds" />
				<div class="col-md-2 form-group">
					<label for="displayvalue" class="control-label">Size</label>
					<form:select  items="${displayvalues}"
						path="displayValueIds" itemLabel="value" itemValue="id" />
				</div>
				<div class="col-md-3 form-group">
					<label for="displaywidth" class="control-label">Width</label>
					<form:select class="form-control" path="displayWidthIds"
						id="displaywidth">
						<c:forEach items="${displaywidths}" var="displaywidth">
							<form:option value="${displaywidth.id}">${displaywidth.width}</form:option>
						</c:forEach>
					</form:select>
				</div>
				<div class="col-md-3 form-group">
					<label for="displayheight" class="control-label">Height</label>
					<form:select class="form-control" path="displayHeightIds"
						id="displayheight">
						<c:forEach items="${displayheights}" var="displayheight">
							<form:option value="${displayheight.id }">${displayheight.height}</form:option>
						</c:forEach>
					</form:select>
				</div>

				<div class="col-md-3 form-group">
					<label for="displaytechnology" class="control-label">Technology</label>
					<form:select path="displayTechnologyIds" id="displaytechnology">
						<c:forEach items="${displaytechnologies}" var="displaytechnology">
							<form:option value="${displaytechnology.id }">${displaytechnology.technology}</form:option>
						</c:forEach>
					</form:select>
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
						<custom:sort innerHtml="Size asc" paramValue="value.value" />
						<custom:sort innerHtml="Size desc" paramValue="value.value,desc" />
						<custom:sort innerHtml="Width asc" paramValue="width.width" />
						<custom:sort innerHtml="Width desc" paramValue="width.width,desc" />
						<custom:sort innerHtml="Height asc" paramValue="height.height" />
						<custom:sort innerHtml="Height desc"
							paramValue="height.height,desc" />
						<custom:sort innerHtml="Technology asc"
							paramValue="technology.technology" />
						<custom:sort innerHtml="Technology desc"
							paramValue="technology.technology,desc" />
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
				<th class="text-center">Size</th>
				<th class="text-center">Width</th>
				<th class="text-center">Height</th>
				<th class="text-center">Technology</th>
				<th class="text-center">Update</th>
				<th class="text-center">Delete</th>
			</tr>
			<c:forEach items="${page.content}" var="display">
				<tr>
					<td>${display.value.value}</td>
					<td>${display.width.width}</td>
					<td>${display.height.height}</td>
					<td>${display.technology.technology}</td>
					<td><a class="btn btn-warning"
						href="/admin/display/update/${display.id}<custom:allParams/>">Update</a></td>
					<td><a class="btn btn-danger"
						href="/admin/display/delete/${display.id}<custom:allParams/>">Delete</a></td>
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