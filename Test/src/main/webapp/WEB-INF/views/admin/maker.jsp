<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="/WEB-INF/custom.tld" prefix="custom"%>
<h2 class="edit">ADD PHONE MAKER TO THE DATABASE</h2>
<div class="container-fluid">
	<div class="row">
		<div class="col-md-8 col-md-offset-2">
			<form:form class="form" action="/admin/maker" method="POST"
				modelAttribute="maker">
				<div class="form-group">
					<label for="maker" class="control-label">Maker name</label> <label
						class="control-label" for="maker"
						style="color: red; text-align: left;"><form:errors
							path="name" /></label>
					<form:input class="form-control" path="name" id="maker" />
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
		<div class="col-md-4">
			<form:form class="form-inline" action="/admin/maker" method="GET"
				modelAttribute="filter">
				<custom:hiddenInputs excludeParams="search" />
				<div class="form-group">
					<form:input path="search" class="form-control" placeholder="Search" />
				</div>
				<button type="submit" class="btn btn-primary">Ok</button>
			</form:form>
		</div>
		<div class="col-md-8">
			<div class="col-md-1 text-left">
				<div class="dropdown">
					<button class="btn btn-primary dropdown-toggle" type="button"
						data-toggle="dropdown">
						Sort <span class="caret"></span>
					</button>
					<ul class="dropdown-menu">
						<custom:sort innerHtml="Name asc" paramValue="color" />
						<custom:sort innerHtml="Name desc" paramValue="color,desc" />
					</ul>
				</div>
			</div>
			<div class="col-md-2 text-right">
				<custom:size posibleSizes="1,2,5,10" size="${page.size}" />
			</div>
		</div>
	</div>
	<div class="row">
		<table class="table table-striped text-center">
			<tr>
				<th class="text-center">Maker name</th>
				<th class="text-center">Update</th>
				<th class="text-center">Delete</th>
			</tr>
			<c:forEach items="${page.content}" var="maker">
				<tr>
					<td>${maker.name}</td>
					<td><a class="btn btn-warning"
						href="/admin/maker/update/${maker.id}<custom:allParams/>">Update</a></td>
					<td><a class="btn btn-danger"
						href="/admin/maker/delete/${maker.id}<custom:allParams/>">Delete</a></td>
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