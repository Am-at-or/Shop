<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="/WEB-INF/custom.tld" prefix="custom"%>
<h2 class="edit">ADD PHONE TO THE DATABASE</h2>
<div class="row">
	<div class="col-md-8 col-md-offset-2">
		<form:form class="form" action="/admin/phone" method="POST"
			modelAttribute="phone" enctype="multipart/form-data">
			<custom:hiddenInputs
				excludeParams="maker, model, price, displayValue, displayResolution, primaryCamera, secondaryCamera, processor, ram, internal, card, numberOfSimCards, operatingSystem, battery, color, file" />
			<div class="row">
				<div class="col-md-12">
					<div class="form-group">
						<label for="maker" class="control-label maker">Maker</label>
						<form:select class="form-control input-below" path="maker"
							id="maker" items="${makers}" itemValue="id" itemLabel="name" />
					</div>
				</div>
			</div>
			<div class="row">
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
			</div>
			<div class="row">
				<div class="col-md-6">
					<div class="form-group">
						<label for="displayValue" class="control-label">Display
							size</label> <label class="control-label" for="displayValue"
							style="color: red; text-align: left;"><form:errors
								path="displayValue" /></label>
					</div>
					<div class="form-group">
						<form:input class="form-control" path="displayValue"
							id="displayValue" placeholder="Size" />
					</div>
				</div>
				<div class="col-md-6">
					<div class="form-group">
						<label for="displayResolution" class="control-label">Display
							resolution</label>
						<form:select class="form-control input-below"
							path="displayResolution">
							<c:forEach items="${displayresolutions}" var="displayresolution">
								<form:option value="${displayresolution.id}">${displayresolution.width}x${displayresolution.height}</form:option>
							</c:forEach>
						</form:select>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12">
					<div class="form-group">
						<label for="processor" class="control-label">Processor</label>
						<form:select class="form-control input-below" path="processor">
							<c:forEach items="${processors}" var="processor">
								<form:option value="${processor.id}">${processor.maker.maker} - ${processor.model}</form:option>
							</c:forEach>
						</form:select>
					</div>
				</div>
			</div>
			<div class="row">
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
			</div>
			<div class="row">
				<div class="col-md-4">
					<div class="form-group">
						<label for="ram" class="control-label">RAM</label> <label
							class="control-label" for="battery"
							style="color: red; text-align: left;"><form:errors
								path="ram" /></label>
					</div>
					<div class="form-group">
						<form:input class="form-control" path="ram" id="ram"
							placeholder="RAM" />
					</div>
				</div>
				<div class="col-md-4">
					<div class="form-group">
						<label for="internal" class="control-label">Internal</label> <label
							class="control-label" for="internal"
							style="color: red; text-align: left;"><form:errors
								path="internal" /></label>
					</div>
					<div class="form-group">
						<form:input class="form-control" path="internal" id="internal"
							placeholder="Internal" />
					</div>
				</div>
				<div class="col-md-4">
					<div class="form-group">
						<label for="card" class="control-label">Card</label> <label
							class="control-label" for="card"
							style="color: red; text-align: left;"><form:errors
								path="card" /></label>
					</div>
					<div class="form-group">
						<form:input class="form-control" path="card" id="card"
							placeholder="Card" />
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-4">
					<div class="form-group">
						<label for="operatingSystem" class="control-label">OS</label>
						<form:select class="form-control input-below"
							path="operatingSystem">
							<c:forEach items="${operatingsystems}" var="operatingsystem">
								<form:option value="${operatingsystem.id}">${operatingsystem.name.name} - ${operatingsystem.version}</form:option>
							</c:forEach>
						</form:select>
					</div>
				</div>
				<div class="col-md-4">
					<div class="form-group">
						<label for="numberOfSimCards" class="control-label">Sim
							cards</label> <label class="control-label" for="numberOfSimCards"
							style="color: red; text-align: left;"><form:errors
								path="numberOfSimCards" /></label>
					</div>
					<div class="form-group">
						<form:input class="form-control" path="numberOfSimCards"
							id="numberOfSimCards" placeholder="SIM" />
					</div>
				</div>
				<div class="col-md-4">
					<div class="form-group">
						<label for="color" class="control-label">Color</label>
						<form:select class="form-control input-below" path="color"
							id="color" items="${colors}" itemValue="id" itemLabel="color" />
					</div>
				</div>
			</div>
			<div class="form-group">
				<label for="file" class="control-label">Image</label> <input
					type="file" name="file" id="file">
			</div>
			<div class="form-group">
				<label class="control-label" for="ifExist"
					style="color: red; text-align: left;"><form:errors
						path="ifExist" /></label>
			</div>
			<div class="form-group">
				<div class="col-md-4 col-md-offset-4">
					<button type="submit" class="btn btn-success">Create</button>
					<a href="/admin/phone/cancel<custom:allParams/>"><button type="button"
								class="btn btn-danger">Cancel</button></a>
				</div>
			</div>
		</form:form>
	</div>
</div>
<div class="row">
	<div class="col-md-12">
		<form:form class="form-horizontal" action="/admin/phone" method="GET"
			modelAttribute="filter">
			<custom:hiddenInputs
				excludeParams="_makerIds, makerIds, modelFilter, minPrice, maxPrice, minDisplayValue, maxDisplayValue, _displayResolutionIds, displayResolutionIds, minPrimaryCamera, maxPrimaryCamera, minSecondaryCamera, maxSecondaryCamera, _processorIds, processorIds, minRam, maxRam, minInternal, maxInternal, minCard, maxCard, numberOfSimCardsFilter, _operatingSystemIds, operatingSystemIds, minBattery, maxBattery, _colorIds, colorIds" />
			<div class="row">
				<div class="col-md-2 col-md-offset-1">
					<div class="form-group">
						<label for="maker" class="control-label">Maker</label>
						<form:select class="form-control chosen-select" path="makerIds"
							id="maker">
							<c:forEach items="${makers}" var="maker">
								<form:option value="${maker.id}">${maker.name}</form:option>
							</c:forEach>
						</form:select>
					</div>
				</div>
				<div class="col-md-2">
					<div class="form-group">
						<label for="displayResolution" class="control-label">D.
							resolution</label>
						<form:select class="form-control chosen-select"
							path="displayResolutionIds" id="displayResolution">
							<c:forEach items="${displayresolutions}" var="displayResolution">
								<form:option value="${displayResolution.id}">${displayResolution.width}x${displayResolution.height}</form:option>
							</c:forEach>
						</form:select>
					</div>
				</div>
				<div class="col-md-2">
					<div class="form-group">
						<label for="processor" class="control-label">Processor</label>
						<form:select class="form-control chosen-select"
							path="processorIds" id="processor">
							<c:forEach items="${processors}" var="processor">
								<form:option value="${processor.id}">${processor.maker.maker} - ${processor.model}</form:option>
							</c:forEach>
						</form:select>
					</div>
				</div>
				<div class="col-md-2">
					<div class="form-group">
						<label for="operatingSystem" class="control-label">OS</label>
						<form:select class="form-control chosen-select"
							path="operatingSystemIds">
							<c:forEach items="${operatingsystems}" var="operatingsystem">
								<form:option value="${operatingsystem.id}">${operatingsystem.name.name} - ${operatingsystem.version}</form:option>
							</c:forEach>
						</form:select>
					</div>
				</div>
				<div class="col-md-2">
					<div class="form-group">
						<label for="color" class="control-label">Color</label>
						<form:select class="form-control chosen-select" path="colorIds">
							<c:forEach items="${colors}" var="color">
								<form:option value="${color.id}">${color.color}</form:option>
							</c:forEach>
						</form:select>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-1">
					<div class="form-group">
						<label for="minPrice" class="control-label">Price</label>
						<form:input path="minPrice" class="form-control" placeholder="Min" />
						<form:input path="maxPrice" class="form-control" placeholder="Max" />
					</div>
				</div>
				<div class="col-md-1">
					<div class="form-group">
						<label for="minDisplayValue" class="control-label">D. size</label>
						<form:input path="minDisplayValue" class="form-control"
							placeholder="Min" />
						<form:input path="maxDisplayValue" class="form-control"
							placeholder="Max" />
					</div>
				</div>
				<div class="col-md-1">
					<div class="form-group">
						<label for="minPrimaryCamera" class="control-label">Pr.
							cam.</label>
						<form:input path="minPrimaryCamera" class="form-control"
							placeholder="Min" />
						<form:input path="maxPrimaryCamera" class="form-control"
							placeholder="Max" />
					</div>
				</div>
				<div class="col-md-1">
					<div class="form-group">
						<label for="minSecondaryCamera" class="control-label">Sec.
							cam.</label>
						<form:input path="minSecondaryCamera" class="form-control"
							placeholder="Min" />
						<form:input path="maxSecondaryCamera" class="form-control"
							placeholder="Max" />
					</div>
				</div>
				<div class="col-md-1">
					<div class="form-group">
						<label for="minRam" class="control-label">Ram</label>
						<form:input path="minRam" class="form-control" placeholder="Min" />
						<form:input path="maxRam" class="form-control" placeholder="Max" />
					</div>
				</div>
				<div class="col-md-1">
					<div class="form-group">
						<label for="minInternal" class="control-label">Internal</label>
						<form:input path="minInternal" class="form-control"
							placeholder="Min" />
						<form:input path="maxInternal" class="form-control"
							placeholder="Max" />
					</div>
				</div>
				<div class="col-md-1">
					<div class="form-group">
						<label for="minCard" class="control-label">Card</label>
						<form:input path="minCard" class="form-control" placeholder="Min" />
						<form:input path="maxCard" class="form-control" placeholder="Max" />
					</div>
				</div>
				<div class="col-md-1">
					<div class="form-group">
						<label for="minBattery" class="control-label">Battery</label>
						<form:input path="minBattery" class="form-control"
							placeholder="Min" />
						<form:input path="maxBattery" class="form-control"
							placeholder="Max" />
					</div>
				</div>
				<div class="col-md-1">
					<div class="form-group">
						<label for="modelFilter" class="control-label">Model</label>
						<form:input path="modelFilter" class="form-control"
							placeholder="Model" />
						<form:input path="numberOfSimCardsFilter" class="form-control"
							placeholder="SIM" />
					</div>
				</div>
				<div class="col-md-1 text-right">
					<div class="form-group">
						<button type="submit" class="btn btn-primary btn-below"
							style="width: 63px">Ok</button>
					</div>
				</div>
				<div class="col-md-2">
					<div class="col-md-6 text-left">
						<div class="dropdown">
							<button class="btn btn-primary dropdown-toggle btn-below"
								type="button" data-toggle="dropdown">
								Sort <span class="caret"></span>
							</button>
							<ul class="dropdown-menu">
								<custom:sort innerHtml="Maker asc" paramValue="maker.name" />
								<custom:sort innerHtml="Maker desc" paramValue="maker.name,desc" />
								<custom:sort innerHtml="Model asc" paramValue="model" />
								<custom:sort innerHtml="Model desc" paramValue="model,desc" />
								<custom:sort innerHtml="Price asc" paramValue="price" />
								<custom:sort innerHtml="Price desc" paramValue="price,desc" />
								<custom:sort innerHtml="Display size asc"
									paramValue="displayValue" />
								<custom:sort innerHtml="Display size desc"
									paramValue="displayValue,desc" />
								<custom:sort innerHtml="Primary camera asc"
									paramValue="primaryCamera" />
								<custom:sort innerHtml="Primary camera desc"
									paramValue="primaryCamera,desc" />
								<custom:sort innerHtml="Secondary camera asc"
									paramValue="secondaryCamera" />
								<custom:sort innerHtml="Secondary camera desc"
									paramValue="secondaryCamera,desc" />
								<custom:sort innerHtml="Battery asc" paramValue="battery" />
								<custom:sort innerHtml="Battery desc" paramValue="battery,desc" />
								<custom:sort innerHtml="RAM asc" paramValue="ram" />
								<custom:sort innerHtml="RAM desc" paramValue="ram,desc" />
								<custom:sort innerHtml="Internal memory asc"
									paramValue="internal" />
								<custom:sort innerHtml="Internal memory desc"
									paramValue="internal,desc" />
								<custom:sort innerHtml="Card memory asc" paramValue="card" />
								<custom:sort innerHtml="Card memory desc" paramValue="card,desc" />
								<custom:sort innerHtml="SIM asc" paramValue="numberOfSimCards" />
								<custom:sort innerHtml="SIM desc"
									paramValue="numberOfSimCards,desc" />
								<custom:sort innerHtml="Color asc" paramValue="color.color" />
								<custom:sort innerHtml="Color desc" paramValue="color.color,desc" />
							</ul>
						</div>
					</div>
					<div class="col-md-6 text-right btn-below">
						<custom:size posibleSizes="1,2,5,10" size="${page.size}" />
					</div>
				</div>
			</div>
		</form:form>
	</div>
</div>
<div class="row">
	<table class="table table-striped">
		<tr>
			<th>Image</th>
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
		<c:forEach items="${page.content}" var="phone">
			<tr>
				<td><img
					src="/images/phone/${phone.id}.jpg?version=${phone.version}"
					width="100"></td>
				<td>${phone.maker.name}${phone.model}$${phone.price}</td>
				<td>${phone.displayValue}
					(${phone.displayResolution.width}x${phone.displayResolution.height})</td>
				<td>Primary - ${phone.primaryCamera} Secondary -
					${phone.secondaryCamera}</td>
				<td>${phone.processor.maker.maker}${phone.processor.model}
					${phone.processor.frequency}GHz ${phone.processor.numberOfCores}
					cores</td>
				<td>RAM - ${phone.ram} Internal - ${phone.internal} Card -
					${phone.card}</td>
				<td>${phone.operatingSystem.name.name}-
					${phone.operatingSystem.version}</td>
				<td>${phone.numberOfSimCards}</td>
				<td>${phone.battery}</td>
				<td>${phone.color.color}</td>
				<td><a class="btn btn-warning"
					href="/admin/phone/update/${phone.id}<custom:allParams/>">Update</a></td>
				<td><a class="btn btn-danger"
					href="/admin/phone/delete/${phone.id}<custom:allParams/>">Delete</a></td>
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