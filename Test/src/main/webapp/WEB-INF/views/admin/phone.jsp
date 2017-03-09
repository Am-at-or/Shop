<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<h2 class="edit">ADD PHONE TO THE DATABASE</h2>
<div class="container-fluid">
	<div class="row">
		<div class="col-md-8 col-md-offset-2">
			<form:form class="form" action="/admin/phone" method="POST"
				modelAttribute="phone">
				<div class="col-md-12">
					<div class="form-group">
						<label for="maker" class="control-label maker">Maker</label>
						<form:select class="form-control" path="maker" id="maker"
							items="${makers}" itemValue="id" itemLabel="name" />
					</div>
				</div>
				<div class="col-md-6">
					<div class="form-group">
						<label for="model" class="control-label">Model</label> <label
							class="control-label" for="model"
							style="color: red; text-align: left;"><form:errors
								path="model" /></label>
					</div>
					<div class="form-group">
						<form:input class="form-control" path="model" id="model"
							placeholder="Model" />
					</div>
				</div>
				<div class="col-md-6">
					<div class="form-group">
						<label for="price" class="control-label">Price</label> <label
							class="control-label" for="price"
							style="color: red; text-align: left;"><form:errors
								path="price" /></label>
					</div>
					<div class="form-group">
						<form:input class="form-control" path="price" id="price"
							placeholder="$ Price" />
					</div>
				</div>
				<div class="col-md-12">
					<div class="form-group">
						<label for="display" class="control-label">Display</label>
						<form:select class="form-control" path="display">
							<c:forEach items="${displays}" var="display">
								<form:option value="${display.id}">${display.value.value},
			${display.width.width}x${display.height.height},
			${display.technology.technology}</form:option>
							</c:forEach>
						</form:select>
					</div>
				</div>
				<div class="col-md-12">
					<div class="form-group">
						<label for="processor" class="control-label">Processor</label>
						<form:select class="form-control" path="processor">
							<c:forEach items="${processors}" var="processor">
								<form:option value="${processor.id}">${processor.maker.maker} - ${processor.model}</form:option>
							</c:forEach>
						</form:select>
					</div>
				</div>
				<div class="col-md-4">
					<div class="form-group">
						<label for="primaryCamera" class="control-label">Primary
							camera</label> <label class="control-label" for="primaryCamera"
							style="color: red; text-align: left;"><form:errors
								path="primaryCamera" /></label>
					</div>
					<div class="form-group">
						<form:input class="form-control" path="primaryCamera"
							id="primaryCamera" placeholder="Primary camera" />
					</div>
				</div>
				<div class="col-md-4">
					<div class="form-group">
						<label for="secondaryCamera" class="control-label">Secondary
							camera</label> <label class="control-label" for="secondaryCamera"
							style="color: red; text-align: left;"><form:errors
								path="secondaryCamera" /></label>
					</div>
					<div class="form-group">
						<form:input class="form-control" path="secondaryCamera"
							id="secondaryCamera" placeholder="Secondary camera" />
					</div>
				</div>
				<div class="col-md-4">
					<div class="form-group">
						<label for="battery" class="control-label">Battery</label> <label
							class="control-label" for="battery"
							style="color: red; text-align: left;"><form:errors
								path="battery" /></label>
					</div>
					<div class="form-group">
						<form:input class="form-control" path="battery" id="battery"
							placeholder="Battery" />
					</div>
				</div>
				<div class="col-md-4">
					<div class="form-group">
						<label for="ram" class="control-label">RAM</label>
						<form:select class="form-control" path="ram" id="ram"
							items="${rams}" itemValue="id" itemLabel="ram" />
					</div>
				</div>
				<div class="col-md-4">
					<div class="form-group">
						<label for="internal" class="control-label">Internal
							Memory</label>
						<form:select class="form-control" path="internal" id="internal"
							items="${internalmemories}" itemValue="id" itemLabel="internal" />
					</div>
				</div>
				<div class="col-md-4">
					<div class="form-group">
						<label for="card" class="control-label">Card Memory</label>
						<form:select class="form-control" path="card" id="card"
							items="${cardmemories}" itemValue="id" itemLabel="card" />
					</div>
				</div>
				<div class="col-md-4">
					<div class="form-group">
						<label for="operatingSystem" class="control-label">OS</label>
						<form:select class="form-control" path="operatingSystem">
							<c:forEach items="${operatingsystems}" var="operatingsystem">
								<form:option value="${operatingsystem.id}">${operatingsystem.name.name} - ${operatingsystem.version}</form:option>
							</c:forEach>
						</form:select>
					</div>
				</div>
				<div class="col-md-4">
					<div class="form-group">
						<label for="numberOfSimCards" class="control-label">Sim
							Cards</label>
						<form:select class="form-control" path="numberOfSimCards"
							id="numberOfSimCards" items="${numberofsimcardss}" itemValue="id"
							itemLabel="simCards" />
					</div>
				</div>
				<div class="col-md-4">
					<div class="form-group">
						<label for="color" class="control-label">Color</label>
						<form:select class="form-control" path="color" id="color"
							items="${colors}" itemValue="id" itemLabel="color" />
					</div>
				</div>
				<div class="form-group">
					<label class="control-label" for="ifExist"
						style="color: red; text-align: left;"><form:errors
							path="ifExist" /></label>
				</div>
				<div class="form-group">
					<div class="col-md-4 col-md-offset-4">
						<button type="submit" class="btn btn-success btn-block">Create</button>
					</div>
				</div>
			</form:form>
		</div>
	</div>
	<div class="row">
		<table class="table table-striped">
			<tr>
				<th>Model</th>
				<th>Display</th>
				<th>Camera</th>
				<th>Processor</th>
				<th>Memory</th>
				<th>Operating system</th>
				<th>SIM</th>
				<th>Battery</th>
				<th>Color</th>
				<th>Update</th>
				<th>Delete</th>
			</tr>
			<c:forEach items="${phones}" var="phone">
				<tr>
					<td>${phone.maker.name} ${phone.model} $${phone.price}</td>
					<td>${phone.display.value.value}
						(${phone.display.width.width}x${phone.display.height.height})
						${phone.display.technology.technology}</td>
					<td>Primary - ${phone.primaryCamera} Secondary -
						${phone.secondaryCamera}</td>
					<td>${phone.processor.maker.maker} ${phone.processor.model}
						${phone.processor.frequency}GHz
						${phone.processor.numberOfCores.cores} cores</td>
					<td>RAM - ${phone.ram.ram} Internal -
						${phone.internal.internal} Card - ${phone.card.card}</td>
					<td>${phone.operatingSystem.name.name} -
						${phone.operatingSystem.version}</td>
					<td>${phone.numberOfSimCards.simCards}</td>
					<td>${phone.battery}</td>
					<td>${phone.color.color}</td>
					<td><a class="btn btn-warning"
						href="/admin/phone/update/${phone.id}">Update</a></td>
					<td><a class="btn btn-danger"
						href="/admin/phone/delete/${phone.id}">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</div>