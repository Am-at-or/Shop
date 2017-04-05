<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="/WEB-INF/custom.tld" prefix="custom"%>
<h2 class="edit">ADD PROCESSOR TO THE DATABASE</h2>
<div class="container-fluid">
	<div class="row">
		<div class="col-md-8 col-md-offset-2">
			<form:form class="form" action="/admin/processor" method="POST"
				modelAttribute="processor">
				<custom:hiddenInputs
					excludeParams="maker, model, frequency, numberOfCores" />
				<div class="row">
					<div class="col-md-6">
						<div class="form-group">
							<label for="maker" class="control-label">Maker</label>
							<form:select class="form-control" path="maker" id="maker"
								items="${processormakers}" itemValue="id" itemLabel="maker" />
						</div>
					</div>
					<div class="col-md-6">
						<div class="form-group">
							<label for="model" class="control-label">Model</label> <label
								class="control-label" for="model"
								style="color: red; text-align: left;"><form:errors
									path="model" /></label>
							<form:input class="form-control" path="model" id="model" />
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-6">
						<div class="form-group">
							<label for="frequency" class="control-label">Frequency</label> <label
								class="control-label" for="frequency"
								style="color: red; text-align: left;"><form:errors
									path="frequency" /></label>
							<form:input class="form-control" path="frequency" id="frequency" />
						</div>
					</div>
					<div class="col-md-6">
						<div class="form-group">
							<label for="numberOfCores" class="control-label">Cores</label> <label
								class="control-label" for="numberOfCores"
								style="color: red; text-align: left;"><form:errors
									path="numberOfCores" /></label>
							<form:input class="form-control" path="numberOfCores"
								id="numberOfCores" />
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
						<a href="/admin/processor/cancel<custom:allParams/>"><button type="button"
								class="btn btn-danger">Cancel</button></a>
					</div>
				</div>
			</form:form>
		</div>
	</div>
	<div class="row">
		<div class="col-md-10">
			<form:form class="form-horizontal" action="/admin/processor"
				method="GET" modelAttribute="filter">
				<custom:hiddenInputs
					excludeParams="_makerIds, makerIds, modelFilter, minFrequency, maxFrequency, numberOfCoresFilter" />
				<div class="row">
					<div class="col-md-3">
						<label for="minFrequency" class="control-label row">Frequency</label>
						<div class="form-group">
							<form:input path="minFrequency" class="form-control min-max"
								placeholder="Min" />
							<form:input path="maxFrequency" class="form-control min-max"
								placeholder="Max" />
						</div>
					</div>
					<div class="col-md-2">
						<div class="form-group">
							<label for="modelFilter" class="control-label">Model</label>
							<form:input path="modelFilter" class="form-control"
								placeholder="Model" />
						</div>
					</div>

					<div class="col-md-2">
						<div class="form-group">
							<label for="numberOfCoresFilter" class="control-label">Number
								of cores</label>
							<form:input path="numberOfCoresFilter" class="form-control"
								placeholder="Cores" />
						</div>
					</div>
					<div class="col-md-2">
						<div class="form-group">
							<label for="maker" class="control-label">Maker</label>
							<form:select class="form-control chosen-select" path="makerIds"
								id="maker">
								<c:forEach items="${processormakers}" var="maker">
									<form:option value="${maker.id}">${maker.maker}</form:option>
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
						<custom:sort innerHtml="Maker asc" paramValue="maker" />
						<custom:sort innerHtml="Maker desc" paramValue="maker,desc" />
						<custom:sort innerHtml="Model asc" paramValue="model" />
						<custom:sort innerHtml="Model desc" paramValue="model,desc" />
						<custom:sort innerHtml="Frequency asc" paramValue="frequency" />
						<custom:sort innerHtml="Frequency desc"
							paramValue="frequency,desc" />
						<custom:sort innerHtml="Cores asc" paramValue="numberOfCores" />
						<custom:sort innerHtml="Cores desc"
							paramValue="numberOfCores,desc" />
					</ul>
				</div>
			</div>
			<div class="col-md-6 text-right btn-below">
				<custom:size posibleSizes="1,2,5,10" size="${page.size}" />
			</div>
		</div>
	</div>
	<div class="row">
		<table class="table table-striped text-center">
			<tr>
				<th class="text-center">Maker</th>
				<th class="text-center">Model</th>
				<th class="text-center">Frequency</th>
				<th class="text-center">Cores</th>
				<th class="text-center">Update</th>
				<th class="text-center">Delete</th>
			</tr>
			<c:forEach items="${page.content}" var="processor">
				<tr>
					<td>${processor.maker.maker}</td>
					<td>${processor.model}</td>
					<td>${processor.frequency}</td>
					<td>${processor.numberOfCores}</td>
					<td><a class="btn btn-warning"
						href="/admin/processor/update/${processor.id}<custom:allParams/>">Update</a></td>
					<td><a class="btn btn-danger"
						href="/admin/processor/delete/${processor.id}<custom:allParams/>">Delete</a></td>
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