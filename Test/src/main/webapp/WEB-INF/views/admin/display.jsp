<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div class="row">
	<div class="col-md-12 col-xs-12">
		<form:form class="form-horizontal" action="/admin/display"
			method="POST" modelAttribute="display">
			<div class="form-group">
				<label for="displaysize" class="col-sm-2 control-label">Display
					Size</label>
				<div class="col-sm-10">
					<form:select class="form-control" path="size" id="displaysize"
						items="${displaysizes}" itemValue="id" itemLabel="size" />
				</div>
			</div>
			<div class="form-group">
				<label for="displaywidth" class="col-sm-2 control-label">Resolution
					Width</label>
				<div class="col-sm-10">
					<form:select class="form-control" path="width" id="displaywidth"
						items="${displaywidths}" itemValue="id" itemLabel="width" />
				</div>
			</div>
			<div class="form-group">
				<label for="displayheight" class="col-sm-2 control-label">Resolution
					Height</label>
				<div class="col-sm-10">
					<form:select class="form-control" path="height" id="displayheight"
						items="${displayheights}" itemValue="id" itemLabel="height" />
				</div>
			</div>
			<div class="form-group">
				<label for="displaytechnology" class="col-sm-2 control-label">Technology</label>
				<div class="col-sm-10">
					<form:select class="form-control" path="technology"
						id="displaytechnology" items="${displaytechnologies}"
						itemValue="id" itemLabel="technology" />
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
		<h3>Displays</h3>
	</div>
	<div class="col-md-4 col-xs-4">
		<h3>Update</h3>
	</div>
	<div class="col-md-4 col-xs-4">
		<h3>Delete</h3>
	</div>
</div>
<c:forEach items="${displays}" var="display">
	<div class="row">
		<div class="col-md-4 col-xs-4">${display.size.size},
			${display.width.width}x${display.height.height},
			${display.technology.technology}</div>
		<div class="col-md-4 col-xs-4">
			<a class="btn btn-warning" href="/admin/display/update/${display.id}">update</a>
		</div>
		<div class="col-md-4 col-xs-4">
			<a class="btn btn-danger" href="/admin/display/delete/${display.id}">delete</a>
		</div>
	</div>
</c:forEach>