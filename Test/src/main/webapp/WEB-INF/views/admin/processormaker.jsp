<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="/WEB-INF/custom.tld" prefix="custom"%>
<h2 class="edit">ADD PROCESSOR MAKER TO THE DATABASE</h2>
<div class="container-fluid">
	<div class="row">
		<div class="col-md-8 col-md-offset-2">
			<form:form class="form" action="/admin/processormaker" method="POST"
				modelAttribute="processormaker">
				<div class="form-group">
					<label for="maker" class="control-label">Maker</label> <label
						class="control-label" for="maker"
						style="color: red; text-align: left;"><form:errors
							path="maker" /></label>
					<form:input class="form-control" path="maker" id="maker" />
				</div>
				<div class="form-group">
					<label class="control-label" for="maker"
						style="color: red; text-align: left;"><form:errors
							path="maker" /></label>
				</div>
				<div class="form-group">
					<div class=" col-md-4 col-md-offset-4">
						<button type="submit" class="btn btn-success">Create</button>
						<a href="/admin/processormaker/cancel<custom:allParams/>"><button type="button"
								class="btn btn-danger">Cancel</button></a>
					</div>
				</div>
			</form:form>
		</div>
	</div>
	<div class="row">
		<div class="col-md-4">
			<form:form class="form-inline" action="/admin/processormaker" method="GET"
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
						<custom:sort innerHtml="Name asc" paramValue="maker" />
						<custom:sort innerHtml="Name desc" paramValue="maker,desc" />
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
				<th class="text-center">Maker</th>
				<th class="text-center">Update</th>
				<th class="text-center">Delete</th>
			</tr>
			<c:forEach items="${page.content}" var="processormaker">
				<tr>
					<td>${processormaker.maker}</td>
					<td><a class="btn btn-warning"
						href="/admin/processormaker/update/${processormaker.id}<custom:allParams/>">Update</a></td>
					<td><a class="btn btn-danger"
						href="/admin/processormaker/delete/${processormaker.id}<custom:allParams/>">Delete</a></td>
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