<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div class="row">
	<div class="col-md-12 col-xs-12">
		<form:form class="form-horizontal" action="/admin/phone" method="POST"
			modelAttribute="phone">
			<div class="form-group">
				<label for="maker" class="col-sm-2 control-label">Maker</label>
				<div class="col-sm-10">
					<form:select class="form-control" path="maker" id="maker"
						items="${makers}" itemValue="id" itemLabel="name" />
				</div>
			</div>
			<div class="form-group">
				<label for="model" class="col-sm-2 control-label">Model</label>
				<div class="col-sm-10">
					<form:input class="form-control" path="model" id="model" />
				</div>
			</div>
			<div class="form-group">
				<label for="price" class="col-sm-2 control-label">Price</label>
				<div class="col-sm-10">
					<form:input class="form-control" path="price" id="price" />
				</div>
			</div>
			<div class="form-group">
				<label for="display" class="col-sm-2 control-label">Display</label>
				<div class="col-sm-10">
					<form:select class="form-control" path="display">
						<c:forEach items="${displays}" var="display">
							<form:option value="${display.id}">${display.size.size},
			${display.width.width}x${display.height.height},
			${display.technology.technology}</form:option>
						</c:forEach>
					</form:select>
				</div>
			</div>
			<div class="form-group">
				<label for="primaryCamera" class="col-sm-2 control-label">Primary
					Camera</label>
				<div class="col-sm-10">
					<form:input class="form-control" path="primaryCamera"
						id="primaryCamera" />
				</div>
			</div>
			<div class="form-group">
				<label for="secondaryCamera" class="col-sm-2 control-label">Secondary
					Camera</label>
				<div class="col-sm-10">
					<form:input class="form-control" path="secondaryCamera"
						id="secondaryCamera" />
				</div>
			</div>
			<div class="form-group">
				<label for="processor" class="col-sm-2 control-label">Processor</label>
				<div class="col-sm-10">
					<form:select class="form-control" path="processor">
						<c:forEach items="${processors}" var="processor">
							<form:option value="${processor.id}">${processor.maker.maker} - ${processor.model}</form:option>
						</c:forEach>
					</form:select>
				</div>
			</div>
			<div class="form-group">
				<label for="ram" class="col-sm-2 control-label">RAM</label>
				<div class="col-sm-10">
					<form:input class="form-control" path="ram" id="ram" />
				</div>
			</div>
			<div class="form-group">
				<label for="internal" class="col-sm-2 control-label">Internal</label>
				<div class="col-sm-10">
					<form:input class="form-control" path="internal" id="internal" />
				</div>
			</div>
			<div class="form-group">
				<label for="card" class="col-sm-2 control-label">Card</label>
				<div class="col-sm-10">
					<form:input class="form-control" path="card" id="card" />
				</div>
			</div>
			<div class="form-group">
				<label for="numberOfSimCards" class="col-sm-2 control-label">Number
					Of SimCards</label>
				<div class="col-sm-10">
					<form:input class="form-control" path="numberOfSimCards"
						id="numberOfSimCards" />
				</div>
			</div>
			<div class="form-group">
				<label for="operatingSystem" class="col-sm-2 control-label">Operating
					System</label>
				<div class="col-sm-10">
					<form:select class="form-control" path="operatingSystem">
						<c:forEach items="${operatingsystems}" var="operatingsystem">
							<form:option value="${operatingsystem.id}">${operatingsystem.name.name} - ${operatingsystem.version}</form:option>
						</c:forEach>
					</form:select>
				</div>
			</div>
			<div class="form-group">
				<label for="battery" class="col-sm-2 control-label">Battery</label>
				<div class="col-sm-10">
					<form:input class="form-control" path="battery" id="battery" />
				</div>
			</div>
			<div class="form-group">
				<label for="color" class="col-sm-2 control-label">Color</label>
				<div class="col-sm-10">
					<form:select class="form-control" path="color" id="color"
						items="${colors}" itemValue="id" itemLabel="color" />
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
		<h3>Phones</h3>
	</div>
	<div class="col-md-4 col-xs-4">
		<h3>Update</h3>
	</div>
	<div class="col-md-4 col-xs-4">
		<h3>Delete</h3>
	</div>
</div>
<c:forEach items="${phones}" var="phone">
	<div class="row">
		<div class="col-md-4 col-xs-4">
			<h3>${phone.maker.name}${phone.model}$${phone.price}</h3>
			<h4>Display: ${phone.display.size.size},
				${phone.display.width.width}x${phone.display.height.height},
				${phone.display.technology.technology}</h4>
			<h4>Camera: primary - ${phone.primaryCamera}, secondary -
				${phone.secondaryCamera}</h4>
			<h4>Processor: ${phone.processor.maker.maker}
				${phone.processor.model} ${phone.processor.frequency}Hz
				${phone.processor.numberOfCores.cores} cores</h4>
			<h4>Memory: RAM - ${phone.ram} internal - ${phone.internal} card
				- ${phone.card}</h4>
			<h4>Number Of SimCards: ${phone.numberOfSimCards}</h4>
			<h4>Operating System: ${phone.operatingSystem.name.name} -
				${phone.operatingSystem.version}</h4>
			<h4>Battery: ${phone.battery}</h4>
			<h4>Color: ${phone.color.color}</h4>
		</div>
		<div class="col-md-4 col-xs-4">
			<a class="btn btn-warning" href="/admin/phone/update/${phone.id}">update</a>
		</div>
		<div class="col-md-4 col-xs-4">
			<a class="btn btn-danger" href="/admin/phone/delete/${phone.id}">delete</a>
		</div>
	</div>
</c:forEach>