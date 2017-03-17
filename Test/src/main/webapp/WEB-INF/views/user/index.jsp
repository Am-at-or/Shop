<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib uri="/WEB-INF/custom.tld" prefix="custom"%>
<div class="row">
	<div class="col-md-2">
		<form:form class="form-horizontal" action="/" method="GET"
			modelAttribute="filter">
			<custom:hiddenInputs
				excludeParams="_makerIds, makerIds, modelFilter, minPrice, maxPrice, minDisplayValue, maxDisplayValue, _displayResolutionIds, displayResolutionIds, minPrimaryCamera, maxPrimaryCamera, minSecondaryCamera, maxSecondaryCamera, _processorIds, processorIds, minRam, maxRam, minInternal, maxInternal, minCard, maxCard, numberOfSimCardsFilter, _operatingSystemIds, operatingSystemIds, minBattery, maxBattery, _colorIds, colorIds" />
			<div class="row">
				<div class="col-md-12">
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
				<div class="col-md-12">
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
				<div class="col-md-12">
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
				<div class="col-md-12">
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
				<div class="col-md-12">
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
				<div class="col-md-12">
					<label for="modelFilter" class="control-label row">Model</label>
					<div class="form-group">
						<form:input path="modelFilter" class="form-control"
							placeholder="Model" />
					</div>
				</div>
				<div class="col-md-12">
					<label for="numberOfSimCardsFilter" class="control-label row">SIM</label>
					<div class="form-group">
						<form:input path="numberOfSimCardsFilter" class="form-control"
							placeholder="SIM" />
					</div>
				</div>
				<div class="col-md-12">
					<label for="minPrice" class="control-label row">Price</label>
					<div class="form-group">
						<form:input path="minPrice" class="form-control min-max"
							placeholder="Min" />
						<form:input path="maxPrice" class="form-control min-max"
							placeholder="Max" />
					</div>
				</div>
				<div class="col-md-12">
					<label for="minDisplayValue" class="control-label row">Display
						size</label>
					<div class="form-group">
						<form:input path="minDisplayValue" class="form-control min-max"
							placeholder="Min" />
						<form:input path="maxDisplayValue" class="form-control min-max"
							placeholder="Max" />
					</div>
				</div>
				<div class="col-md-12">
					<label for="minPrimaryCamera" class="control-label row">Primary
						camera</label>
					<div class="form-group">
						<form:input path="minPrimaryCamera" class="form-control min-max"
							placeholder="Min" />
						<form:input path="maxPrimaryCamera" class="form-control min-max"
							placeholder="Max" />
					</div>
				</div>
				<div class="col-md-12">
					<label for="minSecondaryCamera" class="control-label row">Secondary
						camera</label>
					<div class="form-group">
						<form:input path="minSecondaryCamera" class="form-control min-max"
							placeholder="Min" />
						<form:input path="maxSecondaryCamera" class="form-control min-max"
							placeholder="Max" />
					</div>
				</div>
				<div class="col-md-12">
					<label for="minRam" class="control-label row">RAM</label>
					<div class="form-group row">
						<form:input path="minRam" class="form-control min-max"
							placeholder="Min" />
						<form:input path="maxRam" class="form-control min-max"
							placeholder="Max" />
					</div>
				</div>
				<div class="col-md-12">
					<label for="minInternal" class="control-label row">Internal</label>
					<div class="form-group">
						<form:input path="minInternal" class="form-control min-max"
							placeholder="Min" />
						<form:input path="maxInternal" class="form-control min-max"
							placeholder="Max" />
					</div>
				</div>
				<div class="col-md-12">
					<label for="minCard" class="control-label row">Card</label>
					<div class="form-group">
						<form:input path="minCard" class="form-control min-max"
							placeholder="Min" />
						<form:input path="maxCard" class="form-control min-max"
							placeholder="Max" />
					</div>
				</div>
				<div class="col-md-12">
					<label for="minBattery" class="control-label row">Battery</label>
					<div class="form-group">
						<form:input path="minBattery" class="form-control min-max"
							placeholder="Min" />
						<form:input path="maxBattery" class="form-control min-max"
							placeholder="Max" />
					</div>
				</div>
				<div class="col-md-12 text-left">
					<div class="form-group">
						<button type="submit" class="btn btn-primary" style="width: 63px">Ok</button>
					</div>
				</div>
			</div>
		</form:form>
	</div>
	<div class="col-md-10">
		<div class="col-md-12 row">
			<ul>
				<c:forEach items="${ord.phones}" var="phone">
					<li class="product text-center"><a><img class="photo"
							src="/images/phone/${phone.id}.jpg?version=${phone.version}"><br>
							${phone.maker.name} ${phone.model} ${phone.internal}GB
							${phone.color.color}</a>
						<p class="price">$${phone.price}</p>
				</c:forEach>
			</ul>
		</div>
		<div class="row">
			<div class="col-md-6">
				<h2>Mobile Phones</h2>
			</div>
			<div class="col-md-6">
				<div class="col-md-2 col-md-offset-8 text-left">
					<div class="dropdown">
						<button class="btn btn-primary dropdown-toggle btn-below"
							type="button" data-toggle="dropdown">
							Sort <span class="caret"></span>
						</button>
						<ul class="dropdown-menu">
							<custom:sort innerHtml="Maker asc" paramValue="maker" />
							<custom:sort innerHtml="Maker desc" paramValue="maker,desc" />
							<custom:sort innerHtml="Model asc" paramValue="model" />
							<custom:sort innerHtml="Model desc" paramValue="model,desc" />
							<custom:sort innerHtml="Price asc" paramValue="price" />
							<custom:sort innerHtml="Price desc" paramValue="price,desc" />
							<custom:sort innerHtml="Display size asc"
								paramValue="displayValue" />
							<custom:sort innerHtml="Display size desc"
								paramValue="displayValue,desc" />
							<custom:sort innerHtml="Display resolution asc"
								paramValue="displayResolution" />
							<custom:sort innerHtml="Display resolution desc"
								paramValue="displayResolution,desc" />
							<custom:sort innerHtml="Processor asc" paramValue="processor" />
							<custom:sort innerHtml="Processor desc"
								paramValue="processor,desc" />
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
							<custom:sort innerHtml="Operating system asc"
								paramValue="operatingSystem" />
							<custom:sort innerHtml="Operating system desc"
								paramValue="operatingSystem,desc" />
							<custom:sort innerHtml="SIM asc" paramValue="numberOfSimCards" />
							<custom:sort innerHtml="SIM desc"
								paramValue="numberOfSimCards,desc" />
							<custom:sort innerHtml="Color asc" paramValue="color" />
							<custom:sort innerHtml="Color desc" paramValue="color,desc" />
						</ul>
					</div>
				</div>
				<div class="col-md-2 text-right btn-below">
					<custom:size posibleSizes="1,2,5,10" size="${page.size}" />
				</div>
			</div>
			<div class="col-md-12 row">
				<ul>
					<c:forEach items="${page.content}" var="phone">
						<li class="product text-center"><a><img class="photo"
								src="/images/phone/${phone.id}.jpg?version=${phone.version}"><br>
								${phone.maker.name} ${phone.model} ${phone.internal}GB
								${phone.color.color}</a>
							<p class="price">$${phone.price}</p> <form:form
								style="display:inline-block;margin-top:8px;"
								action="/addtopackage/${phone.id}" method="POST">
								<button type="submit" class="btn btn-success">Add</button>
							</form:form></li>
					</c:forEach>
				</ul>
			</div>
		</div>
		<div class="row">
			<div class="col-md-12 text-center">
				<custom:pageable page="${page}" cell="<li></li>"
					container="<ul class='pagination'></ul>" />
			</div>
		</div>
	</div>
</div>
