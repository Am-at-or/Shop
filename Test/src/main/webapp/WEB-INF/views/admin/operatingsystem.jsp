<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="/WEB-INF/custom.tld" prefix="custom"%>
<h2 class="edit">ADD OPERATING SYSTEM TO THE DATABASE</h2>
<div class="container-fluid">
	<div class="row">
		<div class="col-md-8 col-md-offset-2">
			<form:form class="form" action="/admin/operatingsystem" method="POST"
				modelAttribute="operatingsystem">
				<custom:hiddenInputs excludeParams="name, version" />
				<div class="row">
					<div class="col-md-6">
						<div class="form-group">
							<label for="name" class="control-label">Name</label>
							<form:select class="form-control" path="name" id="name"
								items="${osnames}" itemValue="id" itemLabel="name" />
						</div>
					</div>
					<div class="col-md-6">
						<div class="form-group">
							<label for="version" class="control-label">Version</label> <label
								class="control-label" for="version"
								style="color: red; text-align: left;"><form:errors
									path="version" /></label>
							<form:input class="form-control" path="version" id="version" />
						</div>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label" for="ifExist"
						style="color: red; text-align: left;"><form:errors
							path="ifExist" /></label>
				</div>
				<div class="form-group">
					<div class=" col-md-4 col-md-offset-4">
						<button type="submit" class="btn btn-success">Create</button>
						<a href="/admin/operatingsystem/cancel<custom:allParams/>"><button type="button"
								class="btn btn-danger">Cancel</button></a>
					</div>
				</div>
			</form:form>
		</div>
	</div>
	<div class="row">
		<div class="col-md-5">
			<form:form class="form-horizontal" action="/admin/operatingsystem"
				method="GET" modelAttribute="filter">
				<custom:hiddenInputs
					excludeParams="_nameIds, nameIds, minVersion, maxVersion" />
				<div class="row">
					<div class="col-md-6">
					<label for="minVersion" class="control-label row">Version</label>
						<div class="form-group">
							<form:input path="minVersion" class="form-control min-max"
								placeholder="Min" />
							<form:input path="maxVersion" class="form-control min-max"
								placeholder="Max" />
						</div>
					</div>
					<div class="col-md-4">
						<div class="form-group">
							<label for="name" class="control-label">Name OS</label>
							<form:select class="form-control chosen-select" path="nameIds"
								id="name">
								<c:forEach items="${osnames}" var="name">
									<form:option value="${name.id}">${name.name}</form:option>
								</c:forEach>
							</form:select>
						</div>
					</div>
					<div class="col-md-2 text-right">
						<div class="form-group">
							<button type="submit" class="btn btn-primary btn-below"
								style="width: 63px">Ok</button>
						</div>
					</div>
				</div>
			</form:form>
		</div>
		<div class="col-md-2">
			<div class="col-md-6 text-left btn-below">
				<div class="dropdown">
					<button class="btn btn-primary dropdown-toggle" type="button"
						data-toggle="dropdown">
						Sort <span class="caret"></span>
					</button>
					<ul class="dropdown-menu">
						<custom:sort innerHtml="Name asc" paramValue="name.name" />
						<custom:sort innerHtml="Name desc" paramValue="name.name,desc" />
						<custom:sort innerHtml="Version asc" paramValue="version" />
						<custom:sort innerHtml="Version desc" paramValue="version,desc" />
					</ul>
				</div>
			</div>
			<div class="col-md-6 text-left btn-below">
				<custom:size posibleSizes="1,2,5,10" size="${page.size}" />
			</div>
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
			<c:forEach items="${page.content}" var="operatingsystem">
				<tr>
					<td>${operatingsystem.name.name}</td>
					<td>${operatingsystem.version}</td>
					<td><a class="btn btn-warning"
						href="/admin/operatingsystem/update/${operatingsystem.id}<custom:allParams/>">Update</a></td>
					<td><a class="btn btn-danger"
						href="/admin/operatingsystem/delete/${operatingsystem.id}<custom:allParams/>">Delete</a></td>
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