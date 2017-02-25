<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div class="row">
	<div class="col-md-12 col-xs-12">
		<form:form class="form-horizontal" action="/admin/processor"
			method="POST" modelAttribute="processor">
			<div class="form-group">
				<label for="maker" class="col-sm-2 control-label">Maker</label>
				<div class="col-sm-10">
					<form:select class="form-control" path="maker" id="maker"
						items="${processormakers}" itemValue="id" itemLabel="maker" />
				</div>
			</div>
			<div class="form-group">
				<label for="model" class="col-sm-2 control-label">Model</label>
				<div class="col-sm-10">
					<form:input class="form-control" path="model" id="model" />
				</div>
			</div>
			<div class="form-group">
				<label for="frequency" class="col-sm-2 control-label">Frequency</label>
				<div class="col-sm-10">
					<form:input class="form-control" path="frequency" id="frequency" />
				</div>
			</div>
			<div class="form-group">
				<label for="numberOfCores" class="col-sm-2 control-label">Number Of Cores</label>
				<div class="col-sm-10">
					<form:select class="form-control" path="numberOfCores" id="numberOfCores"
						items="${numberofcoress}" itemValue="id" itemLabel="cores" />
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
		<h3>Processors</h3>
	</div>
	<div class="col-md-4 col-xs-4">
		<h3>Update</h3>
	</div>
	<div class="col-md-4 col-xs-4">
		<h3>Delete</h3>
	</div>
</div>
<c:forEach items="${processors}" var="processor">
	<div class="row">
		<div class="col-md-4 col-xs-4">${processor.maker.maker} ${processor.model} (${processor.frequency} Hz, ${processor.numberOfCores.cores} Cores)</div>
		<div class="col-md-4 col-xs-4">
			<a class="btn btn-warning" href="/admin/processor/update/${processor.id}">update</a>
		</div>
		<div class="col-md-4 col-xs-4">
			<a class="btn btn-danger" href="/admin/processor/delete/${processor.id}">delete</a>
		</div>
	</div>
</c:forEach>